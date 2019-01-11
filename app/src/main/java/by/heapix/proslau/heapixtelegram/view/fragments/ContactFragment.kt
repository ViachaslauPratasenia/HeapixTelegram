package by.heapix.proslau.heapixtelegram.view.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.*
import by.heapix.proslau.heapixtelegram.R
import by.heapix.proslau.heapixtelegram.controller.adapters.ContactRecyclerViewAdapter
import by.heapix.proslau.heapixtelegram.model.contact.Contact
import by.heapix.proslau.heapixtelegram.model.contact.ContactRepository

import java.util.ArrayList

class ContactFragment : Fragment() {

    internal lateinit var view: View
    private val contactNames = ArrayList<String>()
    private val contactImageUrls = ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        view = inflater.inflate(R.layout.contact_fragment, container, false)

        val toolbar = view.findViewById<View>(R.id.group_toolbar) as Toolbar
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        initImageBitmaps()


        return view
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.menu_toolbar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun initImageBitmaps() {
        val contacts = initContact()
        contacts.forEach {
            contactNames.add(it.nickname)
            contactImageUrls.add(it.avatar)
        }
        initContactRecyclerView()
    }

    private fun initContactRecyclerView() {
        val adapter = ContactRecyclerViewAdapter(contactNames, contactImageUrls, context)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycle_view)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    fun initContact() : ArrayList<Contact> {
        val arrayList : ArrayList<Contact> = ArrayList()

        arrayList.add(Contact(Contact.counter++,
            nickname = "Antione Griezmann",
            avatar = "https://cdn.calciomercato.com/images/2016-09/griezmann.atletico.2016.17.riscaldamento.356x237.jpg",
            phone = "88005553535"))

        arrayList.add(Contact(Contact.counter++,
            nickname = "Zinedin Zidane",
            avatar = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Zinedine_Zidane_by_Tasnim_03.jpg/232px-Zinedine_Zidane_by_Tasnim_03.jpg",
            phone = "88005553535"))

        arrayList.add(Contact(Contact.counter++,
            nickname = "Kylian Mbappe",
            avatar = "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e5/Kylian_Mbapp%C3%A9_2018.jpg/200px-Kylian_Mbapp%C3%A9_2018.jpg",
            phone = "88005553535"))

        arrayList.add(Contact(Contact.counter++,
            nickname = "Yan Oblak",
            avatar = "https://cdn.images.express.co.uk/img/dynamic/67/590x/Oblak-Liverpool-gossip-970548.jpg?r=1534512901646.jpg",
            phone = "88005553535"))

        arrayList.add(Contact(Contact.counter++,
            nickname = "Diego Costa",
            avatar = "https://s.hs-data.com/bilder/spieler/gross/73586.jpg",
            phone = "88005553535"))

        arrayList.add(Contact(Contact.counter++,
            nickname = "Diego Godin",
            avatar = "https://s.hs-data.com/bilder/spieler/gross/44642.jpg",
            phone = "88005553535"))

        arrayList.add(Contact(Contact.counter++,
            nickname = "Thomas Partey",
            avatar = "http://www1.pictures.zimbio.com/gi/Thomas+Partey+Atletico+Madrid+v+Villarreal+IisQiD_0v30l.jpg",
            phone = "88005553535"))

        arrayList.add(Contact(Contact.counter++,
            nickname = "Thomas Lemar",
            avatar = "https://s.hs-data.com/bilder/spieler/gross/210876.jpg",
            phone = "88005553535"))

        arrayList.add(Contact(Contact.counter++,
            nickname = "Angel Correa",
            avatar = "https://cdn.images.express.co.uk/img/dynamic/67/590x/Angel-Correa-827268.jpg",
            phone = "88005553535"))

        return arrayList
    }
}
