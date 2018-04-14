package koo.vincent.myapplication.base

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseRecyclerViewHolder<in T, in VH : RecyclerView.ViewHolder, A : BaseRecyclerViewItemClickListener<VH>>
(private val adapter: A, itemView: View) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener, View.OnLongClickListener {

    init {
        itemView.setOnClickListener(this)
        itemView.setOnLongClickListener(this)
    }

    @Suppress("UNCHECKED_CAST")
    override fun onClick(view: View?) {
        (this as? VH).let {
            adapter.onClick(it!!, adapterPosition, view!!)
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun onLongClick(view: View?): Boolean {
        (this as? VH).let {
            adapter.onLongClick(it!!, adapterPosition, view!!)
        }
        return true
    }

    abstract fun onBind(model: T)
}