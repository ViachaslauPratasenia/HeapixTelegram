package by.heapix.proslau.heapixtelegram.view.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.view.*
import by.heapix.proslau.heapixtelegram.R
import by.heapix.proslau.heapixtelegram.controller.adapters.ContactRecyclerViewAdapter
import by.heapix.proslau.heapixtelegram.model.contact.Contact
import by.heapix.proslau.heapixtelegram.model.contact.Contact.Companion.initContact

import kotlin.collections.ArrayList

class ContactFragment : Fragment(), SearchView.OnQueryTextListener{

    internal lateinit var view: View
    lateinit var adapter : ContactRecyclerViewAdapter
    var contacts : ArrayList<Contact> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        view = inflater.inflate(R.layout.contact_fragment, container, false)

        val toolbar = view.findViewById<View>(R.id.contact_toolbar) as Toolbar
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.inflateMenu(R.menu.menu_toolbar)
        toolbar.title = "Contacts"
        val menuItem = toolbar.menu!!.findItem(R.id.action_search)
        val searchView : android.support.v7.widget.SearchView = menuItem.actionView as android.support.v7.widget.SearchView
        searchView.setOnQueryTextListener(this)
        searchView.queryHint = "Search"
        initImageBitmaps()


        return view
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.menu_toolbar, menu)
        val menuItem = menu!!.findItem(R.id.action_search)
        val searchView : android.support.v7.widget.SearchView = menuItem.actionView as android.support.v7.widget.SearchView
        searchView.setOnQueryTextListener(this)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        val userInput = newText!!.toLowerCase()
        val newList = ArrayList<Contact>()
        contacts.forEach {
            if(it.nickname.toLowerCase().contains(userInput)){
                newList.add(it)
            }
        }
        adapter.updateList(newList)
        return true
    }

    private fun initImageBitmaps() {
        contacts = initContact()
        initContactRecyclerView()
    }

    private fun initContactRecyclerView() {
        adapter = ContactRecyclerViewAdapter(contacts, context)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycle_view)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }
}
