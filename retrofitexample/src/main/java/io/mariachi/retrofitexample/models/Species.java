package io.mariachi.retrofitexample.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ken on 22/09/16.
 */

public class Species {

    @SerializedName("name")
    private String name;

    @SerializedName("url")
    private String url;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
