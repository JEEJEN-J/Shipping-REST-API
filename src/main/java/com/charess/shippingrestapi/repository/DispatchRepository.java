package com.charess.shippingrestapi.repository;

import com.charess.shippingrestapi.model.Dispatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispatchRepository extends JpaRepository<Dispatch, Integer> {
}
