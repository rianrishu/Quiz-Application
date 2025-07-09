package com.rishu.quizapplication.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rishu.quizapplication.data.model.Question


@Composable
fun QuestionScreen(
    question: Question,
    streak: Int,
    currentIndex: Int,
    totalQuestions: Int,
    onAnswer: (Int) -> Unit,
    onSkip: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "Question ${currentIndex + 1} / $totalQuestions",
                style = MaterialTheme.typography.titleSmall
            )
        }

        Spacer(Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Streak: $streak", style = MaterialTheme.typography.bodyLarge)
        }

        Spacer(Modifier.height(16.dp))
        Text(question.question, style = MaterialTheme.typography.bodyMedium)
        Spacer(Modifier.height(24.dp))

        question.options.forEachIndexed { idx, opt ->
            Button(
                onClick = {
                    onAnswer(idx)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Text(opt, color = Color.White)
            }
        }

        Spacer(Modifier.weight(1f))
        TextButton(
            onClick = { onSkip() },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Skip")
        }
    }
}
