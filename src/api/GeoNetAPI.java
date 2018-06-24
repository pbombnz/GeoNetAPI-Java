package api;

import api.deserializers.QuakeStatsCollection_Deserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.QuakeStatsCollection;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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

        // Use custom OkHttpClient to allow debug logs.
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        // Creating service.
        this.retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        this.service = retrofit.create(GeoNetService.class);
    }

    public GeoNetService getService() {
        return service;
    }
}
