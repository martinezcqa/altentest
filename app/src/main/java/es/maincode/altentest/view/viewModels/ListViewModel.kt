package es.maincode.altentest.view.viewModels

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.maincode.domain.list.GetListUseCase
import es.maincode.altentest.base.BaseViewModel
import es.maincode.altentest.view.vo.CharacterVO
import es.maincode.altentest.view.vo.toPresentation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getListUseCase: GetListUseCase
): BaseViewModel() {

    private val _characters = MutableStateFlow<List<CharacterVO>>(emptyList())
    val characters: StateFlow<List<CharacterVO>> get() = _characters

    fun getList() {
        viewModelScope.launch {
            getListUseCase(Unit).collect { response ->
                response.success?.let {
                    _characters.value = it.results.map { character -> character.toPresentation() }
                }
            }
        }
    }
}