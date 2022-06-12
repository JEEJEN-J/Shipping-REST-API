package com.charess.shippingrestapi.service;

import com.charess.shippingrestapi.model.Consolidate;
import com.charess.shippingrestapi.model.Delivery;
import com.charess.shippingrestapi.model.User;

import java.time.LocalDate;
import java.util.List;

public interface DeliveryService {
    Delivery create(Delivery delivery);

    Delivery getById(Integer id);

    Delivery getByReceiver(User user);

    Delivery getByDeliveryMan(User user);

    Delivery getByConsolidate(Consolidate consolidate);

    List<Delivery> getByDeliveryDate(LocalDate localDate);
}
