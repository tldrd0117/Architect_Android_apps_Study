package com.study.iseongjae.daggerstudy.root;

import com.study.iseongjae.daggerstudy.login.LoginActivity;
import com.study.iseongjae.daggerstudy.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by iseongjae on 2017. 6. 17..
 */

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent {
    void inject(LoginActivity target);
}
