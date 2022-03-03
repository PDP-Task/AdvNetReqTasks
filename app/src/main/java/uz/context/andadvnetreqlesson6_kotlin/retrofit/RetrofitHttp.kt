package uz.context.andadvnetreqlesson6_kotlin.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHttp {
    val IS_TESTER = true
    val SERVER_DEVELOPMENT = "https://dummy.restapiexample.com/"
    val SERVER_PRODUCTION = "https://dummy.restapiexample.com/"

    val retrofit =
        Retrofit.Builder()
            .baseUrl(server())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private fun server(): String {
        if (IS_TESTER)
            return SERVER_DEVELOPMENT
        return SERVER_PRODUCTION
    }
    val posterService: PosterService = retrofit.create(PosterService::class.java)
}