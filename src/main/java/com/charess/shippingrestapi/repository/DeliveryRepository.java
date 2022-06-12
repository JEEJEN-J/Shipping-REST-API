package com.charess.shippingrestapi.repository;

import com.charess.shippingrestapi.model.Consolidate;
import com.charess.shippingrestapi.model.Delivery;
import com.charess.shippingrestapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {
    Delivery findDeliveryByReceiver(User user);
    Delivery findByDeliveryMan(User user);
    List<Delivery> findAllByDeliveryManAndReceiver(User deliveryMAn, User receiver);
    List<Delivery> findAllByDeliveryDate(LocalDate localDate);
    Delivery findDeliveryByConsolidate(Consolidate consolidate);
}
