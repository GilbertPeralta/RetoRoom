package com.example.retoroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.retoroom.database.User
import com.example.retoroom.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGuardar.setOnClickListener{
            mainViewModel.saveUser(
                User(
                    0,
                    user_name = binding.etNombresDB.text.toString()
                )
            )
            mainViewModel.getUsers()
            mainViewModel.savedUsers.observe(this) {usersList ->
                if(!usersList.isNullOrEmpty()){
                    for(user in usersList){
                        Log.d("thesearetheusers", user.user_name)
                        //val Jsonarr = JSONArray(user.user_name)
                        binding.rvNombresEntries.adapter = MainAdapter(usersList)
                    }
                }else{
                    Log.d("thesearetheusers", "null or empty")
                }
            }
        }
    }
}