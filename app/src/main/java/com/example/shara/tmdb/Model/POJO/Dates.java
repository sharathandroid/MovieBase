package com.example.shara.tmdb.Model.POJO;

/**
 * Created by shara on 3/16/2017.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dates {

    @SerializedName("maximum")
    @Expose
    private String maximum;
    @SerializedName("minimum")
    @Expose
    private String minimum;

    public String getMaximum() {
        return maximum;
    }

    public void setMaximum(String maximum) {
        this.maximum = maximum;
    }

    public String getMinimum() {
        return minimum;
    }

    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }

}