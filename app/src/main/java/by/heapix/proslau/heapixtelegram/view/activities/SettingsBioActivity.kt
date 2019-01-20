package by.heapix.proslau.heapixtelegram.view.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import by.heapix.proslau.heapixtelegram.R
import by.heapix.proslau.heapixtelegram.model.user.User
import by.heapix.proslau.heapixtelegram.model.user.UserRepository

class SettingsBioActivity : AppCompatActivity() {

    lateinit var user : User
    lateinit var bioET : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_bio)

        val toolbar = findViewById<View>(R.id.settings_bio_toolbar) as Toolbar
        toolbar.title = "Bio"
        setSupportActionBar(toolbar)
        val actionBar : ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowHomeEnabled(true)

        val username = intent.getStringExtra("username") as String
        user = UserRepository(this).findUser(username)

        bioET = findViewById<View>(R.id.settings_bio_et) as EditText
        bioET.setText(user.bio)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_settings_confirm, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.action_confirm -> {
                Toast.makeText(this, "Confirm data", Toast.LENGTH_SHORT).show()
                user.bio = bioET.text.toString()
                UserRepository(this).update(user)
                val intent = Intent()
                intent.putExtra("bio", user.bio)
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