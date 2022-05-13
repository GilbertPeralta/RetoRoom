package com.example.retoroom.database

import android.content.Context
import androidx.room.Room

class DatabaseManager {
    lateinit var database: AppDataBase

    fun initializeDb(context: Context){
        createDb(context)
    }

    private fun createDb(context: Context){
        database = Room.databaseBuilder(context, AppDataBase::class.java, DATABASE_NAME).build()
    }

    companion object {
        val instance = DatabaseManager()
    }
}