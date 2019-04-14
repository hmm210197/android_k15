package com.example.btvn_week3
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.Button
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.setting_title.*

class SettingTitle :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setting_title)

        //recieve bundle
        val b = getIntent().getExtras()
        val curTex = b.getParcelable<Text>("currentText")

        //set current text for setting page
        changeText(curTex)


        //change title when dress a button
        col1.setOnClickListener(chaCol1)
        col2.setOnClickListener(chaCol2)
        col3.setOnClickListener(chaCol3)
        col4.setOnClickListener(chaCol4)
        col5.setOnClickListener(chaCol5)
        col6.setOnClickListener(chaCol6)

        //Come back home
        saveTit.setOnClickListener(goBackMain)
    }

    //go back main
    private val goBackMain = OnClickListener {
        val goMain = Intent(this, MainActivity::class.java)
        //create and add Text to bundle
        val b = Bundle()
        b.putParcelable("newText",Text(newTitle.text.toString(),newTitle.currentTextColor))
        //transfer bundle
        goMain.putExtras(b)
        setResult(Activity.RESULT_OK, goMain)
        //end activity
        finish()
    }

    fun changeText(T: Text){
        newTitle.setText(T.tex)
        newTitle.setTextColor(T.col)
        colorView.setBackgroundColor(T.col)
    }

    //Change color when click button
    fun changColor(b:Button,col:String){
        newTitle.setTextColor(Color.parseColor(col))
        colorView.setImageDrawable(b.background)
    }
    var chaCol1 = OnClickListener {
        changColor(col1,"#ff3300")
    }
    var chaCol2 = OnClickListener {
        changColor(col2,"#0000ff")
    }
    var chaCol3 = OnClickListener {
        changColor(col3,"#ffff00")
    }
    var chaCol4 = OnClickListener {
        changColor(col4,"#00aa00")
    }
    var chaCol5 = OnClickListener {
        changColor(col5,"#cc0000")
    }
    var chaCol6 = OnClickListener {
        changColor(col6,"#990099")
    }

}