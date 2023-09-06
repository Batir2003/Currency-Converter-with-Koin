package com.example.correncyconverterwithkoin.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.correncyconverterwithkoin.utils.ConvertEvent
import com.example.correncyconverterwithkoin.utils.Resourse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    private val _conversion = MutableStateFlow<ConvertEvent>(ConvertEvent.Empty)
    val conversion: StateFlow<ConvertEvent> get() = _conversion

    fun getConvertRate(
        from: String,
        to: String,
        amount: String
    ) {
        if (amount.isBlank()) {
            return
        }
        viewModelScope.launch {
            _conversion.value = ConvertEvent.Loading
            when (val result = mainRepository.convertRate(from, to, amount)) {
                is Resourse.Error -> {
                    _conversion.value = ConvertEvent.Error(result.message)
                }

                is Resourse.Success -> {
                    if (result.data != null) {
                        _conversion.value = ConvertEvent.Success(result.data)
                    } else {
                        _conversion.value = ConvertEvent.Error(null)
                    }
                }
            }
        }
    }

}