package com.cloud.boot.web;

import com.cloud.boot.web.dto.ResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public ResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new ResponseDto(name, amount);
    }
}
