package io.mariachi.artistsearchspotify.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ken on 23/09/16.
 */

public class Item {

    @SerializedName("name")
    private String name;

    @SerializedName("images")
    List<Image> images;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
