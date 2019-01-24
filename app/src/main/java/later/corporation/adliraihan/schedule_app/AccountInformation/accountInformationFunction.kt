package later.corporation.adliraihan.schedule_app.AccountInformation

import android.content.Context
import android.preference.PreferenceManager
import android.util.Log

class accountInformationFunction{
    fun checkingAccountInformation(context:Context){
        context.apply {
            PreferenceManager.getDefaultSharedPreferences(this).apply {
                Log.i("Tags Logs :" ,getString("username",""))
            }
        }
    }
    fun setAccountInformation(
        context: Context,
        user_id:String,
        username:String,
        password:String){
        context.apply {
            PreferenceManager.getDefaultSharedPreferences(this).edit().apply{
                putString("user_id",user_id)
                putString("username",username)
                putString("password",password)
            }
        }
    }
}