package com.example.insuranceplanupdated;

import java.util.ArrayList;

public class UserStorage {
    public ArrayList<User> users;

    public UserStorage() {
      users = new ArrayList<User>();
    }
    public void addUser(User user){
         this.users.add(user);
    }

}
