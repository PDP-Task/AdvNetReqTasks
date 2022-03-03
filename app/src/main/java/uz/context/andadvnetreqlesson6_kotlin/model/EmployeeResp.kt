package uz.context.andadvnetreqlesson6_kotlin.model

import com.google.gson.annotations.SerializedName

data class EmployeeResp(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("employee_name")
    val employee_name: String? = null,
    @SerializedName("employee_salary")
    val employee_salary: String? = null,
    @SerializedName("employee_age")
    val employee_age: Int = 0,
    @SerializedName("profile_image")
    val profile_image: String? = null
)