package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class VolcanoCollection {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("features")
    @Expose
    private List<Volcano> features = null;

    public String getType() {
        return type;
    }

    public List<Volcano> getFeatures() {
        return features;
    }

    @Override
    public String toString() {
        return "VolcanoCollection{" +
                "type='" + type + '\'' +
                ", features=[" + Arrays.toString(features.toArray()) +
                "]}";
    }
}
