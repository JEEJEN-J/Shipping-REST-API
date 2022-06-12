package com.charess.shippingrestapi.service;

import com.charess.shippingrestapi.model.Dispatch;
import com.charess.shippingrestapi.model.Location;

import java.util.List;

public interface DispatchService {
    Dispatch create(Dispatch dispatch);

    Dispatch getById(Integer id);

    List<Dispatch> findAll();

    Dispatch update(Dispatch dispatch);
}
