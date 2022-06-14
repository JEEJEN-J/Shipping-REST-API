package com.charess.shippingrestapi.service;

import com.charess.shippingrestapi.model.Location;
import com.charess.shippingrestapi.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("locationService")
public class LocationServiceImpl implements LocationService {

    private LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> search(String criteria){
        return (criteria==null || criteria.trim().isEmpty())?new ArrayList<>():locationRepository.search(criteria);
    }

}
