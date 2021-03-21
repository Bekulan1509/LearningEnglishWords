package com.twodev.learningenglishwords.ui.ItemsActivity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.twodev.learningenglishwords.R
import com.twodev.models.ItemModel
import com.wajahatkarim3.easyflipview.EasyFlipView

class AdapterItems(
    private var listener: (View,Int) -> Unit,
    private var deletingItem: (ItemModel) -> Unit
) :
    RecyclerView.Adapter<AdapterItems.ViewHolderItem?>() {
    var list = mutableListOf<ItemModel?>()
    private var item: ItemModel? = null

    fun addItems(itemWordList: MutableList<ItemModel?>) {
        list = itemWordList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItem {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_item, parent, false)
        return ViewHolderItem(view)
    }

    override fun onBindViewHolder(holder: ViewHolderItem, position: Int) {
        holder.onBind(list[position])

            holder.itemWordTVFront.setOnLongClickListener {
                item = ItemModel(word1 = holder.word, word2 = holder.word2)
                val itemId = list[holder.adapterPosition]?.id
                item?.id = itemId
                deletingItem(item!!)
                return@setOnLongClickListener true
            }
        }


    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolderItem(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var word2: String
        lateinit var word: String
        val myEasyFlipView: EasyFlipView = itemView.findViewById(R.id.myEasyFlipView)
        var itemWordTVFront: TextView = itemView.findViewById(R.id.item_TV_main_front)
        var itemWordTVBack: TextView = itemView.findViewById(R.id.item_TV_main_back)
        fun onBind(s: ItemModel?) {
            itemWordTVFront.text = s?.word1.toString()
            itemWordTVBack.text = s?.word2.toString()
            word = s?.word1.toString()
            word2 = s?.word2.toString()
        }
    }


}








