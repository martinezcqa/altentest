package es.maincode.altentest.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import coil.load
import es.maincode.altentest.R
import es.maincode.altentest.databinding.ItemCharacterBinding
import es.maincode.altentest.view.vo.CharacterVO

class CharactersAdapter(
    private val onClickItem: (Int) -> Unit
) : RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>() {

    private var data: MutableList<CharacterVO> = mutableListOf()

    fun updateData(newData: List<CharacterVO>) {
        newData.forEach { character ->
            data.add(character)
            notifyItemInserted(data.indexOf(character))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.itemView.animation = AnimationUtils.loadAnimation(
            holder.itemView.context, R.anim.recycler_anim
        )
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: CharacterVO) {
            with(binding) {
                root.setOnClickListener {
                    onClickItem(character.id)
                }
                tvTitle.text = character.name
                ivImage.load(character.image) {
                    listener(
                        onStart = {
                            pbProgress.visibility = View.VISIBLE
                        },
                        onSuccess = { _, _ ->
                            pbProgress.visibility = View.GONE
                        }
                    )
                }
            }
        }
    }
}