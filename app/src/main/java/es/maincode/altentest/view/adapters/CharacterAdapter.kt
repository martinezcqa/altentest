package es.maincode.altentest.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import es.maincode.altentest.R
import es.maincode.altentest.databinding.ItemDetailInfoBinding

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.ItemViewHolder>() {

    private var data: MutableList<Pair<String, String>> = mutableListOf()

    fun updateData(newData: List<Pair<String, String>>) {
        newData.forEach { item ->
            data.add(item)
            notifyItemInserted(data.indexOf(item))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemDetailInfoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemView.animation = AnimationUtils.loadAnimation(
            holder.itemView.context, R.anim.recycler_anim
        )
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class ItemViewHolder(private val binding: ItemDetailInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pair: Pair<String, String>) {
            with(binding) {
                tvTitle.text = pair.first
                tvSubtitle.text = pair.second
            }
        }
    }
}