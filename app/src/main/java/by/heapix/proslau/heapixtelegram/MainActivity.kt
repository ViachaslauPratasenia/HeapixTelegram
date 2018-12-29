package by.heapix.proslau.heapixtelegram

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.ContextMenu
import android.view.Menu
import android.view.View
import by.heapix.proslau.heapixtelegram.View.fragments.ChatFragment
import by.heapix.proslau.heapixtelegram.View.fragments.GroupFragment
import by.heapix.proslau.heapixtelegram.View.fragments.MapFragment
import by.heapix.proslau.heapixtelegram.View.fragments.TempSettingFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.chat_fragment.*

class MainActivity : AppCompatActivity() {

    val chatFragment = ChatFragment()
    val groupFragment = GroupFragment()
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
                fragmentManager.beginTransaction().hide(activeFragment).show(groupFragment).commit()
                activeFragment = groupFragment
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

        setSupportActionBar(toolbar)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        fragmentManager.beginTransaction().add(R.id.main_container, mapFragment).commit()
        fragmentManager.beginTransaction().add(R.id.main_container, chatFragment).hide(chatFragment).commit()
        fragmentManager.beginTransaction().add(R.id.main_container, groupFragment).hide(groupFragment).commit()
        fragmentManager.beginTransaction().add(R.id.main_container, settingsFragment).hide(settingsFragment).commit()
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
