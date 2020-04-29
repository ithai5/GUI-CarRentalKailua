package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RentalContract {
    @Id
    private int rentalContract_id;
    private String startDate;
    private String endDate;
    private int maxKm;
    private int startKm;
    private int totalPrice;
    private String licencePlate;

    //Foreign key
    private int customer_id;

    public RentalContract() {
    }

    public RentalContract(int rentalContract_id, String startDate, String endDate, int maxKm, int startKm, int totalPrice, String licencePlate, int customer_id) {
        this.rentalContract_id = rentalContract_id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.maxKm = maxKm;
        this.startKm = startKm;
        this.totalPrice = totalPrice;
        this.licencePlate = licencePlate;
        this.customer_id = customer_id;
    }

    public int getRentalContract_id() {
        return rentalContract_id;
    }

    public void setRentalContract_id(int rentalContract_id) {
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

    public int getMaxKm() {
        return maxKm;
    }

    public void setMaxKm(int maxKm) {
        this.maxKm = maxKm;
    }

    public int getStartKm() {
        return startKm;
    }

    public void setStartKm(int startKm) {
        this.startKm = startKm;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
}
