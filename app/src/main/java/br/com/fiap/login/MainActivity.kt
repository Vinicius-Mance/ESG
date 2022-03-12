package br.com.fiap.login

import UserInfo
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEntrar = findViewById<Button>(R.id.btnEntrar)
        val userName = findViewById<EditText>(R.id.userName)
        val userPassword = findViewById<EditText>(R.id.userPassword)


        btnEntrar.setOnClickListener {

             val call = RetrofitFactory().retrofitService().getUser(userName.text.toString())

             call.enqueue(object : Callback<UserInfo> {


            override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {

                response.body()?.let {
                    if (it.password == userPassword.text.toString()) {
                        val name : String = it.full_name ?: it.user_name
                        val photo : String = it.photo
                        val points : String = it.points
                        saveUser(name,photo,points)
                        goToHome()
                    } else {
                        Toast.makeText(this@MainActivity, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show()
                    }
                } ?: Toast.makeText(this@MainActivity, "usuário não encontrado", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<UserInfo>, t: Throwable?) {
                t?.message?.let { it1 -> Log.e("Erro", it1) }
            }
         })
        }
    }

    fun goToHome(){
        val link = Intent(this, Home::class.java)
        startActivity(link)
    }

    fun saveUser(fullName : String, photo : String, points : String){

        val persistenceUser = this.getSharedPreferences("userinfo", Context.MODE_PRIVATE)
        val editor = persistenceUser.edit()


        editor.putString("fullName",fullName)
        editor.putString("photo",photo)
        editor.putString("points", points)
        editor.apply()
    }
}