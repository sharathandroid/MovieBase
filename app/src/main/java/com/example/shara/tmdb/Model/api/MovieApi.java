package com.example.shara.tmdb.Model.api;

/**
 * Created by shara on 3/16/2017.
 */

import retrofit2.http.GET;

/**
 * Created by Filippo-TheAppExpert on 9/2/2015.
 */
public interface MovieApi {

    @GET("3/movie/now_playing?api_key=55957fcf3ba81b137f8fc01ac5a31fb5&language=en-US&page=undefined")
    //void getMovies(Callback <String> movies);
    MovieApi getMovies();
}
