package com.example.demo.Service;

import com.example.demo.Model.Customer;
import com.example.demo.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;
    public List<Customer> fetchAll(){
        return customerRepo.fetchAll();
    }

    public Customer addCustomer(Customer customer){
        return customerRepo.addCustomer(customer);
    }

    public Customer findCustomerById(int customer_id){
        return customerRepo.findCustomerById(customer_id);
    }

    public Boolean deleteCustomer(int customer_id){
        return customerRepo.deleteCustomer(customer_id);
    }

    public Customer updateCustomer(Customer customer){
        return customerRepo.updateCustomer(customer);
    }
}
