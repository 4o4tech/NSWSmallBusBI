package com.business.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController_diff {
	@RequestMapping("/idx")
    public String indexpage(){ 
        return "/idx";
    }

	@RequestMapping("/industry_temp")
    public String industry(){ 
        return "industry_diff";
    }
	@RequestMapping("/feedback")
    public String feedback(){ 
        return "feedback";
    }
	@RequestMapping("/FAQs")
    public String FAQs(){ 
        return "FAQs";
    }
	@RequestMapping("/contact")
    public String contact(){ 
        return "contact";
    }
		
	@RequestMapping("/toPage/{page}")
	public String toPage(@PathVariable String page) {
		 return page;
	}
}
