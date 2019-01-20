package by.heapix.proslau.heapixtelegram.view.activities

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import by.heapix.proslau.heapixtelegram.R
import by.heapix.proslau.heapixtelegram.model.user.User
import by.heapix.proslau.heapixtelegram.model.user.UserRepository

class SettingsPhoneActivity : AppCompatActivity() {

    lateinit var user : User
    lateinit var editPhone : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_phone)

        val toolbar = findViewById<View>(R.id.settings_phone_toolbar) as Toolbar
        toolbar.title = "Phone number"
        setSupportActionBar(toolbar)
        val actionBar : ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowHomeEnabled(true)

        val username = intent.getStringExtra("username") as String
        user = UserRepository(this).findUser(username)

        editPhone = findViewById<View>(R.id.settings_phone_et) as EditText
        editPhone.setText(user.phone)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.action_confirm -> {
                user.phone = editPhone.text.toString()
                UserRepository(this).update(user)
                val intent = Intent()
                intent.putExtra("phone", user.phone)
                setResult(Activity.RESULT_OK, intent)
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_settings_confirm, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
