package koo.vincent.myapplication.ui.main

import android.view.View
import android.widget.TextView
import koo.vincent.myapplication.R
import koo.vincent.myapplication.base.BaseRecyclerViewHolder
import koo.vincent.myapplication.models.User

class MainViewHolder(adapter: MainAdapter, itemView: View) : BaseRecyclerViewHolder<User, MainViewHolder, MainAdapter>(adapter,itemView) {
    override fun onBind(model: User) {
        itemView.findViewById<TextView>(R.id.name).text = model.name
    }
}