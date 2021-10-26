package com.example.retrofitpathquery

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap
import retrofit2.http.Url








interface ApiService {

    @GET("posts")
    fun getPosts(): Call<List<Data>>

    @GET("posts/1/comments")
    fun getComments() : Call<List<Data>>

    // for diff diff post id instead of 1 we will do
    @GET("posts/{id}/comments")
    fun getdiffPostIdComments(@Path("id") postId : Int) : Call<List<Data>>

    // for query
    @GET("posts")
    fun getPostQuery(
        @Query("userId") userId : Int,
        @Query("_sort") sort : String,
        @Query("_order") order : String
    ): Call<List<Data>>

    // for multiple userid using query annotation
    @GET("posts")
    fun getMultipleUserId(
        @Query("userId") userId: Array<Int?>?,
        @Query("_sort") sort: String?,
        @Query("_order") order: String?
    ): Call<List<Data>>

    // for multiple queries
    @GET("posts")
    fun getPostOnMultipleQuery(@QueryMap parameters: Map<String, String>): Call<List<Data>>

    // for passing end points directly
    @GET
    fun getComments(@Url url: String?): Call<List<Data>>


}