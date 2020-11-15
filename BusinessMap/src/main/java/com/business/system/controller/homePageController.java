package com.business.system.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class homePageController {
    @RequestMapping(value="")
    public String defualtPage(){
        return "homePage";
    }

    @RequestMapping(value="/index")
    public String homePage(){
        return "homePage";
    }

    @RequestMapping("/location_dashboard")
    public String locationPage(){
        return "idx";
    }

    @RequestMapping("/license_dashboard")
    public String licensePage(){
        return "license";
    }

    @RequestMapping("/demographic")
    public String testGraph(){
        return "demographic_graphic";
    }

    @RequestMapping("/article")
    public String industryArticle(){
        return "blog/industry_article";
    }

    @RequestMapping("/VAarticle")
    public String VAArticle(){
        return "blog/VA_article";
    }

}
//
//@Controller
//public class IndexController {
//    @RequestMapping("/test")
//    public String test(){
//        return "index";
//    }
//
//}


