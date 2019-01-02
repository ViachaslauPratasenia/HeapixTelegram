package by.heapix.proslau.heapixtelegram.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper constructor(context: Context?, name : String, factory: SQLiteDatabase.CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, name, factory, version) {

    val userTable = "users"
    val userId = "_id"
    val userPhone = "phone"
    val userNickname = "nickname"
    val userPassword = "password"

    val userTableCreate = "create table $userTable($userId integer primary key autoincrement, $userPhone text, " +
            "$userNickname text, $userPassword text);"

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    override fun onCreate(db: SQLiteDatabase?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        db?.execSQL(userTableCreate)
    }
}