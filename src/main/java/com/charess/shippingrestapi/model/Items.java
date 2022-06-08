package com.charess.shippingrestapi.model;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Items extends Name {

    @ManyToOne
    @JoinTable(name = "colis_items", joinColumns = @JoinColumn(name = "items_id"), inverseJoinColumns = @JoinColumn(name = "colis_id"))
    private Colis colis;

    @Column(name = "description")
    private String description;

    @Column(name = "weight", length = 15)
    private double weight;

    @Column(name = "basePrice", length = 15)
    private double basePrice;

    @Column(name = "totalPrice", length = 15)
    private double totalPrice;

    @Column(name = "quantity", length = 10)
    private Integer quantity;

    public Items() {
    }

    public Colis getColis() {
        return colis;
    }

    public void setColis(Colis colis) {
        this.colis = colis;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
