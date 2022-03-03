package uz.context.andadvnetreqlesson6_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import uz.context.andadvnetreqlesson6_kotlin.model.Employee
import uz.context.andadvnetreqlesson6_kotlin.model.EmployeeResp
import uz.context.andadvnetreqlesson6_kotlin.retrofit.RetrofitHttp
import uz.context.andadvnetreqlesson6_kotlin.volley.VolleyHandler
import uz.context.andadvnetreqlesson6_kotlin.volley.VolleyHttp
import java.io.IOException
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {

    private val employee = Employee(1, "John", 320000, 35, "image")
    private lateinit var textView: TextView
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()


    }

    private fun initViews() {
        textView = findViewById(R.id.textView)
        progressBar = findViewById(R.id.progressbar)
        progressBar.isVisible = true

       deleteRetrofit()

    }

    private fun deleteRetrofit() {
        RetrofitHttp.posterService.deleteEmployee(employee.id)
            .enqueue(object : Callback<EmployeeResp> {
                override fun onResponse(
                    call: Call<EmployeeResp>,
                    response: Response<EmployeeResp>
                ) {
                    textView.text = response.body()!!.toString()
                    progressBar.isVisible = false
                    Log.d("@@@", response.body()!!.toString())
                }

                override fun onFailure(call: Call<EmployeeResp>, t: Throwable) {
                    textView.text = t.message.toString()
                    progressBar.isVisible = false
                    Log.d("@@@", t.message.toString())
                }
            })
    }

    private fun updateRetrofit() {
        val employee1 = Employee(1, "John", 320000, 35, "image")
        RetrofitHttp.posterService.updateEmployee(employee1.id, employee1)
            .enqueue(object: Callback<EmployeeResp> {
                override fun onResponse(
                    call: Call<EmployeeResp>,
                    response: Response<EmployeeResp>
                ) {
                    textView.text = response.body()!!.toString()
                    progressBar.isVisible = false
                    Log.d("@@@", response.body()!!.toString())
                }

                override fun onFailure(call: Call<EmployeeResp>, t: Throwable) {
                    textView.text = t.message.toString()
                    progressBar.isVisible = false
                    Log.d("@@@", t.message.toString())
                }
            })
    }

    private fun createRetrofit() {
        RetrofitHttp.posterService.createEmployee(employee)
            .enqueue(object : Callback<EmployeeResp> {
                override fun onResponse(
                    call: Call<EmployeeResp>,
                    response: Response<EmployeeResp>
                ) {
                    textView.text = response.body()!!.toString()
                    progressBar.isVisible = false
                    Log.d("@@@", response.body()!!.toString())
                }

                override fun onFailure(call: Call<EmployeeResp>, t: Throwable) {
                    textView.text = t.message.toString()
                    progressBar.isVisible = false
                    Log.d("@@@", t.message.toString())
                }
            })
    }

    private fun workWithRetrofit() {
        RetrofitHttp.posterService.listEmployees()
            .enqueue(object : Callback<ArrayList<EmployeeResp>> {
                override fun onResponse(
                    call: Call<ArrayList<EmployeeResp>>,
                    response: Response<ArrayList<EmployeeResp>>
                ) {
                    try {
                        textView.text = response.body()!!.toString()
                        progressBar.isVisible = false
                        Log.d("@@@", response.body()!!.toString())
                    } catch (e: IOException) {
                        e.printStackTrace()
                        Log.d("@@@", e.message.toString())
                    } catch (e: HttpException) {
                        Log.d("@@@", e.message.toString())
                        e.printStackTrace()
                    }
                }

                override fun onFailure(call: Call<ArrayList<EmployeeResp>>, t: Throwable) {
                    textView.text = t.message.toString()
                    progressBar.isVisible = false
                    Log.d("@@@", t.message.toString())
                }
            })
    }

    private fun deleteVolley() {
        VolleyHttp.delete(VolleyHttp.API_DELETE_POST + employee.id, object : VolleyHandler {
            override fun onSuccess(response: String?) {
                textView.text = response
                progressBar.isVisible = false
            }

            override fun onError(error: String?) {
                textView.text = error
                progressBar.isVisible = false
            }
        })
    }

    private fun putVolley() {
        VolleyHttp.put(VolleyHttp.API_UPDATE_POST + employee.id,
            VolleyHttp.paramsUpdate(employee),
            object : VolleyHandler {
                override fun onSuccess(response: String?) {
                    textView.text = response
                    progressBar.isVisible = false
                }

                override fun onError(error: String?) {
                    textView.text = error
                    progressBar.isVisible = false
                }
            }
        )
    }

    private fun posterVolley() {
        VolleyHttp.post(
            VolleyHttp.API_CREATE_POST,
            VolleyHttp.paramsCreate(employee),
            object : VolleyHandler {
                override fun onSuccess(response: String?) {
                    textView.text = response
                    progressBar.isVisible = false
                }

                override fun onError(error: String?) {
                    textView.text = error
                    progressBar.isVisible = false
                }
            }
        )
    }

    private fun workWithVolley() {
        VolleyHttp.get(VolleyHttp.API_LIST_POST, VolleyHttp.paramsEmpty(), object : VolleyHandler {
            override fun onSuccess(response: String?) {
                textView.text = response
                progressBar.isVisible = false
            }

            override fun onError(error: String?) {
                textView.text = error
                progressBar.isVisible = false
            }
        })
    }
}