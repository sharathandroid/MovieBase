package com.example.shara.tmdb.Model.api;

/**
 * Created by shara on 3/16/2017.
 */

import com.example.shara.tmdb.Model.Utilities.Constants;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Filippo-TheAppExpert on 9/2/2015.
 */
public class RestApiManager {

    private MovieApi mMovieApi;

    public MovieApi getMovieApi() {

        if(mMovieApi == null) {
            GsonBuilder gson = new GsonBuilder();
            gson.registerTypeAdapter(String.class, new StringDesirializer());

            mMovieApi = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(MovieApi.class);
        }
        return mMovieApi;
    }

}
