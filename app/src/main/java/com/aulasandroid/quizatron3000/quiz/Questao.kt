package com.aulasandroid.quizatron3000.quiz

data class Questao(
    val pergunta: String,
    val opcoes: List<String>,
    val respostaCorreta: String
)