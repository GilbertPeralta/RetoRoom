package com.example.retoroom.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

class MyCoroutines(private val userDao: UserDao) {
    suspend fun save(user: User) = withContext(Dispatchers.IO){
        userDao.save(user.toEntity())
    }

    suspend fun delete(user: User) = withContext(Dispatchers.IO){
        userDao.delete(user.toEntity())
    }

    suspend fun getUsers(): LiveData<List<User>> = withContext(Dispatchers.IO){
        return@withContext MutableLiveData(userDao.getUsersFromDataBase().map { it.toUser() })
    }
    suspend fun getUser(uuid: UUID) = withContext(Dispatchers.IO){
        userDao.getUserByUuid(uuid.toString())
    }
}