package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsFeed_Item {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("published")
    @Expose
    private String published;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("mlink")
    @Expose
    private String mlink;

    public String getTitle() {
        return title;
    }

    public String getPublished() {
        return published;
    }

    public String getLink() {
        return link;
    }

    public String getMlink() {
        return mlink;
    }

    @Override
    public String toString() {
        return "NewsFeed_Item{" +
                "title='" + title + '\'' +
                ", published='" + published + '\'' +
                ", link='" + link + '\'' +
                ", mlink='" + mlink + '\'' +
                '}';
    }
}
