package com.alvin.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    private var clubName: String = ""
    private var clubDesc: String = ""
    private var clubImage: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = intent
        clubName = intent.getStringExtra("name")
        clubDesc = intent.getStringExtra("desc")
        clubImage = intent.getIntExtra("image", 0)

        verticalLayout {

            imageView {
                id = R.id.club_image_detail
            }.lparams(width = dip(70), height = dip(70)) {
                topMargin = dip(20)
                //layout gravity ini fungsinya
                gravity = Gravity.CENTER_HORIZONTAL
            }

            textView {
                id = R.id.club_name_detail
                //gravity biasa
                gravity = Gravity.CENTER
                textSize = 16f
            }.lparams(width = matchParent, height = wrapContent) {
                topMargin = dip(10)
            }

            textView {
                id = R.id.club_desc_detail
            }.lparams(width = matchParent) {
                topMargin = dip(10)
                leftPadding = dip(10)
                rightPadding = dip(10)
            }
        }

        val name: TextView = find(R.id.club_name_detail)
        val desc: TextView = find(R.id.club_desc_detail)
        val image: ImageView = find(R.id.club_image_detail)

        name.text = clubName
        Glide.with(this).load(clubImage).into(image)
        desc.text = clubDesc
    }
}