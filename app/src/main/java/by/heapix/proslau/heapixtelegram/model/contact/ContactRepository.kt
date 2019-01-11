package by.heapix.proslau.heapixtelegram.model.contact

import android.content.Context
import by.heapix.proslau.heapixtelegram.model.database
import by.heapix.proslau.heapixtelegram.model.user.User
import org.jetbrains.anko.db.*

class ContactRepository (val context: Context) {

    fun findAll() : ArrayList<Contact> = context.database.use {
        val notes = ArrayList<Contact>()

        select("contacts", "id", "nickname", "avatar", "phone")
            .parseList(object: MapRowParser<List<Contact>> {
                override fun parseRow(columns: Map<String, Any?>): List<Contact> {
                    val id = columns.getValue("id")
                    val nickname = columns.getValue("nickname")
                    val avatar = columns.getValue("avatar")
                    val phone = columns.getValue("phone")

                    val note = Contact(id.toString().toLong(), nickname.toString(), avatar.toString(), phone.toString())
                    notes.add(note)

                    return notes
                }
            })
        notes
    }

    fun create(contact: Contact) = context.database.use {
        insert("contacts",
            "nickname" to contact.nickname,
            "avatar" to contact.avatar,
            "phone" to contact.phone)
    }

    fun update(contact: Contact) = context.database.use {
        val updateResult = update("contacts",
            "nickname" to contact.nickname,
            "avatar" to contact.avatar,
            "phone" to contact.phone)
            .whereArgs("id = {contactId}", "contactId" to contact.id)
            .exec()

    }

    fun delete(contact: Contact) = context.database.use{
        delete("contacts", whereClause = "id = {contactId}", args = *arrayOf("contactId" to contact.id))
    }
}



