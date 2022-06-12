package com.charess.shippingrestapi.service;

import com.charess.shippingrestapi.model.Consolidate;

import java.util.List;

public interface ConsolidateService {
    Consolidate create(Consolidate consolidate);
    Consolidate getById(Integer id);
    List<Consolidate> findAll();
    Consolidate update(Consolidate consolidate);
}
