package es.maincode.altentest.view.viewModels

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.maincode.domain.detail.GetDetailUseCase
import es.maincode.altentest.base.BaseViewModel
import es.maincode.altentest.view.vo.CharacterVO
import es.maincode.altentest.view.vo.toPresentation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailUseCase: GetDetailUseCase
): BaseViewModel() {

    private val _character = MutableStateFlow<CharacterVO?>(null)
    val character: StateFlow<CharacterVO?> get() = _character

    fun getDetail(id: Int) {
        viewModelScope.launch {
            detailUseCase(id).collect { response ->
                response.success?.let {
                    _character.value = it.toPresentation()
                }
            }
        }
    }
}