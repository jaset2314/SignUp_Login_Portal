package com.tejas.signup_login_portal

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.tejas.signup_login_portal.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding

//    private lateinit var binding:


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

//        auth = Firebase.auth


//        println("mailid is $emailstring and password is $pswd.")

//        val signuptologin = findViewById<Button>(R.id.SignUp_andgoestoLogin)

        binding.SignUpAndgoestoLogin.setOnClickListener {
            Firebase.auth.createUserWithEmailAndPassword(
                binding.SignUpEmail.text.toString(),
                binding.SignUpPaswd.text.toString()
            ).addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, LogInActivity::class.java)
                    startActivity(intent)
                } else if (it.isCanceled) {
                    Toast.makeText(this, "Failure", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "SomeOther Problem", Toast.LENGTH_LONG).show()
                }
            }

        }
        binding.AlreadyAUser.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }


    }

//    public override fun onStart() {
//        super.onStart()
//        // Check if user is signed in (non-null) and update UI accordingly.
//        val currentUser = auth.currentUser
//        if (currentUser != null) {
//            val intent = Intent(this, Portal_SignedIn::class.java)
//            startActivity(intent)
//        }
//    }
}
