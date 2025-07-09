package com.rishu.quizapplication.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rishu.quizapplication.data.model.Question
import kotlinx.coroutines.delay


@Composable
fun QuestionScreen(
    question: Question,
    streak: Int,
    currentIndex: Int,
    totalQuestions: Int,
    onAnswer: (Int) -> Unit,
    onSkip: () -> Unit
) {
    var selectedIndex by remember { mutableStateOf<Int?>(null) }
    val correctIndex = question.correctOptionIndex
    var answered by remember { mutableStateOf(false) }

    LaunchedEffect(selectedIndex) {
        if (selectedIndex != null) {
            answered = true
            delay(2000)
            selectedIndex = null
            answered = false
        }
    }

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
            if (streak >= 3) {
                Spacer(modifier = Modifier.width(8.dp))
                AnimatedVisibility(
                    visible = true,
                    enter = fadeIn(animationSpec = tween(500)) + scaleIn(),
                    exit = fadeOut()
                ) {
                    Badge(
                        containerColor = Color.Yellow
                    ) {
                        Text("🔥 Keep going", fontSize = 18.sp)
                    }
                }
            }
        }

        Spacer(Modifier.height(16.dp))
        Text(question.question, style = MaterialTheme.typography.bodyMedium)
        Spacer(Modifier.height(24.dp))

        question.options.forEachIndexed { idx, opt ->
            val backgroundColor by animateColorAsState(
                targetValue = when {
                    selectedIndex == null -> MaterialTheme.colorScheme.primary
                    idx == selectedIndex && idx == correctIndex -> Color(0xFF4CAF50) // green
                    idx == selectedIndex && idx != correctIndex -> Color(0xFFF44336) // red
                    idx == correctIndex -> Color(0xFF4CAF50) // highlight correct
                    else -> MaterialTheme.colorScheme.primary
                }, label = ""
            )

            Button(
                onClick = {
                    if (selectedIndex == null) {
                        selectedIndex = idx
                        onAnswer(idx)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                colors = ButtonDefaults.buttonColors(containerColor = backgroundColor)
            ) {
                Text(opt, color = Color.White)
            }
        }

        Spacer(Modifier.weight(1f))
        TextButton(
            onClick = onSkip,
            modifier = Modifier.align(Alignment.End),
            enabled = !answered
        ) {
            Text("Skip")
        }
    }
}
