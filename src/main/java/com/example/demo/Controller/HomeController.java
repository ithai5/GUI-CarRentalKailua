package com.example.demo.Controller;

import com.example.demo.Model.Customer;
import com.example.demo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public String index(Model model){
        List<Customer> customerList = customerService.fetchAll();
        model.addAttribute("customers", customerList);
        for(int i = 0; i< customerList.size(); i++){
            System.out.println(customerList.get(i));
        }
        return "home/index";
    }

    @GetMapping("/customer/customerMenu")
    public String customerMenu(Model model){
        List<Customer> customerList = customerService.fetchAll();
        model.addAttribute("customers", customerList);
        for(int i = 0; i< customerList.size(); i++){
            System.out.println(customerList.get(i));
        }
        return "home/customer/customerMenu";
    }

    @GetMapping("/customer/createCustomer")
    public String createCustomer(){
        return "home/customer/createCustomer";
    }

    @PostMapping("/customer/createCustomer")
    public String createCustomer(@ModelAttribute Customer customer){
        customerService.addCustomer(customer);
        System.out.println(customer);
        return "redirect:/";
    }

    @GetMapping("/customer/viewCustomer/{customer_id}")
    public String viewCustomer(@PathVariable("customer_id") int customer_id, Model model){
        model.addAttribute("customer",customerService.findCustomerById(customer_id));
        return "home/viewCustomer";
    }

    @GetMapping("/customer/deleteCustomer/{customer_id}")
    public String deleteCustomer(@PathVariable("customer_id") int customer_id){
        Boolean delete = customerService.deleteCustomer(customer_id);
        return "redirect:/";
    }

    @GetMapping("/customer/updateCustomer/{customer_id}")
    public String updateCustomer(@PathVariable("customer_id") int customer_id, Model model){
        model.addAttribute("customer",customerService.findCustomerById(customer_id));
        return "home/customer/updateCustomer";
    }

    @PostMapping("/customer/updateCustomer")
    public String updateCustomer(@ModelAttribute Customer customer){
        customerService.updateCustomer(customer.getCustomer_id(),customer);
        System.out.println(customer);
        return "redirect:/";
    }



}
