package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class QuakeInfoResponse {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("features")
    @Expose
    private List<Quake> quakes = null;

    public String getType() {
        return type;
    }

    public List<Quake> getQuakes() {
        return quakes;
    }

    @Override
    public String toString() {
        return "QuakeInfoResponse{" +
                "type='" + type + '\'' +
                ", quakes=" + Arrays.toString(quakes.toArray()) +
                '}';
    }
}
