package com.charess.shippingrestapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "colis")
public class Colis extends Name {

    @OneToMany
    private List<Items> items;

    @Column(name = "estimateSendDate")
    private LocalDate estimateSendDate;

    @Column(name = "estimateReceivedDate")
    private LocalDate estimateReceivedDate;

    @Column(name = "status", length = 50)
    private String status = Status.COLIS_COMPLETED.toString();

    @OneToMany
    private List<Images> images;

    @Column(name = "quantity", length = 15)
    private Integer quantity = 0;

    public Colis() {
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
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


    public Integer getQuantity() {
        return this.quantity;
    }


    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
