package uz.context.andadvnetreqlesson6_kotlin.volley

interface VolleyHandler {
    fun onSuccess(response: String?)
    fun onError(error: String?)
}