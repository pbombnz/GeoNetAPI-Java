package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class FeltReportCollection {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("features")
    @Expose
    private List<FeltReport> feltReports = null;

    public String getType() {
        return type;
    }

    public List<FeltReport> getFeltReports() {
        return feltReports;
    }

    @Override
    public String toString() {
        return "FeltReportCollection{" +
                "type='" + type + '\'' +
                ", feltReports=" + Arrays.toString(feltReports.toArray()) +
                '}';
    }
}
