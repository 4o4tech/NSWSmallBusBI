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


