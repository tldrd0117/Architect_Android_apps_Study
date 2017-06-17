package com.study.iseongjae.daggerstudy.login;

/**
 * Created by iseongjae on 2017. 6. 17..
 */

public class User {
    private  int id;
    private  String firstName;
    private  String lastName;

    public User(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String fname, String lname) {
        this.firstName = fname;
        this.lastName = lname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
