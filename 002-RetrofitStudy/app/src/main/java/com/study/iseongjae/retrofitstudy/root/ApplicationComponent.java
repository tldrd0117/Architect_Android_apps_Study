package com.study.iseongjae.retrofitstudy.root;

import com.study.iseongjae.retrofitstudy.MainActivity;
import com.study.iseongjae.retrofitstudy.http.ApiModule;

import dagger.Component;
import dagger.Module;

/**
 * Created by iseongjae on 2017. 6. 18..
 */

@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {
    void inject(MainActivity target);
}
