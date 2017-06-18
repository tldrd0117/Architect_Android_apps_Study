package com.study.iseongjae.demo_app.root;

import com.study.iseongjae.demo_app.topmovies.TopMoviesActivity;

import dagger.Component;

/**
 * Created by iseongjae on 2017. 6. 18..
 */

@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(TopMoviesActivity target);
}
