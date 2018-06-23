package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class NewsFeedCollection {
    @SerializedName("feed")
    @Expose
    private List<NewsFeed> feed = null;

    public List<NewsFeed> getFeed() {
        return feed;
    }

    @Override
    public String toString() {
        return "NewsFeedCollection{" +
                "feed=" + Arrays.toString(feed.toArray()) +
                '}';
    }
}
