package com.study.iseongjae.retrofitstudy.root;

import android.app.Application;

import com.study.iseongjae.retrofitstudy.http.ApiModule;

/**
 * Created by iseongjae on 2017. 6. 18..
 */

public class App extends Application {
    ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .apiModule(new ApiModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
