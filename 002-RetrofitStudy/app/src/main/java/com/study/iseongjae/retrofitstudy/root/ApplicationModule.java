package com.study.iseongjae.retrofitstudy.root;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by iseongjae on 2017. 6. 18..
 */

@Singleton
@Module
public class ApplicationModule {
    private Application application;

    public ApplicationModule( Application application ){
        this.application = application;
    }

    @Singleton
    @Provides
    public Application provideContext(){
        return  application;
    }
}
