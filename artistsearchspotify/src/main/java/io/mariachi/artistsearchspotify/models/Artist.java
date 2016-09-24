package io.mariachi.artistsearchspotify.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ken on 23/09/16.
 */

public class Artist {

    @SerializedName("limit")
    private int limit;

    @SerializedName("href")
    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }



}
