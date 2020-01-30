package com.RESTAPI.myAPI.helloworld;

//this is a bean called helloworldbean which accepts a message and is reffered to in the controller class
//

public class HelloWorldBean {

    private String message;

    public HelloWorldBean(String message) { //a method with a constructor that returns the string message
        this.message = message;
    }

    public String getMessage() { //this is a getter
        return message;
    }

    public void setMessage(String message) { //this is a setter
        this.message = message;
    }

    @Override
    public String toString() { //converting to string
        return "HellowWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
