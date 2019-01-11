package by.heapix.proslau.heapixtelegram.model.contact

data class Contact (val id : Long, val nickname : String, val avatar : String, val phone : String) {
    companion object {
        var counter : Long = 1
    }
}

