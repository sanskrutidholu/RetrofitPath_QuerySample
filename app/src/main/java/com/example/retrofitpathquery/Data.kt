package com.example.retrofitpathquery

import com.google.gson.annotations.SerializedName


class Data(
    //@field:SerializedName("name") val name: String,
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String,

    val postId: Int,
    val name: String,
    val email: String,
)