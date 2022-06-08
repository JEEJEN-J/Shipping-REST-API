package com.charess.shippingrestapi.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "colis")
public class Colis extends Name {

    @OneToMany
    @JoinColumn(name = "items_id")
    private List<Items> items;

    @Column(name = "basePrice", length = 15)
    private double basePrice;

    @Column(name = "totalPrice", length = 15)
    private double totalPrice;

    @Column(name = "weight", length = 15)
    private double weight;

    @Column(name = "estimateSendDate")
    private LocalDate estimateSendDate;

    @Column(name = "estimateReceivedDate")
    private LocalDate estimateReceivedDate;

    @Column(name = "status", length = 50)
    private String status = Status.COLIS_COMPLETED.toString();

    @Transient
    private Integer quantity;

    public Colis() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getEstimateSendDate() {
        return estimateSendDate;
    }

    public void setEstimateSendDate(LocalDate estimateSendDate) {
        this.estimateSendDate = estimateSendDate;
    }

    public LocalDate getEstimateReceivedDate() {
        return estimateReceivedDate;
    }

    public void setEstimateReceivedDate(LocalDate estimateReceivedDate) {
        this.estimateReceivedDate = estimateReceivedDate;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Integer getQuantity() {
        this.items.forEach((item) -> {
            this.quantity += item.getQuantity();
        });
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
