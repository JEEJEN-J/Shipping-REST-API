package com.charess.shippingrestapi.controller;

import com.charess.shippingrestapi.model.Consolidate;
import com.charess.shippingrestapi.model.Delivery;
import com.charess.shippingrestapi.service.DeliveryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/delivery")
public class DeliveryController {

    private DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @Operation(summary = "Créer un delivery, vous devez spécifier les propriétés ci-dessous dans la demande. Si vous n'êtes pas connecté pour effectuer cette action, un 401 Unauthorized état est renvoyé.")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody Delivery delivery) {
        HttpHeaders textPlainHeaders = new HttpHeaders();
        textPlainHeaders.setContentType(MediaType.TEXT_PLAIN);
        try {
            if (delivery == null) {
                return new ResponseEntity<>("Error delivery can't null : ", HttpStatus.BAD_REQUEST);
            }
            if (delivery.getId() != null) {
                return new ResponseEntity<>("Error delivery exist : " + HttpStatus.CONFLICT, textPlainHeaders, HttpStatus.CONFLICT);
            }
            System.out.println("Delivery : " + delivery);
            Object object = this.deliveryService.create(delivery);
            return ResponseEntity.ok(object);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }


    @Operation(summary = "")
    @RequestMapping(value = "/{ID}", method = RequestMethod.GET)
    public ResponseEntity<?> getDeliveryById(@PathVariable("ID") Integer id) {
        Object object = this.deliveryService.getById(id);
        return ResponseEntity.ok(object);
    }


    @Operation(summary = "")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllDeliveries() {
        List<?> objects = this.deliveryService.findAll();
        return ResponseEntity.ok(objects);
    }



}
