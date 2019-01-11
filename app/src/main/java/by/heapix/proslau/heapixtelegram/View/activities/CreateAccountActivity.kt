package by.heapix.proslau.heapixtelegram.view.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import by.heapix.proslau.heapixtelegram.MainActivity
import by.heapix.proslau.heapixtelegram.R
import by.heapix.proslau.heapixtelegram.model.user.User
import by.heapix.proslau.heapixtelegram.model.user.UserRepository
import kotlinx.android.synthetic.main.activity_create_account.*

class CreateAccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        btnCreateAccount.setOnClickListener {
            if(inputNickname.text.isEmpty() || inputPhone.text.isEmpty() || inputPassword.text.isEmpty()){
                Toast.makeText(applicationContext, "Please input all fields", Toast.LENGTH_SHORT).show()
            } else if(!inputPassword.text.toString().equals(inputConfirmPassword.text.toString())){
                Toast.makeText(applicationContext, "Passwords must match", Toast.LENGTH_SHORT).show()
            } else {
                val newUser = User(User.counter++, inputPhone.text.toString(),
                    inputNickname.text.toString(), inputPassword.text.toString())
                UserRepository(this).create(newUser)
                Toast.makeText(this, "User is created", Toast.LENGTH_SHORT).show()
                val intent = Intent(applicationContext, MainActivity::class.java)
                intent.putExtra("nickname", inputNickname.text.toString())
                startActivity(intent)
            }
        }
    }
}
