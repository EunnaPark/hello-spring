package com.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController{

    @GetMapping("com/hello")
    public String hello(Model model){
        model.addAttribute("data", " world!!");
        return "com/hello"; //return page. with using viewResolver
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model){

        model.addAttribute("name", name);
        return "hello-template"; //return static page with using viewResolver
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam(value = "name") String name, Model model){

        return "com/hello" + name; // set down data with using viewResolver
    }

    @GetMapping("hello-api")
    @ResponseBody
    //if it is ResponseBody present with object and string
    //HttpMessageConvert which has
    //JsonConvert(MappingJackson2HttpMessageConverter) - jackson as basic usage into lib.
    //StringConvert(StringHttpMessageConverter)
    public Hello hellpApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //Json data structure.

    }
    static class Hello{
        private String name;
        //getter and setter, to avoid directly reaching to the data variable.
        //javaBean rule. property approach
        public String getName(){
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}