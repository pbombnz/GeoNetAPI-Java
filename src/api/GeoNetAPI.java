package api;

import api.deserializers.QuakeStatsCollection_Deserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.QuakeStatsCollection;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GeoNetAPI {
    private static final String API_URL = "http://api.geonet.org.nz/";

    private Retrofit retrofit;
    private GeoNetService service;


    public GeoNetAPI() {
        // Custom GSON created (with Deserializer for Quake Stats)
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(QuakeStatsCollection.class, new QuakeStatsCollection_Deserializer())
                .create();

        // Creating service.
        this.retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        this.service = retrofit.create(GeoNetService.class);
    }

    public GeoNetService getService() {
        return service;
    }
}
