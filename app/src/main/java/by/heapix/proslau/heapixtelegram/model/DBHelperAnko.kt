package by.heapix.proslau.heapixtelegram.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import by.heapix.proslau.heapixtelegram.model.contact.Contact
import by.heapix.proslau.heapixtelegram.model.contact.ContactRepository
import org.jetbrains.anko.db.*

class DBHelperAnko (context: Context) : ManagedSQLiteOpenHelper(context, "2", null, 1) {

    companion object {
        private var instance: DBHelperAnko? = null

        @Synchronized
        fun getInstance(context: Context): DBHelperAnko {
            if (instance == null){
                instance = DBHelperAnko(context.applicationContext)
            }

            return instance!!
        }
    }

    override fun onCreate(database: SQLiteDatabase) {

        database.createTable("users", true,
            "id" to INTEGER + PRIMARY_KEY + UNIQUE,
            "phone" to TEXT + NOT_NULL,
            "nickname" to TEXT + NOT_NULL,
            "password" to TEXT)

        database.createTable("contacts", true,
            "id" to INTEGER + PRIMARY_KEY + UNIQUE,
            "nickname" to TEXT + NOT_NULL,
            "avatar" to TEXT,
            "phone" to TEXT + NOT_NULL)

    }

    override fun onUpgrade(database: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        database.dropTable("users", ifExists = true)

    }
}

val Context.database: DBHelperAnko
    get() = DBHelperAnko.getInstance(getApplicationContext())