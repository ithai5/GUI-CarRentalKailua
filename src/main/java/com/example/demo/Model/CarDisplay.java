package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CarDisplay {
    @Id
    private String licencePlate;
    private String brand;
    private String model;
    private String className;
    private int pricePerDay;
    private int odometer;
    private String registration;
    private String startDate;
    private String endDate;

    public CarDisplay (String licencePlate, String brand, String model, String className, int pricePerDay, int odometer, String registration)
    {
        this.licencePlate = licencePlate;
        this.brand = brand;
        this.model = model;
        this.className = className;
        this.pricePerDay = pricePerDay;
        this.odometer = odometer;
        this.registration = registration;
    }

    public CarDisplay ()
    {
    }

    public String getLicencePlate ()
    {
        return licencePlate;
    }

    public void setLicencePlate (String licencePlate)
    {
        this.licencePlate = licencePlate;
    }

    public String getBrand ()
    {
        return brand;
    }

    public void setBrand (String brand)
    {
        this.brand = brand;
    }

    public String getModel ()
    {
        return model;
    }

    public void setModel (String model)
    {
        this.model = model;
    }

    public String getClassName ()
    {
        return className;
    }

    public void setClassName (String className)
    {
        this.className = className;
    }

    public int getPricePerDay ()
    {
        return pricePerDay;
    }

    public void setPricePerDay (int pricePerDay)
    {
        this.pricePerDay = pricePerDay;
    }

    public int getOdometer ()
    {
        return odometer;
    }

    public void setOdometer (int odometer)
    {
        this.odometer = odometer;
    }

    public String getRegistration ()
    {
        return registration;
    }

    public void setRegistration (String registration)
    {
        this.registration = registration;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = formatTime(startDate);
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = formatTime(endDate);
    }
    String formatTime(String time) {
        time = time.replace('T', ' ');
        System.out.println(time);
        return time;
    }
    @Override
    public String toString() {
        return "CarDisplay{" +
                "licencePlate='" + licencePlate + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", className='" + className + '\'' +
                ", pricePerDay=" + pricePerDay +
                ", odometer=" + odometer +
                ", registration='" + registration + '\'' +
                '}';
    }
}
