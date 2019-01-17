package by.heapix.proslau.heapixtelegram.view.fragments

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.*
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import by.heapix.proslau.heapixtelegram.R
import kotlinx.android.synthetic.main.content_settings_fragment.*
import kotlinx.android.synthetic.main.settings_fragment.*

import java.util.Objects

class SettingFragment : Fragment(), View.OnClickListener {

    private var cameraDialog: Dialog? = null

    internal var btnFromCamera: Button? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.settings_fragment, container, false)

        val toolbar = view.findViewById<View>(R.id.toolbar) as Toolbar
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        cameraDialog = Dialog(context!!)
        cameraDialog!!.setContentView(R.layout.choise_camera_dialog)
        cameraDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val actionBar = (activity as AppCompatActivity).supportActionBar
        val args = arguments
        actionBar!!.title = ""
        val title = view.findViewById<View>(R.id.cat_title) as TextView
        title.text = args!!.getString("nick")
        val subtitle = view.findViewById<View>(R.id.cat_subtitle) as TextView
        subtitle.text = "Online"

        val phoneNumberLayout = view.findViewById<View>(R.id.settings_phone_number_layout)
        phoneNumberLayout.setOnClickListener {
            Toast.makeText(view.context, "phone number layout", Toast.LENGTH_LONG).show()
        }

        val usernameLayout = view.findViewById<View>(R.id.settings_username_layout)
        usernameLayout.setOnClickListener {
            Toast.makeText(view.context, "username layout", Toast.LENGTH_LONG).show()
        }

        val bioLayout = view.findViewById<View>(R.id.settings_bio_layout)
        bioLayout.setOnClickListener {
            Toast.makeText(view.context, "bio layout", Toast.LENGTH_LONG).show()
        }

        val fab = view.findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener(this)

        return view
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
        }
    }
}