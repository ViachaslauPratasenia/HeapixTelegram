package by.heapix.proslau.heapixtelegram.model.user



data class User(val id: Long, var phone: String, var username: String,
                var name: String, var bio: String, val password: String) {
    companion object {
        var counter : Long = 1
    }
}