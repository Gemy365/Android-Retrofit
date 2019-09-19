package com.example.android.gsonapplication;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface JsonPlaceHolderAPI {

    //-----------------------------------GET---------------------------------------------

    /**
     * @GET to Get data from json [HTTP Web Server].
     *
     * Full URL: https://jsonplaceholder.typicode.com/posts
     * Base URL: https://jsonplaceholder.typicode.com/
     * Relative URL: posts
     *
     * posts is [relative url] because we will use [base url] into RetrofitClient Class.
     *
     * 'Call' is as a Data type like int, String, double, etc... from 'retrofit2 library'
     * take List of Own class to return all of data from server & convert it into Java objects.
     *
     * getPost() is a method's name not declare because we are in Interface.
     *
     **/
    @GET("posts")
    Call<List<PostClass>> getPost();

    /**
     * @GET To Get data from json [HTTP Web Server].
     *
     * Full URL: https://jsonplaceholder.typicode.com/posts?userId=2
     * Base URL: https://jsonplaceholder.typicode.com/
     * Relative URL: posts?userId=2    hint:- userId=2 will get post of userId 2. You can change number.
     *
     * posts?userId=2 is [relative url] because we will use [base url] into RetrofitClient Class.
     *
     * @Query("userId") .. Query makes '?' or '&' by default into relative url
     * '?' is as 'where condition' ... '&' is as 'AND condition' when there're more than one Query.
     *
     * 'userId' is as the same as into relative url. userId='Any number of id'
     *
     * 'Call' is as a Data type like int, String, double, etc... from 'retrofit2 library'
     * take List of Own class to return all of data from server & convert it into Java objects.
     *
     * getPost() is a method's name not declare because we are in Interface.
     *
     **/
    @GET("posts")
    Call<List<PostClass>> getPost(@Query("userId") int userID);

    /**
     * @GET To Get data from json [HTTP Web Server].
     *
     * Full URL: https://jsonplaceholder.typicode.com/posts?userId=2&userId=4&_sort=id&_order=desc
     * Base URL: https://jsonplaceholder.typicode.com/
     * Relative URL: posts?userId=2&userId=4&_sort=id&_order=desc
     * hint:- userId=2 & userId=4 will get post of userId 2 & userId 4 only. You can change number.
     *
     * posts?userId=2&userId=4&_sort=id&_order=desc is [relative url]
     * because we will use [base url] into RetrofitClient Class.
     *
     * @Query .. Query makes '?' or '&' by default into relative url
     * '?' is as 'where condition' ... '&' is as 'AND condition' when there're more than one Query.
     *
     * @Query("userId") Integer[] userID ... Array of userId allow you to choose more than one ID.
     * 'userId' is as the same as into relative url. userId='Any number of id'
     *
     * @Query("_sort") String Sort ... don't forget to add '_' before sort
     * Allow you to sort by id, userId or any param you want to sort by.
     *
     * @Query("_order") String Order ... don't forget to add '_' before order
     * Allow you to order by asc or desc.
     *
     * 'Call' is as a Data type like int, String, double, etc... from 'retrofit2 library'
     * take List of Own class to return all of data from json & convert it into Java objects.
     *
     * getPost() is a method's name not declare because we are in Interface.
     *
     **/
    @GET("posts")
    Call<List<PostClass>> getPost(@Query("userId") Integer[] userID,
                                  @Query("_sort")  String Sort,
                                  @Query("_order") String Order);

    /**
     * @GET To Get data from json [HTTP Web Server].
     *
     * Full URL: https://jsonplaceholder.typicode.com/posts?userId=2&userId=4&_sort=id&_order=desc
     * Base URL: https://jsonplaceholder.typicode.com/
     * Relative URL: posts?userId=2&userId=4&_sort=id&_order=desc
     * hint:- userId=2 & userId=4 will get post of userId 2 & userId 4 only. You can change number.
     *
     * posts?userId=2&userId=4&_sort=id&_order=desc is [relative url]
     * because we will use [base url] into RetrofitClient Class.
     *
     * @QueryMap .. QueryMap allows Map has Two Strings,
     * First String is for param into relative url as 'key'.
     * Second String is for param into relative url as 'value'.
     *
     * 'Call' is as a Data type like int, String, double, etc... from 'retrofit2 library'
     * take List of Own class to return all of data from server & convert it into Java objects.
     *
     * getPost() is a method's name not declare because we are in Interface.
     *
     **/
    @GET("posts")
    Call<List<PostClass>> getPost(@QueryMap Map<String , String> Parameters);

    //-----------------------------------POST---------------------------------------------

    /**
     * @POST to post data to server [HTTP Web Server].
     *
     * Full URL: https://jsonplaceholder.typicode.com/posts
     * Base URL: https://jsonplaceholder.typicode.com/
     * Relative URL: posts
     *
     * posts is [relative url] because we will use [base url] into RetrofitClient Class.
     *
     * @Body collect all data from own PostClass and convert it to json to send it to server.
     *
     * 'Call' is as a Data type like int, String, double, etc... from 'retrofit2 library'
     * use Own class to send all of data to server & convert it to json objects.
     *
     * createPost() is a method's name not declare because we are in Interface.
     *
     **/
    @POST("posts")
    Call<PostClass> createPost(@Body PostClass postClass);

    /**
     * @POST to post data to server [HTTP Web Server].
     *
     * Full URL: https://jsonplaceholder.typicode.com/posts
     * Base URL: https://jsonplaceholder.typicode.com/
     * Relative URL: posts
     *
     * posts is [relative url] because we will use [base url] into RetrofitClient Class.
     *
     * @FormUrlEncoded used with @Field collect all data from own PostClass and convert it to UrlEncoded to send it to server.
     *
     * Json        >> { Name : 'John Smith', Age: 23}
     * UrlEncoded  >> Name=John+Smith&Age=23
     *
     * @Field allow you to send separated item to server.
     *
     * 'Call' is as a Data type like int, String, double, etc... from 'retrofit2 library'
     * use Own class to send all of data to server & convert it to UrlEncoded objects.
     *
     * createPost() is a method's name not declare because we are in Interface.
     *
     **/
    @FormUrlEncoded
    @POST("posts")
    Call<PostClass> createPost(
            @Field("userId") int UserID,
            @Field("title") String Title,
            @Field("body") String Text);


    /**
     * @POST to post data to server [HTTP Web Server].
     *
     * Full URL: https://jsonplaceholder.typicode.com/posts
     * Base URL: https://jsonplaceholder.typicode.com/
     * Relative URL: posts
     *
     * posts is [relative url] because we will use [base url] into RetrofitClient Class.
     *
     * @FormUrlEncoded used with @FieldMap collect all data from own PostClass and convert it to UrlEncoded to send it to server.
     *
     * Json        >> { Name : 'John Smith', Age: 23}
     * UrlEncoded  >> Name=John+Smith&Age=23
     *
     * @FieldMap allows Map has Two Strings,
     * First String is for param into relative url as 'key'.
     * Second String is for param into relative url as 'value'.
     *
     * 'Call' is as a Data type like int, String, double, etc... from 'retrofit2 library'
     * use Own class to send all of data to server & convert it to UrlEncoded objects.
     *
     * createPost() is a method's name not declare because we are in Interface.
     *
     **/
    @FormUrlEncoded
    @POST("posts")
    Call<PostClass> createPost(@FieldMap Map<String , String> Fields);

    //-----------------------------------PUT---------------------------------------------

    /**
     * @PUT to update data to server [HTTP Web Server].
     *
     * Full URL: https://jsonplaceholder.typicode.com/posts/1
     * Base URL: https://jsonplaceholder.typicode.com/
     * Relative URL: posts/1    hint:- you can write Any number of [id], in this case I wrote 1.
     *
     * posts/{id} is [relative url] because we will use [base url] into RetrofitClient Class.
     *
     * @Path("id") Allow you to pass id param to url directly into {id}.
     * 'id' is as the same as into relative url. {id} >> 'Write any number of id'
     * @Body collect all data from own PostClass and convert it to json to send it to server.
     *
     * Difference between PUT & PATCH
     *
     * PUT   >> Must update all data & if you pass 'null' to specific param it will be 'null'.
     * PATCH >> Just update specific data & if you pass 'null' to specific param it will still as it was before.
     * [null] in this case mean don't change it.
     *
     * 'Call' is as a Data type like int, String, double, etc... from 'retrofit2 library'
     * use Own class to send all of data to server & convert it to json objects.
     *
     * putPost() is a method's name not declare because we are in Interface.
     *
     **/
    @PUT("posts/{id}")
    Call<PostClass> putPost(@Path("id") int id, @Body PostClass postClass);

    //-----------------------------------PATCH---------------------------------------------

    /**
     * @PATCH to update data to server [HTTP Web Server].
     *
     * Full URL: https://jsonplaceholder.typicode.com/posts/1
     * Base URL: https://jsonplaceholder.typicode.com/
     * Relative URL: posts/1    hint:- you can write Any number of [id], in this case I wrote 1.
     *
     * posts/{id} is [relative url] because we will use [base url] into RetrofitClient Class.
     *
     * @Path("id") Allow you to pass id param to url directly into {id}.
     * 'id' is as the same as into relative url. {id} >> 'Write any number of id'
     * @Body collect all data from own PostClass and convert it to json to send it to server.
     *
     * Difference between PUT & PATCH
     *
     * PUT   >> Must update all data & if you pass 'null' to specific param it will be 'null'.
     * PATCH >> Just update specific data & if you pass 'null' to specific param it will still as it was before.
     * [null] in this case mean don't change it.
     *
     * 'Call' is as a Data type like int, String, double, etc... from 'retrofit2 library'
     * use Own class to send all of data to server & convert it to json objects.
     *
     * patchPost() is a method's name not declare because we are in Interface.
     *
     **/
    @PATCH("posts/{id}")
    Call<PostClass> patchPost(@Path("id") int id, @Body PostClass postClass);

    //-----------------------------------DELETE---------------------------------------------

    /**
     * @DELETE to update data to server [HTTP Web Server].
     *
     * Full URL: https://jsonplaceholder.typicode.com/posts/1
     * Base URL: https://jsonplaceholder.typicode.com/
     * Relative URL: posts/1    hint:- you can write Any number of [id], in this case I wrote 1.
     *
     * posts/{id} is [relative url] because we will use [base url] into RetrofitClient Class.
     *
     * @Path("id") Allow you to pass id param to url directly into {id}.
     * 'id' is as the same as into relative url. {id} >> 'Write any number of id'
     *
     * 'Call' is as a Data type like int, String, double, etc... from 'retrofit2 library'
     * use Own class to send all of data to server & convert it to json objects.
     *
     * deletePost() is a method's name not declare because we are in Interface.
     *
     **/
    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);

}
