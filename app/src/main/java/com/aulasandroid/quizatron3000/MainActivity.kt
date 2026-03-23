package com.aulasandroid.quizatron3000

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.quizatron3000.ui.theme.Quizatron3000Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Quizatron3000Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    HomeScreen(
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                    QuestionScreen(
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    ResultadoScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(3, 184, 238, 255)),
        contentAlignment = Alignment.Center,

        ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(70.dp)
        ) {
            ImageLogo(
                modifier = Modifier
                    .size(150.dp)
            )
            Text(
                text = "QUIZATRON 3000",
                fontSize = 30.sp
            )
            Button(
                onClick = {},
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomStart = 20.dp, bottomEnd = 20.dp),
                modifier = Modifier
                    .border(
                        1.dp,
                        Color.Black,
                        RoundedCornerShape(
                            topStart = 20.dp,
                            topEnd = 20.dp,
                            bottomStart = 20.dp,
                            bottomEnd = 20.dp
                        )
                    )
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Black,
                    containerColor = Color.Yellow
                )
            ) {
                Text(
                    text = "COMECAR!",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun ImageLogo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.quiz_logo),
        contentDescription = "",
        modifier = modifier
    )
}

@Composable
fun QuestionScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
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
                text = "Pergunta 1 de 3",
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
                    text = "Qual é a capital da França?",
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center
                )
                Button(
                    modifier = Modifier
                        .border(
                            1.dp, Color(115, 115, 115, 255),
                            RoundedCornerShape(
                                topStart = 10.dp,
                                topEnd = 10.dp,
                                bottomStart = 10.dp,
                                bottomEnd = 10.dp
                            )
                        )
                        .fillMaxWidth()
                        .height(50.dp)
                        .align(Alignment.Start),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.Transparent
                    ),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Londres",
                            fontSize = 18.sp,
                            textAlign = TextAlign.Start
                        )
                    }
                }
                Button(
                    modifier = Modifier
                        .border(
                            1.dp, Color(115, 115, 115, 255),
                            RoundedCornerShape(
                                topStart = 10.dp,
                                topEnd = 10.dp,
                                bottomStart = 10.dp,
                                bottomEnd = 10.dp
                            )
                        )
                        .fillMaxWidth()
                        .height(50.dp)
                        .align(Alignment.Start),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.Transparent
                    ),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Berlim",
                            fontSize = 18.sp,
                            textAlign = TextAlign.Start
                        )
                    }
                }
                Button(
                    modifier = Modifier
                        .border(
                            1.dp, Color(115, 115, 115, 255),
                            RoundedCornerShape(
                                topStart = 10.dp,
                                topEnd = 10.dp,
                                bottomStart = 10.dp,
                                bottomEnd = 10.dp
                            )
                        )
                        .fillMaxWidth()
                        .height(50.dp)
                        .align(Alignment.Start),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.Transparent
                    ),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Paris",
                            fontSize = 18.sp,
                            textAlign = TextAlign.Start
                        )
                    }
                }
                Button(
                    modifier = Modifier
                        .border(
                            1.dp, Color(115, 115, 115, 255),
                            RoundedCornerShape(
                                topStart = 10.dp,
                                topEnd = 10.dp,
                                bottomStart = 10.dp,
                                bottomEnd = 10.dp
                            )
                        )
                        .fillMaxWidth()
                        .height(50.dp)
                        .align(Alignment.Start),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.Transparent
                    ),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Madri",
                            fontSize = 18.sp,
                            textAlign = TextAlign.Start
                        )
                    }
                }
            }

        }

    }
}

@Composable
fun ResultadoScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        ImageLogo(
            modifier = Modifier
                .size(50.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
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
                    text = "Bom Trabalho!",
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                )
            }
            Text(
                text = "Você acertou 1 de 3 perguntas",
                fontSize = 20.sp,
            )
        }
        Button(
            onClick = {},
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomStart = 20.dp, bottomEnd = 20.dp),
            modifier = Modifier
                .border(
                    1.dp,
                    Color.Black,
                    RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomStart = 20.dp,
                        bottomEnd = 20.dp
                    )
                )
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color.Yellow
            )
        ) {
            Text(
                text = "JOGAR NOVAMENTE!",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

}