package by.heapix.proslau.heapixtelegram.model.contact

import java.util.ArrayList

data class Contact (val id : Long, val nickname : String, val avatar : String, val phone : String) {
    companion object {
        var counter : Long = 1
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
                avatar = "https://www.fifaindex.com/static/FIFA19/images/players/180/209989.png",
                phone = "88005553535"))

            arrayList.add(Contact(Contact.counter++,
                nickname = "Thomas Lemar",
                avatar = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/38/Thomas_Lemar.jpg/200px-Thomas_Lemar.jpg",
                phone = "88005553535"))

            arrayList.add(Contact(Contact.counter++,
                nickname = "Angel Correa",
                avatar = "https://cdn.images.express.co.uk/img/dynamic/67/590x/Angel-Correa-827268.jpg",
                phone = "88005553535"))

            return arrayList
        }
    }
}

