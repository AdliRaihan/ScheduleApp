package later.corporation.adliraihan.schedule_app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.StrictMode
import android.util.Log
import android.view.ActionMode
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splashing.*
import later.corporation.adliraihan.schedule_app.DatabaseSchedule_app.common_database

val tags = "SplashScreen"
class splashing : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashing)
        LoadingAnimation()
        common_database().onReadIDTarget(this)
    }
    fun LoadingAnimation(){
        Handler().postDelayed({
            val animQu = AnimationUtils.loadAnimation(this , R.anim.slide_down_loading).apply {
                this.fillAfter = true
            }
            appname_splash.startAnimation(animQu)

        },1000)
        Handler().postDelayed({
            val animQu =  AnimationUtils.loadAnimation(this , R.anim.slide_up_loading).apply {
                this.fillAfter = true
            }
            appname_splash.startAnimation(animQu)
            LoadingAnimation()
        },5000)
    }
    override fun onActionModeFinished(mode: ActionMode?) {
        super.onActionModeFinished(mode)
        Log.i(tags,mode.toString())
    }
}
