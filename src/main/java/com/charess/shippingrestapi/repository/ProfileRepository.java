package com.charess.shippingrestapi.repository;

import com.charess.shippingrestapi.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
}
