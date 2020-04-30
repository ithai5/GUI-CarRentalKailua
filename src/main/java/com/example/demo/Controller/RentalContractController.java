package com.example.demo.Controller;

import com.example.demo.Model.Customer;
import com.example.demo.Model.RentalContract;
import com.example.demo.Repository.RentalContractRepo;
import com.example.demo.Service.CustomerService;
import com.example.demo.Service.RentalContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RentalContractController {
    @Autowired
    RentalContractService rentalContractService;

    @GetMapping("/rentalContract/rentalContractMenu")
    public String rentalContractMenu(Model model) {
        List<RentalContract> rcList = rentalContractService.fetchAll();

        model.addAttribute("rentalContracts", rcList);
        return "home/rentalContract/rentalContractMenu";
    }

    @GetMapping("/rentalContract/createRentalContract")
    public String createRentalContract() {
        return "home/rentalContract/createRentalContract";
    }

    @PostMapping("/rentalContract/createRentalContract")
    public String createRentalContract(@ModelAttribute RentalContract rentalContract) {
        rentalContractService.addRentalContract(rentalContract);
        return "redirect:/rentalContract/rentalContractMenu";
    }

    @GetMapping("/rentalContract/deleteRentalContract/{rentalContract_id}")
    public String deleteRentalContract(@PathVariable("rentalContract_id") int rentalContract_id) {
        Boolean delete = rentalContractService.deleteRentalContract(rentalContract_id);
        return "redirect:/rentalContract/rentalContractMenu";
    }

}
