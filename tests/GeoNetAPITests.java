import api.GeoNetAPI;
import model.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import retrofit2.Call;

import java.io.IOException;

public class GeoNetAPITests {
    private static GeoNetAPI api;

    @BeforeClass
    public static void setUp() {
        api = new GeoNetAPI();
    }

    @Test
    public void getFeltReports_Tests() throws IOException {
        Call<FeltReportCollection> feltReportCollectionCall;

        // Accepted Input
        feltReportCollectionCall = api.getService().getFeltReports("reported");
        Assert.assertTrue(feltReportCollectionCall.execute().isSuccessful());

        feltReportCollectionCall = api.getService().getFeltReports("measured");
        Assert.assertTrue(feltReportCollectionCall.execute().isSuccessful());

        feltReportCollectionCall = api.getService().getFeltReports("reported", "2013p407387");
        Assert.assertTrue(feltReportCollectionCall.execute().isSuccessful());

        // Accepted Input, although no results
        feltReportCollectionCall = api.getService().getFeltReports("measured", "2013p407387");
        Assert.assertFalse("measured data not available for individual publicID", feltReportCollectionCall.execute().isSuccessful());

        // Invalid Inputs
        feltReportCollectionCall = api.getService().getFeltReports("");
        Assert.assertFalse(feltReportCollectionCall.execute().isSuccessful());

        feltReportCollectionCall = api.getService().getFeltReports("abc123");
        Assert.assertFalse(feltReportCollectionCall.execute().isSuccessful());

        feltReportCollectionCall = api.getService().getFeltReports(null);
        Assert.assertFalse(feltReportCollectionCall.execute().isSuccessful());

        feltReportCollectionCall = api.getService().getFeltReports("reported", "");
        Assert.assertFalse(feltReportCollectionCall.execute().isSuccessful());

        feltReportCollectionCall = api.getService().getFeltReports("reported", "abc123");
        Assert.assertFalse(feltReportCollectionCall.execute().isSuccessful());
    }

    @Test
    public void getNews_Tests() throws IOException {
        Call<NewsFeedCollection> newsFeedCollectionCall = api.getService().getNews();
        Assert.assertTrue(newsFeedCollectionCall.execute().isSuccessful());
    }

    @Test
    public void getQuakeStats_Tests() throws IOException {
        Call<QuakeStatsCollection> quakeStatsCollectionCall = api.getService().getQuakeStats();
        Assert.assertTrue(quakeStatsCollectionCall.execute().isSuccessful());
    }

    @Test
    public void getQuakeByMagnitude_Tests() throws IOException {
        // Valid Inputs
        Call<QuakeInformationCollection> quakeInformationCollectionCall;
        for(int i = -1; i < 9; i++) {
            quakeInformationCollectionCall = api.getService().getQuakesByMagnitude(i);
            Assert.assertTrue(quakeInformationCollectionCall.execute().isSuccessful());
        }
        //Invalid Inputs
        quakeInformationCollectionCall = api.getService().getQuakesByMagnitude(1000);
        Assert.assertFalse(quakeInformationCollectionCall.execute().isSuccessful());

        quakeInformationCollectionCall = api.getService().getQuakesByMagnitude(-1000);
        Assert.assertFalse(quakeInformationCollectionCall.execute().isSuccessful());
    }

    @Test
    public void getQuakeInfo_Tests() throws IOException {
        // Valid Inputs
        Call<QuakeInformationCollection> quakeInformationCollectionCall = api.getService().getQuakeInfo("2014p715167");
        Assert.assertTrue(quakeInformationCollectionCall.execute().isSuccessful());

        // Invalid Inputs
        quakeInformationCollectionCall = api.getService().getQuakeInfo("");
        Assert.assertFalse(quakeInformationCollectionCall.execute().isSuccessful());

        quakeInformationCollectionCall = api.getService().getQuakeInfo("abc123");
        Assert.assertFalse(quakeInformationCollectionCall.execute().isSuccessful());

        try {
            quakeInformationCollectionCall = api.getService().getQuakeInfo(null);
            quakeInformationCollectionCall.execute();
            Assert.fail("Should not process this API call regardless of success or not.");
        } catch (IllegalArgumentException e) { }
    }

    @Test
    public void getQuakeHistory_Tests() throws IOException {
        // Valid Inputs
        Call<QuakeHistoryCollection> quakeHistoryCollectionCall = api.getService().getQuakeHistory("2014p715167");
        Assert.assertTrue(quakeHistoryCollectionCall.execute().isSuccessful());

        // Invalid Inputs
        quakeHistoryCollectionCall = api.getService().getQuakeHistory("");
        Assert.assertFalse(quakeHistoryCollectionCall.execute().isSuccessful());

        quakeHistoryCollectionCall = api.getService().getQuakeHistory("abc123");
        Assert.assertFalse(quakeHistoryCollectionCall.execute().isSuccessful());

        try {
            quakeHistoryCollectionCall = api.getService().getQuakeHistory(null);
            quakeHistoryCollectionCall.execute();
            Assert.fail("Should not process this API call regardless of success or not.");
        } catch (IllegalArgumentException e) { }
    }

    @Test
    public void getVolcanoAlertLevels_Tests() throws IOException {
        Call<VolcanoCollection> volcanoCollectionCall = api.getService().getVolcanoAlertLevel();
        Assert.assertTrue(volcanoCollectionCall.execute().isSuccessful());
    }
}
