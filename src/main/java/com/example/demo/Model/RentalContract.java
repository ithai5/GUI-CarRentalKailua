package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RentalContract {
    @Id
    private Integer rentalContract_id;
    private String startDate;
    private String endDate;
    private Integer maxKm;
    private Integer startKm;
    private Integer totalPrice;
    private String licencePlate;

    //Foreign key
    private Integer customer_id;

    public RentalContract() {
    }

    public RentalContract(Integer rentalContract_id, String startDate, String endDate, Integer maxKm, Integer startKm, Integer totalPrice, String licencePlate, Integer customer_id) {
        this.rentalContract_id = rentalContract_id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.maxKm = maxKm;
        this.startKm = startKm;
        this.totalPrice = totalPrice;
        this.licencePlate = licencePlate;
        this.customer_id = customer_id;
    }

    public Integer getRentalContract_id() {
        return rentalContract_id;
    }

    public void setRentalContract_id(Integer rentalContract_id) {
        this.rentalContract_id = rentalContract_id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getMaxKm() {
        return maxKm;
    }

    public void setMaxKm(Integer maxKm) {
        this.maxKm = maxKm;
    }

    public Integer getStartKm() {
        return startKm;
    }

    public void setStartKm(Integer startKm) {
        this.startKm = startKm;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }
}
