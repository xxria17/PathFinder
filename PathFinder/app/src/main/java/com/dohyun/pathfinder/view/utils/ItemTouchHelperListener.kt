package com.dohyun.pathfinder.view.utils

interface ItemTouchHelperListener {
    fun onItemMove(fromPos:Int, targetPos:Int)
    fun onItemDismiss(pos:Int)
}