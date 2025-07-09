package com.rishu.quizapplication.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.rishu.quizapplication.ui.screens.QuestionScreen
import com.rishu.quizapplication.ui.screens.ResultScreen
import com.rishu.quizapplication.ui.screens.SplashScreen
import com.rishu.quizapplication.ui.theme.QuizApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val questions by viewModel.questions.collectAsState()
            val index by viewModel.currentIndex.collectAsState()
            val streak by viewModel.streak.collectAsState()
            val result by viewModel.result.collectAsState()

            QuizApplicationTheme {
                Box(modifier = Modifier.systemBarsPadding()) {
                    if (questions.isEmpty()) {
                        SplashScreen {
                            viewModel.restartQuiz()
                        }
                    } else if (result != null) {
                        ResultScreen(result!!) {
                            viewModel.restartQuiz()
                        }
                    } else {
                        QuestionScreen(
                            question = questions[index],
                            streak = streak,
                            currentIndex = index,
                            totalQuestions = questions.count(),
                            onAnswer = viewModel::answerSelected,
                            onSkip = viewModel::skip
                        )
                    }
                }
            }
        }
    }
}
