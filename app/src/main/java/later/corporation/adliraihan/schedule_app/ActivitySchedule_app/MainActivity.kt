package later.corporation.adliraihan.schedule_app.ActivitySchedule_app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_holder_recycler.view.*
import kotlinx.android.synthetic.main.activity_main.*
import later.corporation.adliraihan.schedule_app.DatabaseSchedule_app.common_database
import later.corporation.adliraihan.schedule_app.R
import later.corporation.adliraihan.schedule_app.otherFunctionSchedule_app.adapterFunction
import later.corporation.adliraihan.schedule_app.otherFunctionSchedule_app.calendarFunction
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    companion object {
        var jamString = arrayListOf<String>()
        var judulSingkatString = arrayListOf<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initMain()
    }

    fun initMain(){
        hide_content_settings.apply {
            setOnClickListener {
                content_landing.startAnimation(AnimationUtils.loadAnimation(this@MainActivity,R.anim.abc_fade_in)).apply {
                    content_landing.visibility = android.view.View.VISIBLE
                    content_settings.startAnimation(AnimationUtils.loadAnimation(this@MainActivity,R.anim.abc_fade_out)).apply {
                        content_settings.visibility = android.view.View.GONE
                    }
                }
                navigation_header_text.isEnabled = true
            }
            setOnLongClickListener {
                return@setOnLongClickListener true
            }
        }
        navigation_header_text.apply {
            setText("${Calendar.getInstance().time.date} ${calendarFunction().getMMMM(Calendar.getInstance().time.month)}")
            setOnClickListener {
                content_landing.startAnimation(AnimationUtils.loadAnimation(this@MainActivity,R.anim.abc_fade_out)).apply {
                    content_landing.visibility = android.view.View.GONE
                    content_settings.startAnimation(AnimationUtils.loadAnimation(this@MainActivity,R.anim.abc_fade_in)).apply {
                        content_settings.visibility = android.view.View.VISIBLE
                    }
                }
                    navigation_header_text.isEnabled = false
            }
            setOnLongClickListener {
                return@setOnLongClickListener true
            }
        }
        common_database().onReadIDTarget(this)
        println(jamString)
        initLandingQuote(jamString, judulSingkatString)
    }

    fun initLandingQuote(jamstr:ArrayList<String>,judulsingkatstr:ArrayList<String>){
        //===============//
        val paramMatch = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        paramMatch.setMargins(10,10,10,10)
        //===============//
        for (i:Int in 0..jamstr.size-1) {
            testJaks.addView(
                LinearLayout(this).apply {
                    setPadding(30,30,30,30)
                    background = getDrawable(R.drawable.activity_holder_white)
                    layoutParams = paramMatch
                        addView(
                            LayoutInflater.from(this@MainActivity).inflate(R.layout.activity_holder_recycler,this,false).also {
                                it.jamRecyler.setText(jamstr.get(i))
                                it.judulSingkat.setText(judulsingkatstr.get(i))
                            }
                        )
                }
            )
        }
        //======================//
    }
}

//RecyclerView(this@MainActivity).apply {
//    setPadding(50,50,50,50)
//    background = getDrawable(R.drawable.activity_holder_white)
//    setHasFixedSize(true)
//    layoutManager = viewManager
//    adapter = viewAdapter
//    layoutParams = paramMatch
//}