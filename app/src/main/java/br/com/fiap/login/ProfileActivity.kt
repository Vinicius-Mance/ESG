package br.com.fiap.login

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val lvlProgressBar = findViewById<ProgressBar>(R.id.lvlProgressBar)

        lvlProgressBar.max = 1000

        var progress : Int = 600

        ObjectAnimator.ofInt(lvlProgressBar,"progress", progress)
            .setDuration(2000)
            .start()
    }

    fun openHome(view : View){
        val link = Intent(this, Home::class.java)
        startActivity(link)
    }
}