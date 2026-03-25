package com.aulasandroid.quizatron3000

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aulasandroid.quizatron3000.quiz.Questao
import com.aulasandroid.quizatron3000.screens.HomeScreen
import com.aulasandroid.quizatron3000.quiz.QuizScreen
import com.aulasandroid.quizatron3000.screens.ResultadoScreen
import com.aulasandroid.quizatron3000.ui.theme.Quizatron3000Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Quizatron3000Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "home",
                        exitTransition = {
                            slideOutOfContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(1000)
                            )
                        },
                        enterTransition = {
                            slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(1000)
                            )
                        }
                    ){
                        composable (
                            route = "home",
                            ){
                            HomeScreen(navController = navController)
                        }

                        val listaDePerguntas = listOf(
                            Questao(
                                "Qual a capital do Brasil?",
                                listOf("Rio", "Brasília", "SP"),
                                "Brasília"
                            ),
                            Questao(
                                "Quanto custa um Bubbaloo?",
                                listOf("R$7,00", "R$305,00", "1 Bilhão ZiG"),
                                "R$7,00"
                            ),
                            Questao(
                                "Quem ganhou na Segunda Guerra Mundial",
                                listOf("Japão", "Alemanha", "Italia", "Estados Unidos"),
                                "Estados Unidos"
                            )
                        )
                        composable(
                            route = "quiz/{indice}/{nome}/{acertos}"
                        ){
                            val nome = it.arguments?.getString("nome")
                            val indice = it.arguments?.getString("indice")?.toInt() ?: 0
                            var acertos = it.arguments?.getString("acertos")?.toInt() ?: 0
                            val questao = listaDePerguntas[indice]
                            QuizScreen(
                                questao = questao,
                                onProximaQuestao = { acertou ->
                                    var acertosAtual = if (acertou) acertos + 1 else acertos
                                    val proximoIndice = indice + 1
                                    if (proximoIndice < listaDePerguntas.size) {
                                        navController.navigate("quiz/$proximoIndice/$nome/$acertosAtual")
                                    } else {
                                        navController.navigate("resultado/$acertosAtual/$nome")
                                    }

                                },
                                numeroPergunta = indice + 1)
                        }
                        composable(
                            route = "resultado/{acertos}/{nome}"
                        ){
                            val acertos = it.arguments?.getString("acertos")?.toInt() ?: 0
                            val nome = it.arguments?.getString("nome")
                            ResultadoScreen(navController = navController, numeroAcertos = acertos, nome = if (nome == "") "Você" else nome!!)
                        }
                    }
                }
            }
        }
    }
}