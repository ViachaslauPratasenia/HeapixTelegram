package by.heapix.proslau.heapixtelegram.view.activities

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import by.heapix.proslau.heapixtelegram.R
import by.heapix.proslau.heapixtelegram.model.user.User
import by.heapix.proslau.heapixtelegram.model.user.UserRepository

class SettingsEditNameActivity : AppCompatActivity() {

    lateinit var firstName : EditText
    lateinit var lastName : EditText
    lateinit var user : User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_edit_name)

        val toolbar = findViewById<View>(R.id.settings_edit_name_toolbar) as Toolbar
        toolbar.title = "Name"
        setSupportActionBar(toolbar)
        val actionBar : ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowHomeEnabled(true)

        val username = intent.getStringExtra("username") as String
        user = UserRepository(this).findUser(username)

        firstName = findViewById<View>(R.id.settings_edit_name_first) as EditText
        lastName = findViewById<View>(R.id.settings_edit_name_last) as EditText

        val name = user.name.split(" ")
        firstName.setText(name[0])
        lastName.setText(name[1])
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_settings_confirm, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.action_confirm -> {
                user.name = "${firstName.text} ${lastName.text}"
                UserRepository(this).update(user)
                val intent = Intent()
                intent.putExtra("edit_name", user.name)
                setResult(Activity.RESULT_OK, intent)
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
