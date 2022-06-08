package com.charess.shippingrestapi.repository;

import com.charess.shippingrestapi.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Items, Integer> {
}
