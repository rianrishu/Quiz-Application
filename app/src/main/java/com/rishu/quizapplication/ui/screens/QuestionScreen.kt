package com.rishu.quizapplication.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(backgroundColor = 0xFFFFFFFF,showBackground = true
)
@Composable
fun QuestionScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Question 1 / 10", style = MaterialTheme.typography.titleSmall)
        }

        Spacer(Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Streak: 1", style = MaterialTheme.typography.bodyLarge)
        }

        Spacer(Modifier.height(16.dp))
        Text("question 1")
        Spacer(Modifier.height(24.dp))

        for (i in 1..4) {
            Button(
                onClick = {
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Text("opt $i", color = Color.White)
            }
        }

        Spacer(Modifier.weight(1f))
        TextButton(
            onClick = { },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Skip")
        }
    }
}
