package com.RESTAPI.myAPI.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component //managed by Spring
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    //User is calling user class, this is where it gets the constructor from that asks for Id, name and date

    private static int usersCount = 3;

    static {
        users.add(new User(1, "adam", new Date()));
        users.add(new User(2, "Jon", new Date()));
        users.add(new User(3, "Mick", new Date()));
    }

    //methods to return a specific user and all the users, and add a us

    //findall method
    public List<User> findAll() { //<User> is the class      findAll is the method name
        return users;
    }

    //save user method
    public User save(User user) {
        if(user.getId()==null){//checking if id is null
            user.setId(++usersCount); //if not setting id
        }
        users.add(user); //adding user to the list
        return user;
    }

    public User findOne(int id){
        for (User user:users){
            if(user.getId()==id){
                return user;
            }
        }
        return null;
    }

    public User DeleteById(int id) {

        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
