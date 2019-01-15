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
import by.heapix.proslau.heapixtelegram.controller.adapters.ChatListRecyclerViewAdapter
import by.heapix.proslau.heapixtelegram.model.ChatListItem
import by.heapix.proslau.heapixtelegram.model.ChatListItem.Companion.initChatList


class ChatFragment : Fragment(), SearchView.OnQueryTextListener {

    internal lateinit var view: View
    lateinit var adapter: ChatListRecyclerViewAdapter
    var chatList : ArrayList<ChatListItem> = ArrayList()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        view = inflater.inflate(R.layout.chat_list_fragment, container, false)

        initImageBitmaps()

        val toolbar = view.findViewById<View>(R.id.chat_toolbar) as Toolbar
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.inflateMenu(R.menu.menu_toolbar)
        toolbar.title = "Chat"
        val menuItem = toolbar.menu!!.findItem(R.id.action_search)
        val searchView : android.support.v7.widget.SearchView = menuItem.actionView as android.support.v7.widget.SearchView
        searchView.setOnQueryTextListener(this)
        searchView.queryHint = "Search"

        return view
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        val userInput = p0!!.toLowerCase()
        val newList = ArrayList<ChatListItem>()
        chatList.forEach {
            if(it.name.toLowerCase().contains(userInput) || it.lastMessage.toLowerCase().contains(userInput)){
                newList.add(it)
            }
        }
        adapter.updateList(newList)
        return true
    }

    private fun initImageBitmaps() {
        chatList = initChatList()
        initChatListRecyclerView()
    }

    private fun initChatListRecyclerView() {
        adapter = ChatListRecyclerViewAdapter(chatList, context)
        val recyclerView = view.findViewById<RecyclerView>(R.id.chat_list_recycler_view)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }
}
