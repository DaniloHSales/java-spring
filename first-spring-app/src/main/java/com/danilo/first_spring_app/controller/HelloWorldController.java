package com.danilo.first_spring_app.controller;

import com.danilo.first_spring_app.domain.User;
import com.danilo.first_spring_app.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
// STATELESS -> (token) a cada nova requisição, eu recebo todas as informações que eu preciso para fazer aquela funcionalidade que o cliente ta pedindo
// STATEFULL -> o estado de cada cliente é mantido no servidor
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping("/")
    public String helloWorld(){
        return helloWorldService.helloWorld("Danilo");
    }

    @PostMapping("/{id}")
    public String helloWorldPost(@PathVariable String id, @RequestBody User body){
        return "Hello World Post" + body.getName() + id;
    }




}
