package com.example.retoroom

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retoroom.database.User
import com.example.retoroom.databinding.ItemCardBinding
import org.json.JSONArray
import org.json.JSONObject

class MainAdapter(private val nombres: List<User>): RecyclerView.Adapter<MainAdapter.MainHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.render(nombres[position])
    }

    override fun getItemCount(): Int = nombres.size

    class MainHolder(val binding: ItemCardBinding): RecyclerView.ViewHolder(binding.root){
        fun render(nombre: User){
            binding.tvnombres.setText(nombre.user_name)
        }
    }

}