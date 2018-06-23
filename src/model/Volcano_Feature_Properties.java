package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Volcano_Feature_Properties {
    @SerializedName("volcanoID")
    @Expose
    private String volcanoID;
    @SerializedName("volcanoTitle")
    @Expose
    private String volcanoTitle;
    @SerializedName("level")
    @Expose
    private Integer level;
    @SerializedName("activity")
    @Expose
    private String activity;
    @SerializedName("hazards")
    @Expose
    private String hazards;

    public String getVolcanoID() {
        return volcanoID;
    }

    public String getVolcanoTitle() {
        return volcanoTitle;
    }

    public Integer getLevel() {
        return level;
    }

    public String getActivity() {
        return activity;
    }

    public String getHazards() {
        return hazards;
    }

    @Override
    public String toString() {
        return "Volcano_Feature_Properties{" +
                "volcanoID='" + volcanoID + '\'' +
                ", volcanoTitle='" + volcanoTitle + '\'' +
                ", level=" + level +
                ", activity='" + activity + '\'' +
                ", hazards='" + hazards + '\'' +
                '}';
    }
}
