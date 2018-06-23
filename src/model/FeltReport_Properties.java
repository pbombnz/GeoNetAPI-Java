package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeltReport_Properties {
    @SerializedName("mmi")
    @Expose
    private Integer mmi;

    public Integer getMmi() {
        return mmi;
    }

    @Override
    public String toString() {
        return "FeltReport_Properties{" +
                "mmi=" + mmi +
                '}';
    }
}
