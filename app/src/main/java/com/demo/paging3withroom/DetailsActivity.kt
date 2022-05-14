package com.demo.paging3withroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.demo.paging3withroom.model.UserData
import com.demo.paging3withroom.viewmodel.MainActivityViewModel
import com.bumptech.glide.request.RequestOptions


/**
 * @author Rohith S
 * DetailsActivity displays title, date, image and details of a story
 */
class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        initDetailsViewModel()

    }

    /**
     * initDetailsViewModel intializes all views and assigns them their respective data
     */
    private fun initDetailsViewModel() {

        val titleDetails = findViewById(R.id.title_details_api) as TextView
        val dateDetails = findViewById(R.id.details_date_api) as TextView
        val imageDetails = findViewById(R.id.image_details) as ImageView
        val explanationDetails = findViewById(R.id.explanation_details) as TextView
        val backDetails = findViewById(R.id.back_details) as ImageButton

        if (intent.extras != null) {
            titleDetails.setText(intent.getStringExtra("title"))
            dateDetails.setText(intent.getStringExtra("date"))

            if(intent.getStringExtra("media_type")!!.equals("image")){

                Glide.with(imageDetails).load(intent.getStringExtra("image")).into(imageDetails)

            }
            explanationDetails.setText(intent.getStringExtra("details"))

            backDetails.setOnClickListener(object : View.OnClickListener {
                override fun onClick(view: View?) {
                    finish()
                }

            })

        }

    }


}