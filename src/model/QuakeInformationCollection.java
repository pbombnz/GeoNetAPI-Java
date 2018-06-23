package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class QuakeInformationCollection {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("features")
    @Expose
    private List<QuakeInformation> quakeInformations = null;

    public String getType() {
        return type;
    }

    public List<QuakeInformation> getQuakeInformations() {
        return quakeInformations;
    }

    @Override
    public String toString() {
        return "QuakeInformationCollection{" +
                "type='" + type + '\'' +
                ", quakeInformations=" + Arrays.toString(quakeInformations.toArray()) +
                '}';
    }
}
