package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuakeHistory_Properties {
    @SerializedName("publicID")
    @Expose
    private String publicID;

    @SerializedName("time")
    @Expose
    private String time;

    @SerializedName("modificationTime")
    @Expose
    private String modificationTime;

    @SerializedName("depth")
    @Expose
    private Double depth;

    @SerializedName("magnitude")
    @Expose
    private Double magnitude;

    @SerializedName("locality")
    @Expose
    private String locality;

    @SerializedName("mmi")
    @Expose
    private Integer mmi;

    @SerializedName("quality")
    @Expose
    private String quality;

    public String getPublicID() {
        return publicID;
    }


    public String getTime() {
        return time;
    }

    public String getModificationTime() { return modificationTime; }

    public Double getDepth() {
        return depth;
    }

    public Double getMagnitude() {
        return magnitude;
    }

    public String getLocality() {
        return locality;
    }

    public Integer getMMI() { return mmi; }

    public String getQuality() {
        return quality;
    }
}
