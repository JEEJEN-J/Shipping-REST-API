package com.charess.shippingrestapi.service;

import com.charess.shippingrestapi.model.Consolidate;
import com.charess.shippingrestapi.model.Delivery;
import com.charess.shippingrestapi.model.User;
import com.charess.shippingrestapi.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Transactional
@Service("deliveryService")
public class DeliveryServiceImpl implements DeliveryService {

    private DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public Delivery create(Delivery delivery) {
        if (delivery.getConsolidate() != null) {
            if (delivery.getDeliveryMan() != null) {
                delivery.setReceiver(delivery.getConsolidate().getReceiver());
                return this.deliveryRepository.save(delivery);
            }
        }
        return null;
    }

    @Override
    public Optional<Delivery> getById(Integer id) {
        return this.deliveryRepository.findById(id);
    }

    @Override
    public Delivery getByReceiver(User user) {
        return this.deliveryRepository.findDeliveryByReceiver(user);
    }

    @Override
    public Delivery getByDeliveryMan(User user) {
        return this.deliveryRepository.findByDeliveryMan(user);
    }

    @Override
    public Delivery getByConsolidate(Consolidate consolidate) {
        return this.deliveryRepository.findDeliveryByConsolidate(consolidate);
    }

    @Override
    public List<Delivery> getByDeliveryDate(LocalDate localDate) {
        return this.deliveryRepository.findAllByDeliveryDate(localDate);
    }

    @Override
    public List<Delivery> findAll() {
        return this.deliveryRepository.findAll();
    }

}
