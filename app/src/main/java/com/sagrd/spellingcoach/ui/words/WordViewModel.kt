package com.sagrd.spellingcoach.ui.words

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sagrd.spellingcoach.data.WordsRepository
import com.sagrd.spellingcoach.data.local.entity.WordEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordViewModel @Inject constructor(
    val repository: WordsRepository
) : ViewModel() {

    val words: Flow<List<WordEntity>> = repository.GetList()

    var name  by mutableStateOf("")
    var description  by mutableStateOf("")

    fun Save() {
        viewModelScope.launch {
            repository.Insert(
                WordEntity(
                    name = name,
                    description = description
                )
            )
        }

    }


}