package com.example.btvn_week3

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnClickListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //default
        imgMain.setImageResource(R.drawable.h5)
        textMain.text = "NHOM 1 - DTV"

        //button click
        btnCBG.setOnClickListener(gotoBackground)
        btnCTT.setOnClickListener(gotoTitleActivity)

    }

    companion object {
        const val REQUEST_BACKGROUND = 1102
        const val REQUEST_TITLE = 1998
    }

    //go title
    private val gotoTitleActivity = OnClickListener {
        val goTit = Intent(this, SettingTitle::class.java)
        //create and add Text to bundle
        val b = Bundle()
        b.putParcelable("currentText",Text(textMain.text.toString(),textMain.currentTextColor))
        //transfer bundle
        goTit.putExtras(b)
        startActivityForResult(goTit, REQUEST_TITLE)
    }

    //change background
    private val gotoBackground = OnClickListener {
        val gobg = Intent(this, SettingBackground::class.java)
        startActivityForResult(gobg, REQUEST_BACKGROUND)
    }

    //after have activity's result
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        //background
        if (requestCode == REQUEST_BACKGROUND && resultCode == Activity.RESULT_OK) {
            val imgNew = data?.getIntExtra("drawID", 0)
            imgNew?.let {imgMain.setImageResource(imgNew)} //check null and set image
        }

        //title
        if (requestCode == REQUEST_TITLE && resultCode == Activity.RESULT_OK) {
            //recieve bundle
            val b = data?.getExtras()
            b?.let{
                val nTex = b.getParcelable<Text>("newText")
                textMain.setText(nTex.tex)
                textMain.setTextColor(nTex.col)
            }
        }

    }
}
