package com.example.dians_demo.Controllers;

import com.example.dians_demo.model.Location;
import com.example.dians_demo.service.LocationService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/populate")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public String getHomePage(Model model) throws IOException, ParseException {
        List<Location> locations= this.locationService.findAll();
        model.addAttribute("hotelList",locations);

        return "proba";
    }
    @PostMapping
    public String getHotel(@RequestParam(name = "hotel",required = false) Long id, Model model){

        List<Location> locations= this.locationService.findAll();
        model.addAttribute("hotelList",locations);
        Location location=this.locationService.findById(id).orElse(null);
        assert location != null;
        model.addAttribute("latitude",location.getLatitude());
        model.addAttribute("longitude",location.getLongitude());

        return "proba";
    }
}
