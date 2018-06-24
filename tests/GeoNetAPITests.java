import api.GeoNetAPI;
import model.FeltReportCollection;
import model.NewsFeedCollection;
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
    public void Intensity_Tests() throws IOException {
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
    public void GeoNetNews_Tests() throws IOException {
        Call<NewsFeedCollection> newsFeedCollectionCall = api.getService().getNews();
        Assert.assertTrue(newsFeedCollectionCall.execute().isSuccessful());
    }
}
