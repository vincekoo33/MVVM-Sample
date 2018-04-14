package koo.vincent.myapplication.ui.main

import android.support.v7.util.DiffUtil
import android.view.View
import android.view.ViewGroup
import koo.vincent.myapplication.R
import koo.vincent.myapplication.base.BaseRecyclerViewAdapter
import koo.vincent.myapplication.models.User


class MainAdapter(private var mutableList: MutableList<User>, viewModel: MainViewModel, diffCallback: DiffUtil.ItemCallback<User>)
    : BaseRecyclerViewAdapter<User, MainViewHolder, MainViewModel>(viewModel, diffCallback) {

    class DiffCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User?, newItem: User?): Boolean {
            return oldItem?.name == newItem?.name
        }

        override fun areContentsTheSame(oldItem: User?, newItem: User?): Boolean {
            return oldItem?.equals(newItem) ?: false
        }
    }

    override fun onClick(viewHolder: MainViewHolder, position: Int, view: View) {
        //deal with click event
        viewModel.pushOnClickToast(mutableList[position].name)
    }

    override fun onLongClick(viewHolder: MainViewHolder, position: Int, view: View) {
        //deal with long click event
        viewModel.pushOnLongClickToast(mutableList[position].name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(this, View.inflate(parent.context, R.layout.user_layout, null))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.onBind(mutableList[position])
    }

    override fun getItemCount(): Int {
        return mutableList.size
    }
}