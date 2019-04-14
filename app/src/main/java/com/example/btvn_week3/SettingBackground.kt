package com.example.btvn_week3

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.ImageButton
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.setting_background.*

class SettingBackground :AppCompatActivity() {
    var viewChange: Int = R.id.imgResul
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setting_background)

        imgBtn1.setOnClickListener(img1)
        imgBtn2.setOnClickListener(img2)
        imgBtn3.setOnClickListener(img3)
        imgBtn4.setOnClickListener(img4)

        saveBg.setOnClickListener(btnResultClick)

    }

    private val img1 = OnClickListener{
        chanImgResul(imgBtn1)
        viewChange = R.drawable.h1
    }
    private val img2 = OnClickListener{
        chanImgResul(imgBtn2)
        viewChange = R.drawable.h2
    }
    private val img3 = OnClickListener{
        chanImgResul(imgBtn3)
        viewChange = R.drawable.h3
    }
    private val img4 = OnClickListener{
        chanImgResul(imgBtn4)
        viewChange = R.drawable.h4
    }
    private fun chanImgResul(btn : ImageButton){
        imgResul.setImageDrawable(btn.background)
    }

    private val btnResultClick = OnClickListener {
        val goMain = Intent(this, MainActivity::class.java)
        goMain.putExtra("drawID",viewChange)
        setResult(Activity.RESULT_OK, goMain)
        //end activity
        finish()
    }
}