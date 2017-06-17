package com.study.iseongjae.daggerstudy.root;

import android.app.Application;

import com.study.iseongjae.daggerstudy.login.LoginModule;


/**
 * Created by iseongjae on 2017. 6. 17..
 */

public class App extends Application {
    ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .loginModule(new LoginModule())
                .build();
    }

    public ApplicationComponent getComponent(){
        return component;
    }
}
