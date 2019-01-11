package later.corporation.adliraihan.schedule_app.otherFunctionSchedule_app

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.view.menu.MenuView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import later.corporation.adliraihan.schedule_app.R

class adapterFunction(
        private val totaljam:ArrayList<Int>,
        private val judul:ArrayList<String?>,
        private val desc:ArrayList<String?>,
        private val context: Context
):RecyclerView.Adapter<adapterFunction.adapterHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): adapterHolder {
        return adapterHolder(LayoutInflater.from(p0.context).inflate(R.layout.activity_holder_recycler,p0,false))
    }

    override fun getItemCount(): Int {
        return totaljam.size
    }

    override fun onBindViewHolder(p0: adapterHolder, p1: Int) {
        if(p1 > 0){
            p0.dateRecyc.setTextColor(ContextCompat.getColor(context,android.R.color.transparent))
            p0.dayRecyc.setTextColor(ContextCompat.getColor(context,android.R.color.transparent))
        }

        if(p1 != totaljam.size-1 && totaljam.size > 1){
            p0.imgsparator.visibility = android.view.View.VISIBLE
        }


        p0.descRecyc.setText(desc[p1])
        p0.maxhours.apply {
            if(totaljam[p1] == 0) setText(" ${totaljam[p1]} Hour")
            else if(totaljam[p1] > 0) setText(" ${totaljam[p1]} Hours")
            else setText(" Error ")
        }
        p0.judulRecyc.setText(judul[p1])
    }

    class adapterHolder(itemView:android.view.View) : RecyclerView.ViewHolder(itemView){

        val dateRecyc = itemView.findViewById<TextView>(R.id.tanggalrecycler)
        val dayRecyc = itemView.findViewById<TextView>(R.id.harirecycler)
        val descRecyc = itemView.findViewById<TextView>(R.id.descrecycler)
        val judulRecyc = itemView.findViewById<TextView>(R.id.judulrecycler)
        val maxhours= itemView.findViewById<TextView>(R.id.totaljamrecycler)
        val imgsparator = itemView.findViewById<ImageView>(R.id.separatorrecycler)
    }
}