package com.charess.shippingrestapi.repository;

import com.charess.shippingrestapi.model.Colis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColisRepository extends JpaRepository<Colis, Integer> {
}
