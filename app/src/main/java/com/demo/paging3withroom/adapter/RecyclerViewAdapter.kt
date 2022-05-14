package com.demo.paging3withroom.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.demo.paging3withroom.DetailsActivity
import com.demo.paging3withroom.R
import com.demo.paging3withroom.model.UserData
import kotlinx.android.synthetic.main.reporitory_list_row.view.*

/**
 * @author Rohith S
 *  RecyclerViewAdapter loads data into a single list item
 */
class RecyclerViewAdapter(var mContext: Context): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private var listData: List<UserData>? = null
    fun setListData(listData: List<UserData>?) {
        this.listData = listData
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.MyViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.reporitory_list_row, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {
        holder.bind(listData?.get(position)!!,mContext)

    }

    override fun getItemCount(): Int {
        if(listData == null )return 0
        return listData?.size!!
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image_avatar_url = view.image_avatar_url
        val tvName = view.tvName
        val tvDesc = view.tvDesc


        fun bind(data: UserData, context: Context) {
            tvName.text = data.title
            tvDesc.text = data.date

            itemView.setOnClickListener{
                val intent = Intent(context, DetailsActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.putExtra("title", data.title)
                intent.putExtra("date", data.date)
                intent.putExtra("details",data.explanation)
                intent.putExtra("media_type",data.media_type)
                intent.putExtra("image",data.url)

                context.startActivity(intent)
            }

            Glide.with(image_avatar_url)
                .load(data.url)
                .into(image_avatar_url)
        }
    }
}