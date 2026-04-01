package com.aulasandroid.quizatron3000.screens

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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aulasandroid.quizatron3000.components.ImageLogo

@Composable
fun ResultadoScreen(navController: NavController, numeroAcertos: Int, nome: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 30.dp),
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
                .height(150.dp)
                .background(Color(104, 244, 255, 255)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
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
                text = "$nome acertou $numeroAcertos de 3 perguntas",
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            )
        }
        Button(
            onClick = {
                navController.navigate(route = "home")

            },
            shape = RoundedCornerShape(
                topStart = 20.dp,
                topEnd = 20.dp,
                bottomStart = 20.dp,
                bottomEnd = 20.dp
            ),
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
                .wrapContentSize()
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