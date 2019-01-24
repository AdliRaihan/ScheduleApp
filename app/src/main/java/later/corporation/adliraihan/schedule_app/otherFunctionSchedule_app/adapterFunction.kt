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
        private val jamTarget:ArrayList<String>,
        private val totaljam:ArrayList<Int>,
        private val judul:ArrayList<String>,
        private val desc:ArrayList<String>,
        private val context: Context
):RecyclerView.Adapter<adapterFunction.adapterHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): adapterHolder {
        return adapterHolder(LayoutInflater.from(p0.context).inflate(R.layout.activity_child_recycler,p0,false))
    }

    override fun getItemCount(): Int {
        return jamTarget.size
    }

    override fun onBindViewHolder(p0: adapterHolder, p1: Int) {
//        //Tree DEBUGGING
//        println( judul.get(jamTarget.get(p1)))
//        println(desc.get(jamTarget.get(p1)))
        p0.apply {
            if(p1 > 0
            ){

            }
            if(p1 != totaljam.size-1 && totaljam.size > 1)
//                imgsparator.visibility = android.view.View.VISIBLE
            //=================//
            // Placement Variabel           //
            // ================ //
            judulRecyc.setText(judul[p1])
            descRecyc.setText(desc[p1])

            maxhours.apply {
                if(totaljam[p1] == 0) setText(" ${totaljam[p1]} Hour")
                else if(totaljam[p1] > 0) setText(" ${totaljam[p1]} Hours")
                else setText(" Error ")
            }
        }
    }

    class adapterHolder(itemView:android.view.View) : RecyclerView.ViewHolder(itemView){

        val descRecyc = itemView.findViewById<TextView>(R.id.descrecycler)
        val judulRecyc = itemView.findViewById<TextView>(R.id.judulrecycler)
        val maxhours= itemView.findViewById<TextView>(R.id.totaljamrecycler)
//        val parentRec= itemView.findViewById<ImageView>(R.id.parent_recycler)
    }
}