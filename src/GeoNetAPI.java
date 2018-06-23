import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class GeoNetAPI {
    private static final String API_URL = "http://api.geonet.org.nz/";

    private static final String NEWS_URI = "/news/geonet";
    private static final String QUAKE_URI = "/quake/%publicID%";
    private static final String QUAKE_HISTORY_URI = "/quake/history/%publicID%";
    private static final String VOLCANO_URI = "/volcano/val";

    private static final String API_HEADER_JSON = "application/json;version=2";
    private static final  String API_HEADER_GEOJSON = "application/vnd.geo+json;version=1";
    private static final String API_HEADER_GEOJSON2 = "application/vnd.geo+json;version=2";

    private static String getQuakeURI(String publicID) {
        return API_URL + (QUAKE_URI.replaceFirst("%publicID%", publicID));
    }

    public GeoNetAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GeoNetService service = retrofit.create(GeoNetService.class);
        try {
            //System.out.println(service.getQuakeInfo("2014p715167").execute().body());
            //System.out.println(service.getVolcanoAlertLevel().execute().body());
            System.out.println(service.getFeltReports("reported").execute().body());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;

    }


    public static void main(String[] args) {
        //System.out.println(getNews());
        //System.out.println(getVolcanoAlertLevel());
        //System.out.println(getQuakeInfo("2013p407387"));
        //System.out.println(getQuakeInfo(null));
        new GeoNetAPI();
    }
}
