package com.farming;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Admin on 2/26/2017.
 */
@Controller
public class FarmController {
    @RequestMapping("/home")
    public  String index(){
        return "index";
    }
}
