package com.charess.shippingrestapi.repository;

import com.charess.shippingrestapi.model.Colis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ColisRepository extends JpaRepository<Colis, Integer> {
    @Query("select c from Colis c")
    List<Colis> find();
}
