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

    @PostMapping("/industry_search")
    public String industrySubmit(@ModelAttribute Industry searchIndustry, Model model){
//        Industry newIndustry  = new Industry();
        model.addAttribute("searchIndustry", searchIndustry);

        return "industry_dashboard";
    }

    @GetMapping("/search_all")
    public String getMessage(@ModelAttribute Industry searchIndustry,Model model){
//        model.addAttribute("searchIndustry", searchIndustry);

        searchIndustry.setIndustryName("Cafe");
        model.addAttribute("searchIndustry", searchIndustry);
        return "industry_dashboard";
    }



}
