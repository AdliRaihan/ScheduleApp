package later.corporation.adliraihan.schedule_app.otherFunctionSchedule_app

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import android.widget.Toast

class checkConnectivity {
    fun onCheck(Cntx: Context) : Boolean? {
        (Cntx.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
            .activeNetworkInfo.apply {
            Toast.makeText(Cntx, StringBuilder().also {
                if ((this != null) && isConnected) {
                    return true
                } else if (this == null) {
                    return false
                }
            }, Toast.LENGTH_SHORT).show()
        }
        return null
    }
}