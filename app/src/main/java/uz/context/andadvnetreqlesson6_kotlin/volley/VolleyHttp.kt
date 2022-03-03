package uz.context.andadvnetreqlesson6_kotlin.volley

import android.util.JsonReader
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import org.json.JSONObject
import uz.context.andadvnetreqlesson6_kotlin.app.MyApplication
import uz.context.andadvnetreqlesson6_kotlin.model.Employee
import uz.context.andadvnetreqlesson6_kotlin.util.Logger
import java.lang.invoke.MethodHandle

class VolleyHttp {
    companion object {
        private val TAG = VolleyHttp::class.java.simpleName
        val IS_TESTER = true
        val SERVER_DEVELOPMENT = "https://dummy.restapiexample.com/"
        val SERVER_PRODUCTION = "https://dummy.restapiexample.com/"

        fun server(url: String): String {
            if (IS_TESTER)
                return SERVER_DEVELOPMENT + url
            return SERVER_PRODUCTION + url
        }

        fun headers(): HashMap<String, String> {
            val headers = HashMap<String, String>()
            headers["Content-type"] = "application/json; charset=UTF-8"
            return headers
        }

        fun get(api: String, params: HashMap<String, String>, volleyHandler: VolleyHandler) {
            val stringRequest = object : StringRequest(Method.GET, server(api),
                Response.Listener { response ->
                    Logger.d(TAG, response)
                    volleyHandler.onSuccess(response)
                },
                Response.ErrorListener { error ->
                    Logger.e(TAG, error.toString())
                    volleyHandler.onError(error.toString())
                }
            ) {
                override fun getParams(): MutableMap<String, String>? {
                    return params
                }
            }
            MyApplication.instance!!.addToRequestQueue(stringRequest)
        }

        fun post(api: String, body: HashMap<String, Any>, volleyHandler: VolleyHandler) {
            val stringRequest = object : StringRequest(
                Method.POST, server(api),
                Response.Listener { response ->
                    Logger.d(TAG, response)
                    volleyHandler.onSuccess(response)
                },
                Response.ErrorListener { error ->
                    Logger.e(TAG, error.toString())
                    volleyHandler.onError(error.toString())
                }
            ) {
                override fun getHeaders(): MutableMap<String, String> {
                    return headers()
                }

                override fun getBody(): ByteArray {
                    return JSONObject(body as Map<*, *>).toString().toByteArray()
                }
            }
            MyApplication.instance!!.addToRequestQueue(stringRequest)
        }

        fun put(api: String, body: HashMap<String, Any>, volleyHandler: VolleyHandler) {
            val stringRequest = object : StringRequest(Method.PUT, server(api),
                Response.Listener { response ->
                    Logger.d(TAG, response)
                    volleyHandler.onSuccess(response)
                },
                Response.ErrorListener { error ->
                    Logger.e(TAG, error.toString())
                    volleyHandler.onError(error.toString())
                }
            ) {
                override fun getHeaders(): MutableMap<String, String> {
                    return headers()
                }

                override fun getBody(): ByteArray {
                    return JSONObject(body as Map<*, *>).toString().toByteArray()
                }
            }
            MyApplication.instance!!.addToRequestQueue(stringRequest)
        }

        fun delete(url: String, volleyHandler: VolleyHandler) {
            val stringRequest = object : StringRequest(Method.DELETE, server(url),
                Response.Listener { response ->
                    Logger.d(TAG, response)
                    volleyHandler.onSuccess(response)
                },
                Response.ErrorListener { error ->
                    Logger.e(TAG, error.toString())
                    volleyHandler.onError(error.toString())
                }
            ) {

            }
            MyApplication.instance!!.addToRequestQueue(stringRequest)
        }

        var API_LIST_POST = "api/v1/employees"
        var API_SINGLE_POST = "api/v1/employees/" //id
        var API_CREATE_POST = "api/v1/create"
        var API_UPDATE_POST = "api/v1/update/" //id
        var API_DELETE_POST = "api/v1/delete/" //id


        fun paramsEmpty(): HashMap<String, String> {
            return HashMap<String, String>()
        }

        fun paramsCreate(employee: Employee): HashMap<String, Any> {
            val params = HashMap<String, Any>()
            params["employee_name"] = employee.employee_name
            params["employee_salary"] = employee.employee_salary
            params["employee_age"] = employee.employee_age
            params["profile_image"] = employee.profile_image
            return params
        }

        fun paramsUpdate(employee: Employee): HashMap<String, Any> {
            val params = HashMap<String, Any>()
            params["id"] = employee.id
            params["employee_name"] = employee.employee_name
            params["employee_salary"] = employee.employee_salary
            params["employee_age"] = employee.employee_age
            params["profile_image"] = employee.profile_image
            return params
        }
    }
}