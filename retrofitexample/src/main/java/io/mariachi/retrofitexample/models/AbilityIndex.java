package io.mariachi.retrofitexample.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ken on 22/09/16.
 */

public class AbilityIndex {

    @SerializedName("is_hidden")
    private boolean isHidden;

    @SerializedName("slot")
    private int slot;


    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }
}
