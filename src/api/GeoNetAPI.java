package api;

import api.deserializers.QuakeStatsCollection_Deserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tickaroo.tikxml.TikXml;
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory;
import model.QuakeStatsCollection;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GeoNetAPI {
    private static final String API_URL = "http://api.geonet.org.nz/";

    private Retrofit retrofit;
    private GeoNetService service;

    private Retrofit cadRetrofit;
    private GeoNetCADService cadService;


    public GeoNetAPI() {
        // Custom GSON created for parsing JSON (with Deserializer for Quake Stats)
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(QuakeStatsCollection.class, new QuakeStatsCollection_Deserializer())
                .create();

        // Creating service.
        this.retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // TikXML created for parsing XML.
        TikXml tikXml = new TikXml.Builder().build();

        // Creating CAD service.
        this.cadRetrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(TikXmlConverterFactory.create(tikXml))
                .build();

        this.cadService = cadRetrofit.create(GeoNetCADService.class);
    }

    public GeoNetService getService() {
        return service;
    }

    public GeoNetCADService getCADService() { return cadService; }
}
