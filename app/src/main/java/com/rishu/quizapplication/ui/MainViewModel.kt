package com.rishu.quizapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rishu.quizapplication.data.model.Question
import com.rishu.quizapplication.data.model.ResultState
import com.rishu.quizapplication.data.repository.QuizRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: QuizRepository
) : ViewModel() {

    private val _questions = MutableStateFlow<List<Question>>(emptyList())
    val questions: StateFlow<List<Question>> = _questions

    private val _currentIndex = MutableStateFlow(0)
    val currentIndex: StateFlow<Int> = _currentIndex

    private val _streak = MutableStateFlow(0)
    val streak: StateFlow<Int> = _streak

    private val _result = MutableStateFlow<ResultState?>(null)
    val result: StateFlow<ResultState?> = _result

    private var correctAnswers = 0
    private var longestStreak = 0

    init {
        load()
    }

    private fun load() {
        // Error handling of the API could have been done
        viewModelScope.launch {
            _questions.value = repository.loadQuestions()
        }
    }

    fun answerSelected(index: Int) {
        val q = _questions.value[_currentIndex.value]
        if (index == q.correctOptionIndex) {
            _streak.value += 1
            correctAnswers++
            if (_streak.value > longestStreak) {
                longestStreak = _streak.value
            }
        } else {
            _streak.value = 0
        }
        viewModelScope.launch {
            delay(2000)
            next()
        }
    }

    fun skip() = next()

    private fun next() {
        if (_currentIndex.value < _questions.value.lastIndex) {
            _currentIndex.value += 1
        } else {
            _result.value = ResultState(
                correct = correctAnswers,
                total = _questions.value.size,
                longestStreak = longestStreak
            )
        }
    }

    fun restartQuiz() {
        _currentIndex.value = 0
        _streak.value = 0
        correctAnswers = 0
        longestStreak = 0
        _result.value = null
    }
}
