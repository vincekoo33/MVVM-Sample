package koo.vincent.myapplication.base

import android.support.v7.widget.RecyclerView
import android.view.View

interface BaseRecyclerViewItemClickListener<in VH : RecyclerView.ViewHolder> {

    /**
     * Delegate Viewholder click event to presenter
     *
     * @param viewHolder
     * @param position
     * @param view
     */
    fun onClick(viewHolder: VH, position: Int, view: View)

    /**
     * Delegate Viewholder long click event to presenter
     *
     * @param viewHolder
     * @param position
     * @param view
     */
    fun onLongClick(viewHolder: VH, position: Int, view: View)
}