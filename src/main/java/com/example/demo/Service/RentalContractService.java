package com.example.demo.Service;

import com.example.demo.Model.Customer;
import com.example.demo.Model.RentalContract;
import com.example.demo.Repository.CustomerRepo;
import com.example.demo.Repository.RentalContractRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalContractService {
    @Autowired
    RentalContractRepo rentalContractRepo;
    public List<RentalContract> fetchAll(){
        return rentalContractRepo.fetchAll();
    }

    public RentalContract addRentalContract(RentalContract rentalContract){
        return rentalContractRepo.addRentalContract(rentalContract);
    }

    public RentalContract findRentalContractbyId(int rentalContract_id){
        return rentalContractRepo.findRentalContract(rentalContract_id);
    }

    public Boolean deleteRentalContract(int rentalContract_id){
        return rentalContractRepo.deleteRentalContract(rentalContract_id);
    }

    public RentalContract updateRentalContract(int rentalContract_id, RentalContract rentalContract){
        return rentalContractRepo.updateRentalContract(rentalContract_id, rentalContract);
    }
}
