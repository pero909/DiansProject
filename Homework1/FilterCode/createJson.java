
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonToCvs {




    public static void main(String[] args) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader fileReader = new FileReader("src/hotelsExport.json");

       Object obj= parser.parse(fileReader);

       Pipe<JSONObject> propertiesPipe= new Pipe<>();
       PropertiesFilter propertiesFilter = new PropertiesFilter();
       propertiesPipe.addFilter(propertiesFilter);

       JSONObject JsonGyms=(JSONObject) obj;
       JSONArray array=(JSONArray) JsonGyms.get("features");
       JSONArray filteredJsons= new JSONArray();

       for(int i=0;i<array.size();i++){
          JSONObject feature= (JSONObject) array.get(i);
          JSONObject Gym=propertiesPipe.runFilters(feature);
          filteredJsons.add(Gym);

       }
        FileWriter file= new FileWriter("D:\\DIANS\\jsonToDatabase\\filterToDatabase\\src\\Hotelsfiltered.json"); // create seperate json files for hotel,restaurants
       file.write(filteredJsons.toJSONString());                                                                 //and fitness centers
       file.close();

    }
}
