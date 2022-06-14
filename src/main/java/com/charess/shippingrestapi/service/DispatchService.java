package com.charess.shippingrestapi.service;

import com.charess.shippingrestapi.model.Dispatch;

import java.util.List;
import java.util.Optional;

public interface DispatchService {
    Dispatch create(Dispatch dispatch);

    Optional<Dispatch> getById(Integer id);

    List<Dispatch> findAll();

    Dispatch update(Dispatch dispatch);
}
