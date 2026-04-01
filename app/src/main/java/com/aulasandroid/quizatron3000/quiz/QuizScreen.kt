package com.aulasandroid.quizatron3000.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aulasandroid.quizatron3000.components.ImageLogo

@Composable
fun QuizScreen(questao: Questao, numeroPergunta: Int, onProximaQuestao: (Boolean) -> Unit) {

    val viewModel: QuizScreenViewModel = viewModel(
        factory = QuizScreenViewModel.Factory(questao)
    )

    val listaDeOpcoes by viewModel.opcoes.observeAsState(emptyList())

    var indiceSelecionado by remember { mutableStateOf<Int?>(null) }

    var respondeu by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {

        listaDeOpcoes.forEach { opcao ->
            Button(
                onClick = { viewModel.removerOpcao(opcao) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Text(opcao)
            }
        }
    }
    Column(
        modifier = Modifier
            .background(Color(236, 123, 219, 255))
            .padding(top = 20.dp, start = 40.dp, end = 40.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        ImageLogo(
            modifier = Modifier
                .size(50.dp)
        )

        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(Color(91, 218, 73, 255))
                .height(50.dp)
                .border(
                    1.dp, Color(1, 1, 1),
                    RoundedCornerShape(
                        topStart = 10.dp,
                        topEnd = 10.dp,
                        bottomStart = 10.dp,
                        bottomEnd = 10.dp
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Text(
                text = if (numeroPergunta == 0) "Pergunta 1 de 3" else "Pergunta $numeroPergunta de 3",
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(horizontal = 30.dp)
            )
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = viewModel.pergunta,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center
                )
                listaDeOpcoes.forEachIndexed { index, opcao ->
                    val opcaoCorreta = opcao == questao.respostaCorreta
                    Button(
                        modifier = Modifier
                            .border(
                                1.dp, Color(115, 115, 115, 255),
                                RoundedCornerShape(
                                    topStart = 20.dp,
                                    topEnd = 20.dp,
                                    bottomStart = 20.dp,
                                    bottomEnd = 20.dp
                                )
                            )
                            .fillMaxWidth()
                            .height(50.dp),
                        onClick = {
                            if (!respondeu) {
                                indiceSelecionado = index
                                respondeu = true

                                onProximaQuestao(opcaoCorreta)
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.Black,
                            containerColor = when {
                                !respondeu -> Color.Transparent //nao respondeu
                                opcaoCorreta -> Color.Green
                                index == indiceSelecionado -> Color.Red
                                else -> Color.Transparent
                            }
                        ),
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = opcao,
                                fontSize = 18.sp,
                                textAlign = TextAlign.Start
                            )
                        }
                    }
                }
            }

        }

    }
}