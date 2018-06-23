package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class Volcano {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("features")
    @Expose
    private List<Volcano_Feature> features = null;

    public String getType() {
        return type;
    }

    public List<Volcano_Feature> getFeatures() {
        return features;
    }

    @Override
    public String toString() {
        return "Volcano{" +
                "type='" + type + '\'' +
                ", features=[" + Arrays.toString(features.toArray()) +
                "]}";
    }
}
