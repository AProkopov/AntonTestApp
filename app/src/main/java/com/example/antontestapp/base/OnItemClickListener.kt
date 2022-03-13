package com.medisafe.pillshapetest.base

interface OnItemClickListener<T> {
    fun onItemClick(data: T, position: Int)
}