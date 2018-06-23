package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuakeHistory {
    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("geometry")
    @Expose
    private Geometry geometry;

    @SerializedName("properties")
    private QuakeHistory_Properties properties;

    @Override
    public String toString() {
        return "QuakeHistory{" +
                "type='" + type + '\'' +
                ", geometry=" + geometry +
                ", properties=" + properties +
                '}';
    }
}
