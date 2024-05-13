package com.tejas.signup_login_portal

import android.widget.TextView
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.auth
import com.google.firebase.Firebase
import com.tejas.signup_login_portal.databinding.ActivityPortalSignedInBinding


class Portal_SignedIn : AppCompatActivity() {
    private lateinit var bindingportal: ActivityPortalSignedInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        bindingportal = ActivityPortalSignedInBinding.inflate(layoutInflater)
        setContentView(bindingportal.root)

        val user = Firebase.auth.currentUser
        user?.let {
            var email = it.email.toString()
        }

        val textView = TextView(this)
        textView.text = user?.email.toString()
        textView.textSize = 24f
//        textView.setTextColor(resources.getColor(android.R.color.black))

        setContentView(textView)



            setContentView(R.layout.activity_portal_signed_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}