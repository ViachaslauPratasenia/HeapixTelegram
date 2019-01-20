package by.heapix.proslau.heapixtelegram.model.user

import android.content.Context
import by.heapix.proslau.heapixtelegram.model.database
import org.jetbrains.anko.db.*

class UserRepository(val context: Context) {
    fun findAll() : ArrayList<User> = context.database.use {
        val notes = ArrayList<User>()

        select("users", "id", "phone", "username", "name", "bio", "password")
            .parseList(object: MapRowParser<List<User>> {
                override fun parseRow(columns: Map<String, Any?>): List<User> {
                    val id = columns.getValue("id")
                    val phone = columns.getValue("phone")
                    val nickname = columns.getValue("username")
                    val name = columns.getValue("name")
                    val bio = columns.getValue("bio")
                    val password = columns.getValue("password")

                    val note = User(id.toString().toLong(), phone.toString(), nickname.toString(),
                        name.toString(), bio.toString(), password.toString())
                    notes.add(note)

                    return notes
                }
            })
        notes
    }

    fun isUserValid(userNickname : String, userPassword : String) : Boolean {
        val users = findAll()
        return !users.filter { it.username == userNickname && it.password == userPassword}.isEmpty()
    }

    fun findUser(username: String) : User{
        return findAll().filter {
            it.username == username
        }.first()
    }

    fun create(user: User) = context.database.use {
        insert("users",
            "phone" to user.phone,
            "username" to user.username,
            "name" to user.name,
            "bio" to user.bio,
            "password" to user.password)
    }

    fun update(user: User) = context.database.use {
        val updateResult = update("users",
            "phone" to user.phone,
            "username" to user.username,
            "name" to user.name,
            "bio" to user.bio,
            "password" to user.password)
            .whereArgs("id = {userId}", "userId" to user.id)
            .exec()

    }

    fun delete(user: User) = context.database.use{
        delete("users", whereClause = "id = {userId}", args = *arrayOf("userId" to user.id))
    }
}