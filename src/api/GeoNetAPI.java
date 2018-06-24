package api;

import api.deserializers.QuakeStatsCollection_Deserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory;
import model.QuakeStatsCollection;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class GeoNetAPI {
    private static final String API_URL = "http://api.geonet.org.nz/";


    public GeoNetAPI() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(QuakeStatsCollection.class, new QuakeStatsCollection_Deserializer())
                .create();


        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GeoNetService service = retrofit.create(GeoNetService.class);

        try {
            //System.out.println(service.getQuakeInfo("2014p715167").execute().body());
            //System.out.println(service.getVolcanoAlertLevel().execute().body());

            //System.out.println(service.getFeltReports("reported").execute().body());
            //System.out.println(service.getFeltReports("measured").execute().body());
            //System.out.println(service.getFeltReports("reported", "2013p407387").execute().body());
            //System.out.println(service.getQuakeHistory("2014p715167").execute().body());
            //Response<QuakeStatsCollection> rqsc = service.getQuakeStats().execute();
            //System.out.println(rqsc.body());
            //System.out.println(service.getQuakeStats().execute().raw());
            //System.out.println(service.getQuakesByMagnitude(3).execute().body());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        //System.out.println(getNews());
        //System.out.println(getVolcanoAlertLevel());
        //System.out.println(getQuakeInfo("2013p407387"));
        //System.out.println(getQuakeInfo(null));
        new GeoNetAPI();
    }
}
