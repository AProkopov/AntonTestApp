package com.medisafe.pillshapetest.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*

abstract class BaseAdapter<T, VH : RecyclerView.ViewHolder?> :
    RecyclerView.Adapter<VH>() {
    protected var mOnItemClickListener: OnItemClickListener<T>? = null

    protected var mItems: MutableList<T> = ArrayList()
    fun setList(items: List<T>?) {
        if (items != null) {
            mItems = ArrayList(items)
        } else {
            mItems = ArrayList()
        }
        notifyDataSetChanged()
    }

    fun addItemsToList(items: List<T>) {
        if (mItems.size == 0) {
            setList(items)
        } else {
            val currentItemsCount = mItems.size
            mItems.addAll(items)
            notifyItemRangeChanged(currentItemsCount - 1, items.size)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        val holder = onCreateViewHolder2(inflater, parent, viewType)
        holder!!.itemView.setOnClickListener { v: View? ->
            if (mOnItemClickListener != null) {
                val position = holder.adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    if (position <= mItems.lastIndex) {
                        mOnItemClickListener?.onItemClick(
                            getItemAtPosition(position),
                            holder.adapterPosition
                        )
                    }
                } else {
                    //do stuff for error case
                }
            }
        }
        return holder
    }

    protected abstract fun onCreateViewHolder2(
        inflater: LayoutInflater?,
        parent: ViewGroup?,
        viewType: Int
    ): VH

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener<T>?) {
        mOnItemClickListener = onItemClickListener
    }

    fun getItemAtPosition(position: Int): T {
        return mItems[position]
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }
}