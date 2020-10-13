package com.business.system.controller;

import com.business.system.entity.Industry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class industryController {

//    @RequestMapping("/industry_search")
//    public String industryPage(){
//        return "industry";
//    }

    @GetMapping("/industry_search")
    public String industryPage(Model model) {
        model.addAttribute("searchIndustry", new Industry());
        return "industry";
    }

    @PostMapping("/industry_dashboard")
    public String industrySubmit(@ModelAttribute Industry industryResult, Model model){
        model.addAttribute("industryResult", industryResult);
        return "industry_dashboard";
    }


}
