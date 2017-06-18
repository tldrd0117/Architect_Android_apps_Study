package com.study.iseongjae.retrofitstudy.http;

import com.study.iseongjae.retrofitstudy.http.apimodel.Twitch;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

import static com.study.iseongjae.retrofitstudy.http.TwitchAPI.CLIENT_ID;

/**
 * Created by iseongjae on 2017. 6. 18..
 */

public interface TwitchAPI {
    public static final String CLIENT_ID = "Client-ID: 7dav8q9r44eintc5kktq9evsqpw9g2";

    @Headers(CLIENT_ID)
    @GET("games/top")
    Call<Twitch> getTopGames();

    @Headers(CLIENT_ID)
    @GET("games/top")
    Observable<Twitch> getTopGamesObservable();

}
