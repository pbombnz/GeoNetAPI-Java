package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class QuakeStatsCollection {
    @SerializedName("magnitudeCount")
    @Expose
    Map<String ,Map<String, Integer>> magnitudeCount;

    @SerializedName("rate")
    @Expose
    Map<String ,Map<String, Integer>> rate;

    public void setMagnitudeCount(Map<String, Map<String, Integer>> magnitudeCount) {
        this.magnitudeCount = magnitudeCount;
    }

    public void setRate(Map<String, Map<String, Integer>> rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "QuakeStatsCollection{" +
                "magnitudeCount=" + magnitudeCount +
                ", rate=" + rate +
                '}';
    }

    //private String mapToString(int)

}
