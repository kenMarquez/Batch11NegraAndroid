package io.mariachi.artistsearchspotify.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ken on 23/09/16.
 */

public class Image {

    @SerializedName("url")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
