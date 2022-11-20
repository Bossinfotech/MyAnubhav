package com.metafisa.myanubhav.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.metafisa.myanubhav.R
import com.metafisa.myanubhav.models.FaqSalcal

class FaqSalcalAdapter(private val faqsalcallist: List<FaqSalcal>) :

    RecyclerView.Adapter<FaqSalcalAdapter.FaqSalcalVH>() {
    class FaqSalcalVH (itemView:View):RecyclerView.ViewHolder(itemView){

        var faqqusTxt:TextView=itemView.findViewById(R.id.faqquestion)
        var faqansTxt:TextView=itemView.findViewById(R.id.ans)
        var linerlayout:LinearLayout=itemView.findViewById(R.id.linerLayout)
        var expandablayout:RelativeLayout=itemView.findViewById(R.id.expandable_layout)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaqSalcalVH {

        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.faq_salarycal,parent,false)

        return FaqSalcalVH(view)

    }

    override fun getItemCount(): Int {

        return faqsalcallist.size
    }

    override fun onBindViewHolder(holder: FaqSalcalVH, position: Int) {

        val faqSalcal:FaqSalcal=faqsalcallist[position]
        holder.faqqusTxt.text=faqSalcal.faqquestion
        holder.faqansTxt.text=faqSalcal.ans

        val isExpandable:Boolean= faqsalcallist[position].expandable
        holder.expandablayout.visibility = if (isExpandable) View.VISIBLE else View.GONE

        holder.linerlayout.setOnClickListener {

            val faqSalcal=faqsalcallist[position]
            faqSalcal.expandable=!faqSalcal.expandable
            notifyItemChanged(position)
        }
    }
}