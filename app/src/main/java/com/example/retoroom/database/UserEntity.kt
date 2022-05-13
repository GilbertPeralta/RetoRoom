package com.example.retoroom.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TABLE_USERS)
data class UserEntity(
    @ColumnInfo(name = "user_id") @PrimaryKey(autoGenerate = true) val uuid: Int = 0,
    @ColumnInfo(name = "user_name") val name: String,
)

fun UserEntity.toUser() = User(
    uuid,
    name,
)