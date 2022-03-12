package br.com.fiap.login

import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import com.bumptech.glide.Glide

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val nomePerfil = findViewById<TextView>(R.id.nomePerfil)
        val perfilPontos = findViewById<TextView>(R.id.perfilPontos)
        val iconePerfil = findViewById<de.hdodenhof.circleimageview.CircleImageView>(R.id.iconePerfil)

        val userinfo = this.getSharedPreferences("userinfo", Context.MODE_PRIVATE)

        val name = userinfo.getString("fullName", "Usuário")
        val photo = userinfo.getString("photo", "@drawable/profile_icon")
        val points = userinfo.getString("points", "60")

        nomePerfil.text = name
        perfilPontos.text = "PdPs: "+points
        Glide.with(this).load(photo).into(iconePerfil!!)


        val lvlProgressBar = findViewById<ProgressBar>(R.id.lvlProgressBar)

        lvlProgressBar.max = 1000

        var progress : Int =  points?.toInt() ?: 60

        progress = progress * 10
        
        ObjectAnimator.ofInt(lvlProgressBar,"progress", progress)
            .setDuration(2000)
            .start()
    }

    fun openHome(view : View){
        val link = Intent(this, Home::class.java)
        startActivity(link)
    }

}