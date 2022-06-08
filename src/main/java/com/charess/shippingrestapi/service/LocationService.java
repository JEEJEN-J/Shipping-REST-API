package com.charess.shippingrestapi.service;


import com.charess.shippingrestapi.model.Location;

import java.util.List;

public interface LocationService {

    List<Location> search(String criteria);

}
