package com.example.retoroom.database

import androidx.room.Database
import androidx.room.RoomDatabase


const val DATABASE_VERSION = 1
const val TABLE_USERS = "users"
const val DATABASE_NAME = "appdatabase.sqlite"

@Database(entities = [UserEntity::class],
    version = DATABASE_VERSION
)
abstract class AppDataBase: RoomDatabase() {
    abstract fun userDao(): UserDao
}