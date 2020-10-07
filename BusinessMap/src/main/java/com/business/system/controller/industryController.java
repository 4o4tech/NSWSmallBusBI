package com.business.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class industryController {

    @RequestMapping("/industry_search")
    public String industryPage(){
        return "industry";
    }

//    @GetMapping("/greeting")
//    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }

    @GetMapping("/industry_dashboard")
    public String industryDashBoardPage(@RequestParam(name = "industry", required=false, defaultValue="Restaurant") String industry, Model model){
        model.addAttribute("industry", industry);
        return "industry_dashboard";
    }


}
