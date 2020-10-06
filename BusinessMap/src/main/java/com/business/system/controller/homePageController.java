package com.business.system.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class homePageController {
    @RequestMapping("/index")
    public String homePage(){
        return "homePage";
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



/*
@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

}
*/

