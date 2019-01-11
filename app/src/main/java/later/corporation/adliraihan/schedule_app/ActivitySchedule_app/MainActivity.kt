package later.corporation.adliraihan.schedule_app.ActivitySchedule_app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import later.corporation.adliraihan.schedule_app.R
import later.corporation.adliraihan.schedule_app.otherFunctionSchedule_app.adapterFunction

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    companion object {
        var date2 = arrayListOf<Int>( 1 , 2 , 3 , 4, 5)
        var totaljam = arrayListOf<Int>(24,12,8,2,3)
        var judul = arrayListOf<String?>(
                "Membeli ayam",
                "Membuat aplikasi",
                "Mendevelop GMaker",
                "Menjual data GMaker",
                "Menjual Hp baru saya"
        )
        var desc = arrayListOf<String?>(
                "Menjual ayam ku tapi ga laku laku",
                "Menjual ayam ku tapi ga laku laku",
                "Menjual ayam ku tapi ga laku laku",
                "Menjual ayam ku tapi ga laku laku",
                "Menjual ayam ku tapi ga laku laku"
        )

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewManager = LinearLayoutManager(this)
        viewAdapter = adapterFunction(totaljam, judul, desc,this)
        recyclerView = findViewById<RecyclerView>(R.id.date1).apply {
            setHasFixedSize(false)
            layoutManager = viewManager
            adapter = viewAdapter
        }

    }
}
