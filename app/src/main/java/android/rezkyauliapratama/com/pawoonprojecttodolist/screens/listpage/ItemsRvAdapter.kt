package android.rezkyauliapratama.com.pawoonprojecttodolist.screens.listpage

import android.rezkyauliapratama.com.pawoonprojecttodolist.R
import android.rezkyauliapratama.com.pawoonprojecttodolist.data.database.entity.TodoSchema
import android.rezkyauliapratama.com.pawoonprojecttodolist.databinding.ListItemTodolistBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class ItemsRvAdapter() : RecyclerView.Adapter<ItemsRvAdapter.ViewHolder>() {
    private val mItems: MutableList<TodoSchema> = mutableListOf()

    fun bindItems(listItem: List<TodoSchema>) {
        mItems.clear()
        if (!listItem.isEmpty()){
            mItems.addAll(listItem)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_todolist, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = mItems.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(mItems[position])
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private var binding: ListItemTodolistBinding = ListItemTodolistBinding.bind(itemView)

        fun bindItem(item: TodoSchema){

            //ItemSchema information
            binding.tvTitle.text = item.title
            binding.ivCheck.visibility = if(item.completed == 1) View.VISIBLE else View.GONE
        }
    }


}