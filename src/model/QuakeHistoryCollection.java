package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class QuakeHistoryCollection {
    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("features")
    @Expose
    private List<QuakeHistory> quakeHistoryAll = null;

    public String getType() {
        return type;
    }

    public List<QuakeHistory> getAllQuakeHistory() {
        return quakeHistoryAll;
    }

    @Override
    public String toString() {
        return "QuakeHistoryCollection{" +
                "type='" + type + '\'' +
                ", quakeHistoryAll=" + Arrays.toString(quakeHistoryAll.toArray()) +
                '}';
    }
}
