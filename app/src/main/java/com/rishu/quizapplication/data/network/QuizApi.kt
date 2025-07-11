package com.rishu.quizapplication.data.network

import com.rishu.quizapplication.data.model.Question
import retrofit2.http.GET

interface QuizApi {
    @GET("dr-samrat/53846277a8fcb034e482906ccc0d12b2/raw")
    suspend fun fetchQuestions(): List<Question>
}
