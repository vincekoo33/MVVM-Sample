package koo.vincent.myapplication.base

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView


abstract class BaseRecyclerViewAdapter<T, VH : RecyclerView.ViewHolder, out VM : BaseViewModel>
(val viewModel: VM, diffCallback: DiffUtil.ItemCallback<T>)
    : ListAdapter<T, VH>(diffCallback), BaseRecyclerViewItemClickListener<VH>