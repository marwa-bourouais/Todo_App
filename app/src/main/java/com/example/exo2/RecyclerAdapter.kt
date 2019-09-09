package com.example.exo2

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class RecyclerAdapter(val context: Context) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    var todoList : List<Todo> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_adapter,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.title.text = todoList.get(position).title
        holder.id.text = todoList.get(position).id
        holder.user_id.text = todoList.get(position).userId
        holder.state.text = todoList.get(position).completed.toString()

    }

    fun setTodosItems(todoList: List<Todo>){
        this.todoList = todoList;
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        val title: TextView = itemView!!.findViewById(R.id.title)
        val id: TextView = itemView!!.findViewById(R.id.id)
        val user_id: TextView = itemView!!.findViewById(R.id.userid)
        val state: TextView = itemView!!.findViewById(R.id.state)


    }
}