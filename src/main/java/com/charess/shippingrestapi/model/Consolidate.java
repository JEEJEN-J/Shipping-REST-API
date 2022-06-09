package com.charess.shippingrestapi.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "consolidate")
public class Consolidate extends Audit {

    @OneToMany
    private List<Dispatch> dispatches;

    @OneToOne
    private User receiver;

    @Column(name = "price")
    private double price;

    @Column(name = "weight", length = 15)
    private double weight;


    public Consolidate() {
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public List<Dispatch> getDispatches() {
        return dispatches;
    }

    public void setDispatches(List<Dispatch> dispatches) {
        this.dispatches = dispatches;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
