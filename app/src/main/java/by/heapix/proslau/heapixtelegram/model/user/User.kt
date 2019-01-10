package by.heapix.proslau.heapixtelegram.model.user



data class User(val id: Long, val phone: String, val nickname: String, val password: String) {
    companion object {
        var counter : Long = 1
    }
}