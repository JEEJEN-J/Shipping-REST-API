package com.charess.shippingrestapi.repository;

import com.charess.shippingrestapi.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {
}
