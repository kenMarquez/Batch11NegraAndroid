
package ken.mx.spotifyplayer.models.spotify;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class TracksResponse {

    @SerializedName("tracks")
    @Expose
    private Tracks tracks;

    /**
     * @return The tracks
     */
    public Tracks getTracks() {
        return tracks;
    }

    /**
     * @param tracks The tracks
     */
    public void setTracks(Tracks tracks) {
        this.tracks = tracks;
    }

}
