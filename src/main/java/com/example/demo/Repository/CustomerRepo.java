package com.example.demo.Repository;

import com.example.demo.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepo {
    @Autowired
    JdbcTemplate template;
    public List<Customer> fetchAll(){
        String sql = "SELECT * " +
                "FROM KeaProject.Customer";
        RowMapper <Customer> rowMapper= new BeanPropertyRowMapper<>(Customer.class);
        return template.query(sql,rowMapper);
    }

    public Customer addCustomer(Customer customer){
        String sql = "INSERT INTO KeaProject.Customer (firstName, lastName, email) " +
                "VALUES (?,?,?)";
        template.update(sql,customer.getFirstName(),customer.getLastName(),customer.getEmail());
        return null;
    }

    public Customer findCustomerById(int customer_id){
        String sql = "SELECT * " +
                "FROM KeaProject.Customer " +
                "WHERE customer_id = ?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        Customer customer = template.queryForObject(sql, rowMapper, customer_id);
        return customer;
    }

    public Boolean deleteCustomer(int customerId){
        String sql = "DELETE FROM KeaProject.Customer " +
                "WHERE customer_id = ?";
        return template.update(sql,customerId)<0;
    }

    public Customer updateCustomer(int customerId, Customer customer){
        String sql = "UPDATE KeaProject.Customer " +
                "SET fistName = ? , lastName = ? , email = ? " +
                "WHERE customer_id = ? ";
        template.update(sql, customer.getFirstName(),customer.getLastName(),customer.getEmail(), customer.getCustomer_id());
        return null;
    }
}
