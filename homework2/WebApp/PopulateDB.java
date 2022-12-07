package com.example.dians_demo;

import com.example.dians_demo.model.Location;
import com.example.dians_demo.repository.jpa.LocationRepository;
import com.example.dians_demo.service.LocationService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class PopulateDB {
    private final LocationService locationService;
    public PopulateDB( LocationService locationService){
        this.locationService = locationService;


    }
    public static void main(String[] args) throws IOException, ParseException {


    }
    void saveToDb() throws IOException, ParseException {
        JSONParser parser= new JSONParser();
        FileReader json_file = new FileReader("D:\\DIANS\\Dians_demo\\src\\main\\resources\\templates\\filtered\\hotels.json");
        Object hotels_obj=parser.parse(json_file);
        JSONObject hotel_JSON=(JSONObject) hotels_obj;
        JSONArray hotel_Array = (JSONArray) hotel_JSON.get("hotels");

        for(int i=0;i<hotel_Array.size();i++){
            JSONObject hotel= (JSONObject) hotel_Array.get(i);
            String name=hotel.get("name").toString();
            String city="";
            if(hotel.get("city")!=null) {
                city = hotel.get("city").toString();
            }
            Double lat= (Double)hotel.get("lat");
            Double Longitutde=(Double)hotel.get("long");
            Location location=new Location(lat,Longitutde,name,city);
            this.locationService.save(location);
            System.out.println(name);
        }
    }
}
