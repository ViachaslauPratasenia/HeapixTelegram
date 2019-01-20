package by.heapix.proslau.heapixtelegram.view.fragments

import android.app.Activity.RESULT_OK
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.*
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import by.heapix.proslau.heapixtelegram.R
import by.heapix.proslau.heapixtelegram.model.user.UserRepository
import by.heapix.proslau.heapixtelegram.view.activities.*
import kotlinx.android.synthetic.main.content_settings_fragment.*
import kotlinx.android.synthetic.main.settings_fragment.*
import org.w3c.dom.Text

import java.util.Objects

class SettingFragment : Fragment(), View.OnClickListener {

    private val EDIT_NAME_RESULT = 1
    private val PHONE_RESULT = 2
    private val USERNAME_RESULT = 3
    private val BIO_RESULT = 4

    private var cameraDialog: Dialog? = null

    lateinit var phoneIntent: Intent
    lateinit var usernameIntent : Intent
    lateinit var editNameIntent : Intent
    lateinit var bioIntent : Intent

    lateinit var title : TextView
    lateinit var username : TextView
    lateinit var phone : TextView
    lateinit var bio : TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        setMenuVisibility(true)
        val view = inflater.inflate(R.layout.settings_fragment, container, false)

        val toolbar = view.findViewById<View>(R.id.toolbar) as Toolbar
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        cameraDialog = Dialog(context!!)
        cameraDialog!!.setContentView(R.layout.choise_camera_dialog)
        cameraDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val actionBar = (activity as AppCompatActivity).supportActionBar
        val args = arguments
        actionBar!!.title = ""

        val usernameArgs = args!!.getString("nick")

        phoneIntent = Intent(context, SettingsPhoneActivity::class.java)
        editNameIntent = Intent(context, SettingsEditNameActivity::class.java)
        usernameIntent = Intent(context, SettingsUsernameActivity::class.java)
        bioIntent = Intent(context, SettingsBioActivity::class.java)

        phoneIntent.putExtra("username", usernameArgs)
        usernameIntent.putExtra("username", usernameArgs)
        editNameIntent.putExtra("username", usernameArgs)
        bioIntent.putExtra("username", usernameArgs)

        val user = UserRepository(view.context).findUser(usernameArgs)

        title = view.findViewById<View>(R.id.cat_title) as TextView
        title.text = user.name
        val subtitle = view.findViewById<View>(R.id.cat_subtitle) as TextView
        subtitle.text = "Online"

        username = view.findViewById<View>(R.id.settings_username_title) as TextView
        username.text = user.username

        phone = view.findViewById<View>(R.id.settings_phone_number_title) as TextView
        phone.text = user.phone

        bio = view.findViewById<View>(R.id.settings_bio_title) as TextView
        bio.text = user.bio

        val fab = view.findViewById<View>(R.id.fab)
        fab.setOnClickListener(this)

        val phoneNumberLayout = view.findViewById<View>(R.id.settings_phone_number_layout)
        phoneNumberLayout.setOnClickListener(this)

        val usernameLayout = view.findViewById<View>(R.id.settings_username_layout)
        usernameLayout.setOnClickListener(this)

        val bioLayout = view.findViewById<View>(R.id.settings_bio_layout)
        bioLayout.setOnClickListener(this)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.menu_settings, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.action_edit_name -> {
                startActivityForResult(editNameIntent, 1)
            }
            R.id.action_logout -> {
                activity!!.finish()
                val intent = Intent(context, LoginActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.fab -> {
                Toast.makeText(context, "Floating button (settings)", Toast.LENGTH_SHORT).show()
                try {
                    cameraDialog!!.show()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            R.id.settings_phone_number_layout -> {
                startActivityForResult(phoneIntent, 2)
            }
            R.id.settings_username_layout -> {
                startActivityForResult(usernameIntent, 3)
            }
            R.id.settings_bio_layout -> {
                startActivityForResult(bioIntent, 4)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            EDIT_NAME_RESULT -> {
                if(resultCode == RESULT_OK){
                    val editName = data!!.getStringExtra("edit_name")
                    title.text = editName
                }
            }
            PHONE_RESULT -> {
                if(resultCode == RESULT_OK){
                    val phoneIntentData = data!!.getStringExtra("phone")
                    phone.text = phoneIntentData
                }
            }
            USERNAME_RESULT -> {
                if(resultCode == RESULT_OK){
                    val usernameIntentData = data!!.getStringExtra("username")
                    username.text = usernameIntentData
                }
            }
            BIO_RESULT -> {
                if(resultCode == RESULT_OK){
                    val bioIntentData = data!!.getStringExtra("bio")
                    bio.text = bioIntentData
                }
            }
        }

    }
}