package com.study.iseongjae.daggerstudy.login;

/**
 * Created by iseongjae on 2017. 6. 17..
 */

public class LoginModel implements LoginActivityMVP.Model {
    private LoginRepository repository;

    public LoginModel(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createUser(String fname, String lname) {
        repository.saveUser(new User(fname, lname));
    }

    @Override
    public User getUser() {
        return repository.getUser();
    }
}
