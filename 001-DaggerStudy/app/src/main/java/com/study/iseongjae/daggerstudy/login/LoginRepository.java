package com.study.iseongjae.daggerstudy.login;

/**
 * Created by iseongjae on 2017. 6. 17..
 */

public interface LoginRepository {
    User getUser();
    void saveUser(User user);

}
