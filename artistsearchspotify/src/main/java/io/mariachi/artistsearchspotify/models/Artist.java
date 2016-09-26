package io.mariachi.artistsearchspotify.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ken on 23/09/16.
 */

public class Artist {

    @SerializedName("limit")
    private int limit;

    @SerializedName("href")
    private String href;

    @SerializedName("items")
    private List<Item> items;

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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
