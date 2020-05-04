package com.example.demo.Controller;

import com.example.demo.Model.CarDisplay;
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
    @Autowired
    CustomerService temp;

    @GetMapping("/rentalContract/rentalContractMenu")
    public String rentalContractMenu(Model model) {
        List<RentalContract> rcList = rentalContractService.fetchAll();
        model.addAttribute("rentalContracts", rcList);
        return "home/rentalContract/rentalContractMenu";
    }

    @GetMapping("/rentalContract/createRentalContract1")
    public String createRentalDates() {
        return "home/rentalContract/createRentalContract1";
    }

    @GetMapping("/rentalContract/createRentalContract2/{startDate}-{endDate}-{carType}")
    public String createRentalContract(@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate, @PathVariable("carType") String carType) {
        System.out.println(startDate + " " + endDate + " " + carType);
        System.out.println("Yeet");
        return "redirect:/rentalContract/createRentalContract2";
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

    @GetMapping("/rentalContract/viewRentalContract/{rentalContract_id}")
    public String viewRentalContract(@PathVariable("rentalContract_id") int rentalContract_id, Model model){
        RentalContract toView = rentalContractService.findRentalContractbyId(rentalContract_id);
        System.out.println(toView);
        model.addAttribute("rentalContract",toView);
        model.addAttribute("customer", temp.findCustomerById(toView.getCustomer_id()));
        return "home/rentalContract/viewRentalContract";
    }

    @GetMapping("/rentalContract/testCar")
    public String testCar(Model model) {
        List<CarDisplay> rcList = rentalContractService.availableCars("2020-06-01", "2021-01-01", "");
        model.addAttribute("carDisplays", rcList);
        return "home/rentalContract/testCar";
    }
    //@GetMapping("/rentalContract/updateRentalContract/{rentalContract_id}")

}
