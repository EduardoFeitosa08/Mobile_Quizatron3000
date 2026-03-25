package com.aulasandroid.quizatron3000.quiz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.collections.emptyList

class QuizScreenViewModel(questao: Questao): ViewModel() {
    var pergunta = questao.pergunta
    private val _opcoes = MutableLiveData(questao.opcoes)
    var opcoes: LiveData<List<String>> = _opcoes

    fun removerOpcao(opcao: String){
        _opcoes.value = _opcoes.value?.filter { it != opcao }
    }

    fun limparColuna(){
        _opcoes.value = emptyList()
        pergunta = ""
    }

    class Factory(private val questao: Questao) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return QuizScreenViewModel(questao) as T
        }
    }
}