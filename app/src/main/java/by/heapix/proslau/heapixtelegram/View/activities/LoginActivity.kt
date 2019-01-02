package by.heapix.proslau.heapixtelegram.view.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import by.heapix.proslau.heapixtelegram.MainActivity
import by.heapix.proslau.heapixtelegram.R
import kotlinx.android.synthetic.main.login.*

class LoginActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        btnLogin.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(applicationContext, inputNickname.text, Toast.LENGTH_SHORT).show()
        }
        btnCreateNewAccount.setOnClickListener {
            val intent = Intent(applicationContext, CreateAccountActivity::class.java)
            startActivity(intent)
        }
    }

}