package com.RESTAPI.myAPI.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;


//first thing to do is to tell spring this is a controller
@RestController//tells spring to handle this as a rest request
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    //what method? GET method
    //Use URL Resource /hello-world
    //method -- return "hello world"
    @GetMapping(path = "/hello-world") //creating the get resource link
    public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required = false) Locale locale){ //adding a request header to output "Good morning" in difference languages (Set up in french so far also)
        return messageSource.getMessage("good.morning.message",null, locale); //this is the result when going to the /hello-world resource
    }

    //hello-world-bean is a method that creates a bean and returning it it rather than a string
    //this creates a new message called "hello World"
    //it refers to the hellowWorldBean class which creates a new messages and sets the message that is set in this method "hello world"
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World"); //hello world bean is being returned with the value hello world
        //hello world is the value of message
    }

    //"/hello-world-bean/path-variable/myPath" will be mapped to {name} variable
    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){ //use @PathVariable to create paths
        return new HelloWorldBean(String.format("Hello World, %s", name)); //%s is replaced with name
    }
}
