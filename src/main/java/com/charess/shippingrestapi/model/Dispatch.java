package com.charess.shippingrestapi.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "dispatch")
public class Dispatch extends Audit {

    @OneToOne
    @JoinColumn(name = "colis_id")
    private Colis colis;

    @OneToOne
    @JoinColumn(name = "receiver_id")
    private Person receiver;

    @OneToOne
    @JoinColumn(name = "sender_id")
    private Person sender;

    @Column(name = "status", length = 50)
    private String status = Status.COLIS_COMPLETED.toString();

    @Column(name = "estimateSendDate")
    private LocalDate estimateSendDate;

    @Column(name = "estimateReceivedDate")
    private LocalDate estimateReceivedDate;

    @Column(name = "startDate")
    private LocalDateTime startDate;

    @Column(name = "endDate")
    private LocalDateTime endDate;

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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Person getSender() {
        return sender;
    }

    public void setSender(Person sender) {
        this.sender = sender;
    }

    public Person getReceiver() {
        return receiver;
    }

    public void setReceiver(Person receiver) {
        this.receiver = receiver;
    }

    public Colis getColis() {
        return colis;
    }

    public void setColis(Colis colis) {
        this.colis = colis;
    }


}
