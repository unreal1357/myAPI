package com.RESTAPI.myAPI.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired //not sure what this is
    private UserDaoService service;

    //methods to retrieve all users, retrieve single user using ID as input

    //GET /users
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    //GET /users/id
    @GetMapping("/users/{id}")
    public User retrieveUsers(@PathVariable int id){
        User user = service.findOne(id);
        if(user ==null)
            throw new UserNotFoundException("id-" + id);

        //not using HATEOAS, has issues when using swagger
        //HATEOAS to also show option to view all users rather than just the one specific searched
        //EntityModel<User> model = new EntityModel<>(user);
        //WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        //model.add(linkTo.withRel("all-users"));

        return user;
    }

    //delete a user, will return status code 200 if successful
    @DeleteMapping("/users/{id}")
    public void deleteUsers(@PathVariable int id){
        User user = service.DeleteById(id);
        if(user ==null)
            throw new UserNotFoundException("id-" + id);
    }

    //created status code when post request successful
    //output - created and return created URL
    //@valid adds validator to method
    @PostMapping ("/users") //mapped to post request to /users
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){ //get the request details into the body user
        User SavedUser = service.save(user); //saving it (save is a method created in UserDaoService because ID is null it will create a new one from usercount


        //create a status code when users is successfully created and add new id in response of new user
        URI location = ServletUriComponentsBuilder //location is the full url that is created
                .fromCurrentRequest() //gives current request "/users"
                .path("/{id}") //appends /id onto the end of /users to make it show /users/{createdId}
                .buildAndExpand(SavedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}

