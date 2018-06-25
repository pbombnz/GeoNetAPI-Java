package api;

import model.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface GeoNetService {
    /*
     * API queries may be versioned via the Accept header. Please specify the Accept header for your request exactly as
     * specified for the endpoint query you are using. If you don't specify an Accept header with a version then your
     * request will be routed to the current highest API version of the query. Taking advantage of the API versioning
     * will pay dividends in the future for any client that you write
     */
    String API_HEADER_JSON = "application/json;version=2";
    String API_HEADER_GEOJSON = "application/vnd.geo+json;version=1";
    String API_HEADER_GEOJSON2 = "application/vnd.geo+json;version=2";

    /**
     * Retrieve shaking intensity information. Also known as Intensity on the GeoNet API Documentation.
     *
     * @param type The type of shaking information, either "reported" or "measured".
     * @return A {@Link FeltReportCollection} containing the shaking tensity information.
     */
    @Headers("Accept: " + API_HEADER_GEOJSON2)
    @GET("/intensity")
    Call<FeltReportCollection> getFeltReports(@Query("type") String type);


    /**
     * Retrieve shaking intensity information. Also known as Intensity on the GeoNet API Documentation.
     *
     * @param type The type of shaking information, either "reported" or "measured".
     * @param publicID A valid quake id. Returns shaking information in a time window around the quake time.
     *                 Only available when type is "reported".
     * @return A {@Link FeltReportCollection} containing the shaking tensity information.
     */
    @Headers("Accept: " + API_HEADER_GEOJSON2)
    @GET("/intensity")
    Call<FeltReportCollection> getFeltReports(@Query("type") String type, @Query("publicID") String publicID);


    /**
     * Retrieves GeoNet news.
     *
     * @return A {@link NewsFeedCollection} that contains a list of {@link NewsFeed}s.
     */
    @Headers("Accept: " + API_HEADER_JSON)
    @GET("news/geonet")
    Call<NewsFeedCollection> getNews();


    /**
     * Retrieves general quake statistics over the last 7, 28 and 365 days.
     *
     * @return A {@link QuakeStatsCollection} which contains:
     *          A map contains three keys that summarise magnitude by count over the last 7, 28, and 365 days;
     *          A map that contains the key "perDay" that gives a per day summary by count of quake occurence.
     */
    @GET("quake/stats")
    Call<QuakeStatsCollection> getQuakeStats();


    /**
     * Returns quakes possibly felt in the New Zealand region during the last 365 days up to a maximum of 100 quakes.
     *
     * @param MMI request quakes that may have caused shaking greater than or equal to the MMI value in the
     *            New Zealand region. Allowable values are -1..8 inclusive. -1 is used for quakes that are to small
     *            to calculate a stable MMI value for.
     * @return A {@link QuakeInformationCollection} that contains a list of {@link QuakeInformation}s.
     *         Usually there is only one item in the list.
     */
    @Headers("Accept: " + API_HEADER_GEOJSON2)
    @GET("quake")
    Call<QuakeInformationCollection> getQuakesByMagnitude(@Query("MMI") int MMI);


    /**
     * Retrieves information for a single quake.
     *
     * @param publicID A valid publicID for a quake.
     * @return A {@link QuakeInformationCollection} that contains a list of {@link QuakeInformation}s.
     *         Usually there is only one item in the list.
     */
    @Headers("Accept: " + API_HEADER_GEOJSON2)
    @GET("quake/{publicID}")
    Call<QuakeInformationCollection> getQuakeInfo(@Path("publicID") String publicID);


    /**
     * Retrieves kocation history for a single quake. Not all quakes have a location history.
     *
     * @param publicID A valid publicID for a quake
     * @return A {@link QuakeHistoryCollection} that contains a list of {@link QuakeHistory}s.
     */
    @Headers("Accept: " + API_HEADER_GEOJSON2)
    @GET("quake/history/{publicID}")
    Call<QuakeHistoryCollection> getQuakeHistory(@Path("publicID") String publicID);


    /**
     * Retrieves the current Volcanic Alert Level for volcanoes in the New Zealand.
     *
     * @return A {@;link VolcanoCollection} that returns a list of {@link Volcano}.
     */
    @Headers("Accept: " + API_HEADER_GEOJSON2)
    @GET("volcano/val")
    Call<VolcanoCollection> getVolcanoAlertLevel();
}
