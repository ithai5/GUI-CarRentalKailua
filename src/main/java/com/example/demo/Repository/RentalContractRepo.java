package com.example.demo.Repository;

import com.example.demo.Model.Customer;
import com.example.demo.Model.RentalContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RentalContractRepo {
    @Autowired
    JdbcTemplate template;

    public List<RentalContract> fetchAll(){
        String sql = "SELECT * " +
                "FROM KeaProject.RentalContract ";
        RowMapper<RentalContract> rowMapper= new BeanPropertyRowMapper<>(RentalContract.class);
        return template.query(sql,rowMapper);
    }

    public RentalContract addRentalContract(RentalContract contract){
        String sql = "INSERT INTO KeaProject.RentalContract (startDate, endDate, maxKm, startKm, licencePlate, customer_id, totalPrice ) " +
                "VALUES (?,?,?,?,?,?,?)";
        template.update(sql, contract.getStartDate(), contract.getEndDate(), contract.getMaxKm(), contract.getStartKm(), contract.getLicencePlate(), contract.getCustomer_id(), contract.getTotalPrice());
        return null;
    }

    public RentalContract findRentalContract(int rentalContract_id){
        String sql = "SELECT * " +
                "FROM KeaProject.RentalContract " +
                "WHERE rentalContract_id = ?";
        RowMapper<RentalContract> rowMapper = new BeanPropertyRowMapper<>(RentalContract.class);
        RentalContract contract = template.queryForObject(sql, rowMapper, rentalContract_id);
        return contract;
    }

    public Boolean deleteRentalContract(int rentalContract_id){
        String sql = "DELETE FROM KeaProject.RentalContract " +
                "WHERE rentalContract_id = ?";
        return template.update(sql, rentalContract_id)<0;
    }

    public RentalContract updateRentalContract(int rentalContract_id, RentalContract contract){
        String sql = "UPDATE KeaProject.RentalContract " +
                "SET startDate = ? , endDate = ? , maxKm = ? , startKm = ?, totalPrice = ?, licencePlate = ?, customer_id = ?" +
                "WHERE rentalContract_id = ? ";
        template.update(sql, contract.getStartDate(), contract.getEndDate(), contract.getMaxKm(), contract.getStartKm(), contract.getLicencePlate(), contract.getCustomer_id(), contract.getTotalPrice());
        return null;
    }

}
