package com.charess.shippingrestapi.service;

import com.charess.shippingrestapi.model.Colis;

import java.util.List;

public interface ColisService {

    Colis create(Colis colis);

    Colis getById(Integer id);

    List<Colis> findAll();

    Colis update(Colis colis);

    boolean delete(Integer id);
}
