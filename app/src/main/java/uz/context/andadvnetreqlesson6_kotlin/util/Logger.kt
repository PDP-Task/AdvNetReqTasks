package uz.context.andadvnetreqlesson6_kotlin.util
import android.util.Log
import uz.context.andadvnetreqlesson6_kotlin.volley.VolleyHttp

class Logger {
    companion object {
        fun d(tag: String, msg: String) {
            if (VolleyHttp.IS_TESTER) Log.d(tag, msg)
        }

        fun i(tag: String, msg: String) {
            if (VolleyHttp.IS_TESTER) Log.i(tag, msg)
        }

        fun v(tag: String, msg: String) {
            if (VolleyHttp.IS_TESTER) Log.v(tag, msg)
        }

        fun e(tag: String, msg: String) {
            if (VolleyHttp.IS_TESTER) Log.e(tag, msg)
        }
    }
}