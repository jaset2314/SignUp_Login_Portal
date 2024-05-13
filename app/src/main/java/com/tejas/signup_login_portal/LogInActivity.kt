package com.tejas.signup_login_portal

import android.content.Intent
import android.os.Bundle
import android.widget.Toast

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.auth.auth
import com.google.firebase.Firebase
import com.tejas.signup_login_portal.databinding.ActivityLogInBinding
import com.tejas.signup_login_portal.Portal_SignedIn

class LogInActivity : AppCompatActivity() {

    private lateinit var bindinglogin: ActivityLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        bindinglogin = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(bindinglogin.root)

        bindinglogin.LogIn.setOnClickListener{
            Firebase.auth.signInWithEmailAndPassword(
                bindinglogin.LogInEmail.text.toString(),
                bindinglogin.LogInPaswd.text.toString()
            ).addOnCompleteListener(this){
                if(it.isSuccessful){
                    Toast.makeText(this, "Logged In", Toast.LENGTH_LONG).show()

                    val user = Firebase.auth.currentUser
//                    updateUI(user)
                    val intent = Intent(this, Portal_SignedIn::class.java)
                    startActivity(intent)
                }else if(it.isCanceled){
                    Toast.makeText(this, "Failure", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this, "SomeOther Problem", Toast.LENGTH_LONG).show()
                }
            }
        }

        bindinglogin.NewUserGoesToSignUp.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }





    }
}