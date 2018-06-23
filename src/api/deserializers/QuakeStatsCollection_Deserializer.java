package api.deserializers;

import com.google.gson.*;
import model.QuakeStatsCollection;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class QuakeStatsCollection_Deserializer implements JsonDeserializer<QuakeStatsCollection> {
    @Override
    public QuakeStatsCollection deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        //Map.Entry<String, JsonElement> entry = json.getAsJsonObject().entrySet().iterator().next();
        //System.out.println(json);

        JsonObject jsonObject = json.getAsJsonObject();
        // magnitudeCount
        JsonObject magnitudeCount = jsonObject.getAsJsonObject("magnitudeCount");
        // rate
        JsonObject rate = jsonObject.getAsJsonObject("rate");

        Map<String, Map<String, Integer>> maps = new HashMap<>();

        for(Map.Entry<String, JsonElement> entry : magnitudeCount.entrySet()) {
            //System.out.println("entry.getKey():"+entry.getKey());
            //System.out.println("entry.getValue():"+ entry.getValue());

            Map<String, Integer> magCount = new HashMap<>();

            JsonObject magCountJSONObject = entry.getValue().getAsJsonObject();
            for(Map.Entry<String, JsonElement> entry2 : magCountJSONObject.entrySet()) {
                ///System.out.println("entry2.getKey():"+entry2.getKey());
                //System.out.println("entry2.getValue():"+ entry2.getValue());

                JsonElement je = entry2.getValue();
                magCount.put(entry2.getKey(), je.getAsInt());
            }
            maps.put(entry.getKey(), magCount);
        }

        //System.out.println("RATE DEM GEE");

        Map<String, Map<String, Integer>> maps2 = new HashMap<>();

        for(Map.Entry<String, JsonElement> entry : rate.entrySet()) {
            //System.out.println("entry.getKey():"+entry.getKey());
            //System.out.println("entry.getValue():"+ entry.getValue());

            Map<String, Integer> ratePerCount = new HashMap<>();

            JsonObject ratePerJSONObject = entry.getValue().getAsJsonObject();
            for(Map.Entry<String, JsonElement> entry2 : ratePerJSONObject.entrySet()) {
                //System.out.println("entry2.getKey():"+entry2.getKey());
                //System.out.println("entry2.getValue():"+ entry2.getValue());

                JsonElement je = entry2.getValue();
                ratePerCount.put(entry2.getKey(), je.getAsInt());
            }
            maps2.put(entry.getKey(), ratePerCount);
        }

        QuakeStatsCollection qsc = new QuakeStatsCollection();
        qsc.setMagnitudeCount(maps);
        qsc.setRate(maps2);

        //MapUtils.debugPrint(System.out, "magCount", maps);
        //MapUtils.debugPrint(System.out, "rate", maps2);
        return qsc;
    }
}
