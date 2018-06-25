package api.deserializers;

import com.google.gson.*;
import model.QuakeStatsCollection;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class QuakeStatsCollection_Deserializer implements JsonDeserializer<QuakeStatsCollection> {
    @Override
    public QuakeStatsCollection deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        // Convert json to JsonObject and start breaking it down into the two categories
        JsonObject jsonObject = json.getAsJsonObject();
        // Retrieve nested magnitudeCount JsonObject
        JsonObject magnitudeCount = jsonObject.getAsJsonObject("magnitudeCount");
        // Retrieve nested  rate JsonObject
        JsonObject rate = jsonObject.getAsJsonObject("rate");

        QuakeStatsCollection qsc = new QuakeStatsCollection();
        qsc.setMagnitudeCount(jsonObjectToMap(magnitudeCount));
        qsc.setRate(jsonObjectToMap(rate));

        return qsc;
    }

    private Map<String, Map<String, Integer>> jsonObjectToMap(JsonObject jsonObject) {
        Map<String, Map<String, Integer>> map = new HashMap<>();

        for(Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            Map<String, Integer> innerMap = new HashMap<>();

            JsonObject nestedJsonObject = entry.getValue().getAsJsonObject();
            for(Map.Entry<String, JsonElement> nestedEntry : nestedJsonObject.entrySet()) {
                JsonElement jsonElement = nestedEntry.getValue();
                innerMap.put(nestedEntry.getKey(), jsonElement.getAsInt());
            }
            map.put(entry.getKey(), innerMap);
        }

        return map;
    }
}
