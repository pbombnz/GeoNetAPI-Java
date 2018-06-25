import api.GeoNetAPI;
import model.cad.QuakeCAD;
import model.cad.QuakeCADFeed;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import retrofit2.Call;

import java.io.IOException;

public class GeoNetCADTests {
    private static GeoNetAPI api;

    @BeforeClass
    public static void setUp() {
        api = new GeoNetAPI();
    }

    @Test
    public void getQuakeCADFeed_Tests() throws IOException {
        Call<QuakeCADFeed> quakeCADCall = api.getCADService().getQuakeCADFeed();
        Assert.assertTrue(quakeCADCall.execute().isSuccessful());
    }

    @Test
    public void getQuakeCAD_Tests() throws IOException {
        Call<QuakeCAD> quakeCADCall = api.getCADService().getQuakeCAD("2015p822263.1446357128542910");
        Assert.assertTrue(quakeCADCall.execute().isSuccessful());
    }
}
