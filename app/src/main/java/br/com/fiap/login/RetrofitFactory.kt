package br.com.fiap.login

import RetrofitService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    val URL : String= "https://api.github.com/users/"

    val retrofitFactory  = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun retrofitService() : RetrofitService {
        return retrofitFactory.create(RetrofitService::class.java)
    }



}