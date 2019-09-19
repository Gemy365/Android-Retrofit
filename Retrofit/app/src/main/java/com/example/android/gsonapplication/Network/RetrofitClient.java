package com.example.android.gsonapplication.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    // Initialize value.
    private static Retrofit retrofit = null;

    // Call it into Main Activity.
    public static Retrofit getClient(){
        // Check If It Null.. True.
        if (retrofit == null){
            // Builder Retrofit.
            retrofit = new Retrofit.Builder()
                    // BaseURL.
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    // Convert Json To Gson to allow java to understand it.
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        // Return.
        return retrofit;
    }
}
