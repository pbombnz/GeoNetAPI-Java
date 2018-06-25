package api;

import model.cad.QuakeCAD;
import model.cad.QuakeCADFeed;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * The Web Service for CAD-related API calls.
 */
public interface GeoNetCADService {
    /**
     * Retrieves information in CAP format for a single quake.
     *
     * @param ID a valid quake CAP ID from the Quake CAP Feed.
     * @return A {@link QuakeCAD} that contains information on the Quake.
     */
    @GET("cap/1.2/GPA1.0/quake/{ID}")
    Call<QuakeCAD> getQuakeCAD(@Path("ID") String ID);

    /**
     * Retrieves quake feed with CAP links for alerting.
     *
     * Feed of quakes in the last seven days of intensity moderate or higher in the New Zealand region and a suitable
     * quality for alerting. Links (type application/cap+xml) to individual quakes in the requested CAP version and
     * profile are included in the returned feed.
     *
     * @return A {@link QuakeCADFeed} that contains the feed data.
     */
    @GET("cap/1.2/GPA1.0/feed/atom1.0/quake")
    Call<QuakeCADFeed> getQuakeCADFeed();
}
