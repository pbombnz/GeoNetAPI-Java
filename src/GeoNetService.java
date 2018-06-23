import model.FeltReportCollection;
import model.NewsFeedCollection;
import model.QuakeInformationCollection;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface GeoNetService {
    String API_HEADER_JSON = "application/json;version=2";
    String API_HEADER_GEOJSON = "application/vnd.geo+json;version=1";
    String API_HEADER_GEOJSON2 = "application/vnd.geo+json;version=2";

    @Headers("Accept: " + API_HEADER_GEOJSON2)
    @GET("/intensity")
    Call<FeltReportCollection> getFeltReports(@Query("type") String type);

    @Headers("Accept: " + API_HEADER_GEOJSON2)
    @GET("/intensity")
    Call<FeltReportCollection> getFeltReports(@Query("type") String type, @Query("publicID") String publicID);

    /**
     * Retrieves feed of GeoNet news.
     *
     * @return A list of recent news items.
     */
    @Headers("Accept: " + API_HEADER_JSON)
    @GET("news/geonet")
    Call<NewsFeedCollection> getNews();

    @Headers("Accept: " + API_HEADER_GEOJSON2)
    @GET("quake/{publicID}")
    Call<QuakeInformationCollection> getQuakeInfo(@Path("publicID") String publicID);

    @Headers("Accept: " + API_HEADER_GEOJSON2)
    @GET("volcano/val")
    Call<QuakeInformationCollection> getVolcanoAlertLevel();
}
