package com.rishu.quizapplication.data.repository

import com.rishu.quizapplication.data.model.Question
import com.rishu.quizapplication.data.network.QuizApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuizRepository @Inject constructor(
    private val api: QuizApi
) {
    suspend fun loadQuestions(): List<Question> = api.fetchQuestions()
}
