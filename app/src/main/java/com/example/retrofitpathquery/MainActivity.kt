package com.example.retrofitpathquery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var textViewResult : TextView
    lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewResult = findViewById(R.id.text_view_result)

        //getComments()
        //getPosts()
        //getPostQuery()
        //getDiffPostId()
        //getMultipleQuery()
        gettingEndpointDirect()

    }

    private fun gettingEndpointDirect() {
        val call : Call<List<Data>> = RetrofitBuilder.postApi.getComments("https://jsonplaceholder.typicode.com/posts/3/comments")
        call.enqueue(object : Callback<List<Data>> {
            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
                if (!response.isSuccessful) {
                    textViewResult.text = "Code: " + response.code()
                    return
                }
                val comment : List<Data>? = response.body()
                for (data in comment!!) {
                    var content = ""
                    content += "ID: " + data.id + "\n"
                    content += "PostID: " + data.postId + "\n"
                    content += "Name: " + data.name + "\n"
                    content += "Email: " + data.email + "\n"
                    content += "Text: " + data.body + "\n"

                    textViewResult.append(content)
                }
            }

            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                textViewResult.text = t.message;
            }

        })
    }

    private fun getMultipleQuery() {

        val parameters: MutableMap<String, String> = HashMap()
        parameters["userId"] = "1"
        parameters["_sort"] = "id"
        parameters["_order"] = "desc"

        val call : Call<List<Data>> = RetrofitBuilder.postApi.getPostOnMultipleQuery(parameters)
        call.enqueue(object : Callback<List<Data>> {
            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
                if (!response.isSuccessful) {
                    textViewResult.text = "Code: " + response.code()
                    return
                }
                val datas : List<Data>? = response.body()
                for (data in datas!!) {
                    var content = ""
                    content += "ID:" + data.id + "\n"
                    content += "UserID:" + data.userId + "\n"
                    content += "Title:" + data.title + "\n"
                    content += "Text:" + data.body + "\n"

                    textViewResult.append(content)
                }
            }

            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                textViewResult.text = t.message;
            }

        })
    }

    private fun getPostQuery() {
        val call : Call<List<Data>> = RetrofitBuilder.postApi.getPostQuery(1,"id", "desc")
        call.enqueue(object : Callback<List<Data>> {
            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
                if (!response.isSuccessful) {
                    textViewResult.text = "Code: " + response.code()
                    return
                }
                val datas : List<Data>? = response.body()
                for (data in datas!!) {
                    var content = ""
                    content += "ID:" + data.id + "\n"
                    content += "UserID:" + data.userId + "\n"
                    content += "Title:" + data.title + "\n"
                    content += "Text:" + data.body + "\n"

                    textViewResult.append(content)
                }
            }

            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                textViewResult.text = t.message;
            }

        })
    }

    private fun getDiffPostId() {
        val call : Call<List<Data>> = RetrofitBuilder.postApi.getdiffPostIdComments(4)
        call.enqueue(object : Callback<List<Data>> {
            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
                if (!response.isSuccessful) {
                    textViewResult.text = "Code: " + response.code()
                    return
                }
                val datas : List<Data>? = response.body()
                for (data in datas!!) {
                    var content = ""
                    content += "ID: " + data.id + "\n"
                    content += "PostID: " + data.postId + "\n"
                    content += "Name: " + data.name + "\n"
                    content += "Email: " + data.email + "\n"
                    content += "Text: " + data.body + "\n"

                    textViewResult.append(content)
                }
            }

            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                textViewResult.text = t.message;
            }

        })
    }

    private fun getPosts() {
        val call : Call<List<Data>> = RetrofitBuilder.postApi.getPosts()
        call.enqueue(object : Callback<List<Data>> {
            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
                if (!response.isSuccessful) {
                    textViewResult.text = "Code: " + response.code()
                    return
                }
                val datas : List<Data>? = response.body()
                for (data in datas!!) {
                    var content = ""
                    content += "ID:" + data.id + "\n"
                    content += "UserID:" + data.userId + "\n"
                    content += "Title:" + data.title + "\n"
                    content += "Text:" + data.body + "\n"

                    textViewResult.append(content)
                }
            }

            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                textViewResult.text = t.message;
            }

        })
    }

    private fun getComments() {
        val call : Call<List<Data>> = RetrofitBuilder.postApi.getComments()
        call.enqueue(object : Callback<List<Data>> {
            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
                if (!response.isSuccessful) {
                    textViewResult.text = "Code: " + response.code()
                    return
                }
                val comment : List<Data>? = response.body()
                for (data in comment!!) {
                    var content = ""
                    content += "ID: " + data.id + "\n"
                    content += "PostID: " + data.postId + "\n"
                    content += "Name: " + data.name + "\n"
                    content += "Email: " + data.email + "\n"
                    content += "Text: " + data.body + "\n"

                    textViewResult.append(content)
                }
            }

            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                textViewResult.text = t.message;
            }

        })
    }
}