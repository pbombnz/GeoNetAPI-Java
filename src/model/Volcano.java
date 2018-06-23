package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Volcano {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("geometry")
    @Expose
    private Geometry geometry;
    @SerializedName("properties")
    @Expose
    private Volcano_Properties properties;

    public String getType() {
        return type;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public Volcano_Properties getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return "Volcano{" +
                "type='" + type + '\'' +
                ", geometry=" + geometry +
                ", properties=" + properties +
                '}';
    }
}
