package api;

import model.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface GeoNetService {
    String API_HEADER_JSON = "application/json;version=2";
    @Deprecated
    String API_HEADER_GEOJSON = "application/vnd.geo+json;version=1";
    String API_HEADER_GEOJSON2 = "application/vnd.geo+json;version=2";

    @Headers("Accept: " + API_HEADER_GEOJSON2)
    @GET("/intensity")
    Call<FeltReportCollection> getFeltReports(@Query("type") String type);

    @Headers("Accept: " + API_HEADER_GEOJSON2)
    @GET("/intensity")
    Call<FeltReportCollection> getFeltReports(@Query("type") String type, @Query("publicID") String publicID);

    @Headers("Accept: " + API_HEADER_JSON)
    @GET("news/geonet")
    Call<NewsFeedCollection> getNews();

    @GET("quake/stats")
    Call<QuakeStatsCollection> getQuakeStats();

    @Headers("Accept: " + API_HEADER_GEOJSON2)
    @GET("quake")
    Call<QuakeInformationCollection> getQuakesByMagnitude(@Query("MMI") int MMI);

    //@GET("cap/1.2/GPA1.0/feed/atom1.0/quake")
    //Call<QuakeCADFeed> getQuakeCADFeed();

    @Headers("Accept: " + API_HEADER_GEOJSON2)
    @GET("quake/{publicID}")
    Call<QuakeInformationCollection> getQuakeInfo(@Path("publicID") String publicID);

    @Headers("Accept: " + API_HEADER_GEOJSON2)
    @GET("quake/history/{publicID}")
    Call<QuakeHistoryCollection> getQuakeHistory(@Path("publicID") String publicID);

    @Headers("Accept: " + API_HEADER_GEOJSON2)
    @GET("volcano/val")
    Call<VolcanoCollection> getVolcanoAlertLevel();
}
