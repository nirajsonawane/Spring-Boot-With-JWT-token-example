package com.ns.gwttoken;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resource {


    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "Hello World";
    }
}
