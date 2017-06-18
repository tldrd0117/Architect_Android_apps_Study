package com.study.iseongjae.retrofitstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.study.iseongjae.retrofitstudy.http.TwitchAPI;
import com.study.iseongjae.retrofitstudy.http.apimodel.Top;
import com.study.iseongjae.retrofitstudy.http.apimodel.Twitch;
import com.study.iseongjae.retrofitstudy.root.App;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    @Inject
    TwitchAPI twitchAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App)getApplication()).getComponent().inject(this);

        Call<Twitch> call = twitchAPI.getTopGames();

        call.enqueue(new Callback<Twitch>() {
            @Override
            public void onResponse(Call<Twitch> call, Response<Twitch> response) {
                List<Top> gameList = response.body().getTop();

                for(Top top : gameList){
                    System.out.println(top.getGame().getName());
                }
            }

            @Override
            public void onFailure(Call<Twitch> call, Throwable t) {
                t.printStackTrace();
            }
        });

        twitchAPI.getTopGamesObservable()
                .flatMap(new Function<Twitch, ObservableSource<Top>>() {
                    @Override
                    public ObservableSource<Top> apply(@NonNull Twitch twitch) throws Exception {
                        return Observable.fromIterable(twitch.getTop());
                    }
                })
                .flatMap(new Function<Top, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(@NonNull Top top) throws Exception {
                        return Observable.just(top.getGame().getName());
                    }
                })
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(@NonNull String s) throws Exception {
                        return s.startsWith("H");
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        System.out.println("fromObserver : " + s);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("complete");

                    }
                });

        twitchAPI.getTopGamesObservable()
                .flatMap(new Function<Twitch, ObservableSource<Top>>() {
                    @Override
                    public ObservableSource<Top> apply(@NonNull Twitch twitch) throws Exception {
                        return Observable.fromIterable(twitch.getTop());
                    }
                })
                .flatMap(new Function<Top, ObservableSource<Integer>>() {
                    @Override
                    public ObservableSource<Integer> apply(@NonNull Top top) throws Exception {
                        return Observable.just(top.getGame().getPopularity());
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer s) {
                        System.out.println("fromObserver popularity : " + s);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("complete");

                    }
                });


    }
}
