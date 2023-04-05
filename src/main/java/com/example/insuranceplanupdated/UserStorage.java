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
    public User findByEmail(String email){

        for (int i = 0; i < this.users.size(); i++) {
            User user = this.users.get(i);
            if (email.equals(user.email)) {
                return user;
            }
        }
        return null;
    }
}
