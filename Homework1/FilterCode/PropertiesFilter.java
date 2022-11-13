import org.json.simple.JSONObject;

public class PropertiesFilter implements Filter<JSONObject> {
    @Override
    public JSONObject execute(JSONObject input) {
        JSONObject properties= new JSONObject();
        JSONObject InputProps=(JSONObject) input.get("properties");
        properties.put("city",InputProps.get("addr:city"));
        properties.put("name",InputProps.get("name"));
        properties.put("street",InputProps.get("addr:street"));

        return properties;

    }
}
