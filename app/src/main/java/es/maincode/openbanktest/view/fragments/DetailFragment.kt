package es.maincode.openbanktest.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import dagger.hilt.android.AndroidEntryPoint
import es.maincode.openbanktest.R
import es.maincode.openbanktest.base.BaseFragment
import es.maincode.openbanktest.databinding.FragmentDetailBinding
import es.maincode.openbanktest.view.adapters.CharacterAdapter
import es.maincode.openbanktest.view.viewModels.DetailViewModel
import es.maincode.openbanktest.view.vo.CharacterVO
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class DetailFragment : BaseFragment(R.layout.fragment_detail) {

    private val viewModel: DetailViewModel by viewModels()
    private var binding: FragmentDetailBinding? = null
    private var adapter: CharacterAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        collectFlows()
        arguments?.getInt("id")?.let {
            viewModel.getDetail(it)
        }
    }

    private fun initRecycler() {
        binding?.let {
            with(it) {
                adapter = CharacterAdapter()
                rvData.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                rvData.adapter = adapter
            }
        }
    }

    private fun collectFlows() {
        lifecycleScope.launchWhenStarted {
            viewModel.character.collect { character ->
                character?.let {
                    renderView(it)
                }
            }
        }
    }

    private fun renderView(character: CharacterVO) {
        binding?.let {
            with(it) {
                ivImage.load(character.image)
                toolbar.navigationIcon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_back)
                toolbar.setNavigationOnClickListener {
                    onBackPressed()
                }
                toolbar.title = character.name

            }
        }
        adapter?.updateData(character.getPairInfo())
    }
}