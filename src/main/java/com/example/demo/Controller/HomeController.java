package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "home/index";
    }

}
