package edu.finance.visualchartforcovid19.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class index {


    @GetMapping("/query")
    @ResponseBody
    public String query1(){


        return "0";
    }



}
