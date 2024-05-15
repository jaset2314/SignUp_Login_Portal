package com.tejas.signup_login_portal

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.tejas.signup_login_portal.databinding.ActivityStoringDataFbrtimeDbBinding

class StoringData_FBRtimeDB : AppCompatActivity() {
    private lateinit var binding: ActivityStoringDataFbrtimeDbBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityStoringDataFbrtimeDbBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.submit.setOnClickListener{

            val usnam = binding.uname.text.toString()
            val fname = binding.fname.text.toString()

            database = FirebaseDatabase.getInstance().getReference()


        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}