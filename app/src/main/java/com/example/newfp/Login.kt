package com.example.newfp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnsign: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        val username ="admin"
        val pwd ="123456"

        val iduser: EditText = findViewById(R.id.idUser)
        val idpass: EditText = findViewById(R.id.idPass)
        val btnlog: Button = findViewById(R.id.btn_login)

        btnsign = findViewById(R.id.btn_sign_up)
        btnsign.setOnClickListener(this)
        btn_google.setOnClickListener(this)
        btn_facebook.setOnClickListener(this)

        btnlog.setOnClickListener {
            if (iduser.text.toString() == username && idpass.text.toString() == pwd){
                intent = Intent(this, HomePage::class.java)
                startActivity(intent)

            }
            else if (iduser.text.isEmpty()||idpass.text.isEmpty()){
                Toast.makeText(this, "Harap isi form login", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Login gagal", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_sign_up ->{
                val signup = Intent(this,SignUp::class.java)
                startActivity(signup)
            }
            R.id.btn_facebook -> {
                val implicitIntentlogin =
                    Intent(Intent.ACTION_VIEW, Uri.parse("www.facebook.com"))
                startActivity(implicitIntentlogin)
            }
            R.id.btn_google-> {
                val implicitgmaillogin =
                    Intent(Intent.ACTION_VIEW, Uri.parse("www.gmail.com"))
                startActivity(implicitgmaillogin)
            }
        }
    }
}