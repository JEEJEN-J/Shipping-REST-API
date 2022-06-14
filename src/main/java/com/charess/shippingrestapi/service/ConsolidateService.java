package com.charess.shippingrestapi.service;

import com.charess.shippingrestapi.model.Consolidate;

import java.util.List;
import java.util.Optional;

public interface ConsolidateService {
    Consolidate create(Consolidate consolidate);
    Optional<Consolidate> getById(Integer id);
    List<Consolidate> findAll();
    Consolidate update(Consolidate consolidate);
}
