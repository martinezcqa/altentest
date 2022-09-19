package es.maincode.altentest.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import es.maincode.altentest.R
import es.maincode.altentest.base.BaseFragment
import es.maincode.altentest.databinding.FragmentListBinding
import es.maincode.altentest.view.adapters.CharactersAdapter
import es.maincode.altentest.view.viewModels.ListViewModel

@AndroidEntryPoint
class ListFragment : BaseFragment(R.layout.fragment_list) {

    private val viewModel: ListViewModel by viewModels()
    private var binding: FragmentListBinding? = null
    private var adapter: CharactersAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        collectFlows()
        viewModel.getList()
    }

    private fun initRecycler() {
        binding?.let {
            with(it) {
                adapter = CharactersAdapter(::onClickItem)
                rvCharacters.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                rvCharacters.adapter = adapter
            }
        }
    }

    private fun collectFlows() {
        lifecycleScope.launchWhenStarted {
            viewModel.characters.collect { characters ->
                if (characters.isNotEmpty())
                adapter?.updateData(characters)
            }
        }
    }

    private fun onClickItem(id: Int) {
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            add<DetailFragment>(R.id.container, args = bundleOf(Pair("id", id)))
        }
    }
}