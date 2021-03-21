package com.twodev.learningenglishwords.ui.ItemsActivity.adapter

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager

class NoScrollLinearLayoutManager(context: Context?) : LinearLayoutManager(context) {
    private var scrollable = true

    fun enableScrolling() {
        scrollable = true
    }

    fun disableScrolling() {
        scrollable = false
    }

    override fun canScrollVertically() =
        super.canScrollVertically() && scrollable


    override fun canScrollHorizontally() =
        super.canScrollVertically()
                && scrollable
}