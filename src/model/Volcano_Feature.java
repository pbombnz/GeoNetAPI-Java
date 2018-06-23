package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Volcano_Feature {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("geometry")
    @Expose
    private Geometry geometry;
    @SerializedName("properties")
    @Expose
    private Volcano_Feature_Properties properties;

    public String getType() {
        return type;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public Volcano_Feature_Properties getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return "Volcano_Feature{" +
                "type='" + type + '\'' +
                ", geometry=" + geometry +
                ", properties=" + properties +
                '}';
    }
}
