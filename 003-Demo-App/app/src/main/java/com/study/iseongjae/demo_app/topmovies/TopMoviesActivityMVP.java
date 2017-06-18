package com.study.iseongjae.demo_app.topmovies;

import io.reactivex.Observable;

/**
 * Created by iseongjae on 2017. 6. 18..
 */

public interface TopMoviesActivityMVP {
    interface View{
        void updateData();
        void showSnackbar(String s);
    }

    interface Presenter{
        void loadData();
        void rxUnsubscribe();
        void setView(TopMoviesActivityMVP.View view);
    }

    interface Model{
        Observable result();
    }
}
