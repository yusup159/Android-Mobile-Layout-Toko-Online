package com.example.newfp


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


import android.widget.TextView
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity(), View.OnClickListener{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        supportActionBar?.hide()

        back.setOnClickListener(this)
        btn_facebook_signup.setOnClickListener(this)
        btn_google_signup.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.btn_facebook_signup -> {
                val implicitIntent =
                    Intent(Intent.ACTION_VIEW, Uri.parse("www.facebook.com"))
                startActivity(implicitIntent)
            }
            R.id.btn_google_signup -> {
                val implicitgmail =
                    Intent(Intent.ACTION_VIEW, Uri.parse("www.gmail.com"))
                startActivity(implicitgmail)
            }
            R.id.back -> {
                val eksplicitIntent =
                    Intent(this@SignUp, Login::class.java)
                startActivity(eksplicitIntent)
            }
            }
    }


}