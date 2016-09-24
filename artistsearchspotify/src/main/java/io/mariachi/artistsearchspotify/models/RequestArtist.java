package io.mariachi.artistsearchspotify.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ken on 23/09/16.
 */

public class RequestArtist {

    @SerializedName("artists")
    private Artist artists;

    /**
     * @return The artists
     */
    public Artist getArtists() {
        return artists;
    }

    /**
     * @param artists The artists
     */
    public void setArtists(Artist artists) {
        this.artists = artists;
    }
}
