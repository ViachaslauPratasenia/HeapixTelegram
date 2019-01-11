package by.heapix.proslau.heapixtelegram.view.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import by.heapix.proslau.heapixtelegram.MainActivity
import by.heapix.proslau.heapixtelegram.R
import by.heapix.proslau.heapixtelegram.model.user.User
import by.heapix.proslau.heapixtelegram.model.user.UserRepository
import kotlinx.android.synthetic.main.login.*

class LoginActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        btnLogin.setOnClickListener {
            if (UserRepository(this).isUserValid(inputNickname.text.toString(), inputPassword.text.toString())){
                val intent = Intent(applicationContext, MainActivity::class.java)
                intent.putExtra("nickname", inputNickname.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(this, "The username or password you entered is incorrect", Toast.LENGTH_LONG).show()
            }
        }
        btnCreateNewAccount.setOnClickListener {
            val intent = Intent(applicationContext, CreateAccountActivity::class.java)
            startActivity(intent)
        }
    }
}