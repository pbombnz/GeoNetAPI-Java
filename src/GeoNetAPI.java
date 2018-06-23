import com.google.gson.Gson;
import model.NewsFeed;
import model.QuakeInfoResponse;
import model.Volcano;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

public class GeoNetAPI {
    private static final String API_URL = "http://api.geonet.org.nz";

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


    public static NewsFeed getNews() {
        NewsFeed newsFeed = null;
        try {
            // API Request
            URL url = new URL(API_URL + NEWS_URI);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", API_HEADER_JSON);
            // Retrieve raw data
            InputStreamReader in = new InputStreamReader(con.getInputStream());
            // Covert raw data to Model instance.
            newsFeed = new Gson().fromJson(in, NewsFeed.class);
            // Close buffers and connections
            in.close();
            con.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newsFeed;
    }

    public static QuakeInfoResponse getQuakeInfo(String publicID) {
        String QUAKE_URL_CALL = getQuakeURI(publicID);

        QuakeInfoResponse quakeInfoResponse = null;
        try {
            // API Request
            URL url = new URL(QUAKE_URL_CALL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", API_HEADER_GEOJSON2);
            // Retrieve raw data
            InputStreamReader in = new InputStreamReader(con.getInputStream());
            // Covert raw data to Model instance.
            quakeInfoResponse = new Gson().fromJson(in, QuakeInfoResponse.class);
            // Close buffers and connections
            in.close();
            con.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return quakeInfoResponse;
    }

    public static Volcano getVolcanoAlertLevel() {
        Volcano volcanoResponse = null;
        try {
            // API Request
            URL url = new URL(API_URL + VOLCANO_URI);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", API_HEADER_GEOJSON2);
            // Retrieve raw data
            InputStreamReader in = new InputStreamReader(con.getInputStream());
            // Covert raw data to Model instance.
            volcanoResponse = new Gson().fromJson(in, Volcano.class);
            // Close buffers and connections
            in.close();
            con.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return volcanoResponse;
    }

    public static void main(String[] args) {
        //System.out.println(getNews());
        //System.out.println(getVolcanoAlertLevel());
        System.out.println(getQuakeInfo("2013p407387"));
        //System.out.println(getQuakeInfo(null));
    }
}
