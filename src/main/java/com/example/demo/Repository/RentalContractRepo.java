package com.example.demo.Repository;

import com.example.demo.Model.CarDisplay;
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

    public List<CarDisplay> availableCars(String startDate, String endDate, String className) {
        String sql = "SELECT licencePlate, brand, model, className, pricePerDay, odometer, registration " +
                "FROM Specs AS b " +
                "JOIN " +
                "(SELECT CarInfo.licencePlate, startDate, endDate, rentalContract_id, CarInfo.specs_id, CarInfo.odometer, CarInfo.registration " +
                "FROM KeaProject.CarInfo AS a " + "JOIN KeaProject.RentalContract ON a.licencePlate= RentalContract.licencePlate " +
                "AND ((startDate >= '" + startDate + "' AND startDate <= '" + endDate + "') " + "OR(endDate >= '" + startDate + "' AND endDate <= '" + endDate + "') " +
                "OR (startDate >= '" + startDate + "' AND endDate <= '" + endDate + "')) " +
                "RIGHT JOIN CarInfo ON a.licencePlate = CarInfo.licencePlate " +
                "WHERE rentalContract_id IS NULL) AS c " + "ON b.specs_id = c.specs_id  " +
                "JOIN KeaProject.ClassType AS d " + "ON b.className_id = d.className_id AND className LIKE '%" + className + "'";

        return template.query(sql,new BeanPropertyRowMapper<>(CarDisplay.class));
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
