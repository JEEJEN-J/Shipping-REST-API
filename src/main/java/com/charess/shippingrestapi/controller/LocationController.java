package com.charess.shippingrestapi.controller;


import com.charess.shippingrestapi.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/location")
public class LocationController {

    private LocationService locationService;


    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @RequestMapping(value = "/search/{criteria}", method= RequestMethod.GET)
    public List<Location> search(@PathVariable(value = "criteria") String criteria) {
        return locationService.search(criteria);
    }

}
