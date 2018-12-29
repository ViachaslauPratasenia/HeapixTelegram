package by.heapix.proslau.heapixtelegram.View.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import by.heapix.proslau.heapixtelegram.MainActivity
import by.heapix.proslau.heapixtelegram.R
import kotlinx.android.synthetic.main.activity_create_account.*

class CreateAccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        btnCreateAccount.setOnClickListener {
            if(inputEmail.text.isEmpty() || inputPhone.text.isEmpty() || inputPassword.text.isEmpty()){
                Toast.makeText(applicationContext, "Please input all fields", Toast.LENGTH_SHORT).show()
            } else if(inputPassword.text.equals(inputConfirmPassword.text)){
                Toast.makeText(applicationContext, "Passwords must match", Toast.LENGTH_SHORT).show()
            } else{
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
