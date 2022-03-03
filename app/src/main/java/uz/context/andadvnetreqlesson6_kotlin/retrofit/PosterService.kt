package uz.context.andadvnetreqlesson6_kotlin.retrofit

import retrofit2.Call
import retrofit2.http.*
import uz.context.andadvnetreqlesson6_kotlin.model.Employee
import uz.context.andadvnetreqlesson6_kotlin.model.EmployeeResp

interface PosterService {

    @Headers(
        "Content-type:application/json"
    )
    @GET("api/v1/employees")
    fun listEmployees(): Call<ArrayList<EmployeeResp>>

    @GET("api/v1/employees/{id}")
    fun singleEmployee(@Path("id") id: Int): Call<EmployeeResp>

    @POST("api/v1/create")
    fun createEmployee(@Body employee: Employee): Call<EmployeeResp>

    @PUT("api/v1/update/{id}")
    fun updateEmployee(@Path("id") id: Int, @Body employee: Employee): Call<EmployeeResp>

    @DELETE("api/v1/delete/{id}")
    fun deleteEmployee(@Path("id") id: Int): Call<EmployeeResp>

}