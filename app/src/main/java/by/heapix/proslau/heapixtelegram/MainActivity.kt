package by.heapix.proslau.heapixtelegram

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import by.heapix.proslau.heapixtelegram.view.fragments.ChatFragment
import by.heapix.proslau.heapixtelegram.view.fragments.ContactFragment
import by.heapix.proslau.heapixtelegram.view.fragments.MapFragment
import by.heapix.proslau.heapixtelegram.view.fragments.TempSettingFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var nickname : String
    val chatFragment = ChatFragment()
    val contactFragment = ContactFragment()
    val mapFragment = MapFragment()
    val settingsFragment = TempSettingFragment()
    val fragmentManager : FragmentManager = supportFragmentManager
    var activeFragment : Fragment = mapFragment

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_map -> {
                fragmentManager.beginTransaction().hide(activeFragment).show(mapFragment).commit()
                activeFragment = mapFragment
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_groups -> {
                fragmentManager.beginTransaction().hide(activeFragment).show(contactFragment).commit()
                activeFragment = contactFragment
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_chat -> {
                fragmentManager.beginTransaction().hide(activeFragment).show(chatFragment).commit()
                activeFragment = chatFragment
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_settings -> {
                fragmentManager.beginTransaction().hide(activeFragment).show(settingsFragment).commit()
                activeFragment = settingsFragment
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        nickname = intent.getStringExtra("nickname")
        val args = Bundle()
        args.putString("nick", nickname)
        settingsFragment.arguments = args


        fragmentManager.beginTransaction().add(R.id.main_container, mapFragment).commit()
        fragmentManager.beginTransaction().add(R.id.main_container, chatFragment).hide(chatFragment).commit()
        fragmentManager.beginTransaction().add(R.id.main_container, contactFragment).hide(contactFragment).commit()
        fragmentManager.beginTransaction().add(R.id.main_container, settingsFragment).hide(settingsFragment).commit()
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
