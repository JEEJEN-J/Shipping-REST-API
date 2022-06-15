package com.charess.shippingrestapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "delivery")
public class Delivery extends ID {

    @OneToOne
    private Consolidate consolidate;

    @OneToOne
    private User deliveryMan;

    @OneToOne
    private User receiver;

    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;

    public Delivery() {
    }

    public Consolidate getConsolidate() {
        return consolidate;
    }

    public void setConsolidate(Consolidate consolidate) {
        this.consolidate = consolidate;
    }

    public User getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(User deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

}
