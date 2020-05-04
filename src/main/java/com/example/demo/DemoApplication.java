package com.example.demo;

import com.example.demo.Service.RentalContractService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main (String[] args)
    {
        SpringApplication.run(DemoApplication.class, args);
        //System.out.println((new RentalContractService()).availableCars("2020-06-01", "2021-01-01", ""));
    }

}
