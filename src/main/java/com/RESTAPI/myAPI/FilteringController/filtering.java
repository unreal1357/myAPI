package com.RESTAPI.myAPI.FilteringController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class filtering {

    @GetMapping("/filtering")
    public SomeBean retrieveSomeBean(){
        return new SomeBean("value1", "value 2", "value 3");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> retrieveListOfSomeBean(){
        return Arrays.asList(new SomeBean("value1", "value 2", "value 3"),
                new SomeBean("value12", "value 23", "value 34"));
    }
}
