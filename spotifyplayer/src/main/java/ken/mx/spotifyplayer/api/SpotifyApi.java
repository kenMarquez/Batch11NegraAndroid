package ken.mx.spotifyplayer.api;

import ken.mx.spotifyplayer.models.spotify.TracksResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Ken on 06/10/16.
 */

public interface SpotifyApi {

    @GET("/v1/search?type=track")
    Call<TracksResponse> getTracks(@Query("q") String trackName);

}
