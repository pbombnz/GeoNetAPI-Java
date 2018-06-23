package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Quake {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("geometry")
    @Expose
    private Geometry geometry;
    @SerializedName("properties")
    @Expose
    private Quake_Properties properties;

    public String getType() {
        return type;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public Quake_Properties getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return "Quake{" +
                "type='" + type + '\'' +
                ", geometry=" + geometry +
                ", properties=" + properties +
                '}';
    }
}
