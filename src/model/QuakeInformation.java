package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuakeInformation {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("geometry")
    @Expose
    private Geometry geometry;
    @SerializedName("properties")
    @Expose
    private QuakeInformation_Properties properties;

    public String getType() {
        return type;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public QuakeInformation_Properties getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return "QuakeInformation{" +
                "type='" + type + '\'' +
                ", geometry=" + geometry +
                ", properties=" + properties +
                '}';
    }
}
