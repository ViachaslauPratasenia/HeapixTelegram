package by.heapix.proslau.heapixtelegram.model.message

import by.heapix.proslau.heapixtelegram.model.user.User

data class Message (val user : User, val text : String, val time :  Long) {
}