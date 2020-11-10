package com.business.system.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.common.base.ResponseResult;
import com.business.util.test;



@Controller
public class IdxController {
	@RequestMapping("/idx")
    public String indexpage(){ 
        return "/idx";
    }
    @RequestMapping("/jqn")
    public String jqn(){
        return "/jqn";
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
    @RequestMapping("/getName")
    @ResponseBody
    public ResponseResult getName(@RequestBody Map<String,String> map) throws IOException {
        ResponseResult getname = new ResponseResult();
        String name = map.get("name");
        String URL_link = "http://127.0.0.1:5000/hello?place_name=";
        System.out.println("name is :" + name);
        String urls = URL_link + name;
        String new_URL = urls.replace(" ", "%20").replace("é", "%C3%A9");

        List<String> ss_list = new ArrayList<>();
        String ss = test.doPostOrGet(new_URL, "");
        String [] arr2 = ss.split("#");

        System.out.println(ss);
        getname.setData(arr2);
        return getname;

    }

    @RequestMapping("/toPage/{page}")
	public String toPage(@PathVariable String page) {
		 return page;
	}
}
