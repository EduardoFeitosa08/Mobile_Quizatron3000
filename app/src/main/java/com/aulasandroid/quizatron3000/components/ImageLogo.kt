package com.aulasandroid.quizatron3000.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.aulasandroid.quizatron3000.R

@Composable
fun ImageLogo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.quiz_logo),
        contentDescription = "",
        modifier = modifier
    )
}