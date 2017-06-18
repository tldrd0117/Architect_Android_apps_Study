package com.study.iseongjae.demo_app.root;

import android.app.Application;

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
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
