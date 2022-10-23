package com.metafisa.myanubhav

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.metafisa.myanubhav.R

class CompanyReviewAdapter(private val mList : List<ItemsViewModel>) :
    RecyclerView.Adapter<ReviewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_design,parent,false)
        return ReviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.profilePic.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.rateCmpny.text = ItemsViewModel.text

    }

    override fun getItemCount(): Int {
        return 9
    }
}

class ReviewViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val profilePic : ImageView = itemView.findViewById(R.id.profileImageView)
    val nameEtcetra : TextView = itemView.findViewById(R.id.nameEtc)
    val rateCmpny : TextView = itemView.findViewById(R.id.rating)
    val cmpnyname : TextView = itemView.findViewById(R.id.cmpnyNameFrRev)
    val starImage : ImageButton = itemView.findViewById(R.id.star)

}