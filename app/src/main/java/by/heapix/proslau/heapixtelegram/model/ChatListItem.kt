package by.heapix.proslau.heapixtelegram.model

data class ChatListItem(val id : Long, val name : String, val image : String, val lastMessage : String, val date : String) {
    companion object {
        var counter : Long = 1
        fun initChatList() : ArrayList<ChatListItem> {
            val arrayList : ArrayList<ChatListItem> = ArrayList()

            arrayList.add(
                ChatListItem(ChatListItem.counter++,
                    name = "Kotlin Belarus User Group",
                    image = "https://bkug.by/wp-content/uploads/2017/06/logo_white.png",
                    lastMessage = "Anons", date = "Wen")
            )

            arrayList.add(
                ChatListItem(ChatListItem.counter++,
                    name = "Zinedin Zidane",
                    image = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Zinedine_Zidane_by_Tasnim_03.jpg/232px-Zinedine_Zidane_by_Tasnim_03.jpg",
                    lastMessage = "Test message",date = "Mon")
            )
            return arrayList
        }
    }
}