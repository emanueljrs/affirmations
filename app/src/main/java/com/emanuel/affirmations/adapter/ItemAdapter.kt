package com.emanuel.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emanuel.affirmations.databinding.ListItemBinding
import com.emanuel.affirmations.model.Affirmation

class ItemAdapter(
    private val context: Context,
    private val dataset: List<Affirmation>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.bind(
            strRes = context.getString(item.stringResId),
            imgRes = item.imageResId
        )
    }

    override fun getItemCount(): Int = dataset.size

    class ItemViewHolder(viewBinding: ListItemBinding) : RecyclerView.ViewHolder(viewBinding.root) {
        private val textView = viewBinding.itemTitle
        private val imageView = viewBinding.itemImage

        fun bind(strRes: String, imgRes: Int) {
            textView.text = strRes
            imageView.setImageResource(imgRes)
        }
    }
}