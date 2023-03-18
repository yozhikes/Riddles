package com.example.riddlebymidili

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.riddlebymidili.databinding.ActivityPickBinding

class PickActivity : AppCompatActivity() {
    private lateinit var bind: ActivityPickBinding
    var answers = listOf("имя","санки","снег","морковь","снежинка","волк","замок","капуста",
        "лук","кабачки","арбуз","крапива","поезд","яма","ёж")
    var ansshfl=answers.shuffled()
    var pickedans=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind= ActivityPickBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.radioButton1.text=ansshfl[0]
        bind.radioButton2.text=ansshfl[1]
        bind.radioButton3.text=ansshfl[2]
        bind.radioButton4.text=ansshfl[3]
        bind.radioButton5.text=ansshfl[4]
        bind.radioButton6.text=ansshfl[5]
        bind.radioButton7.text=ansshfl[6]
        bind.radioButton8.text=ansshfl[7]
        bind.radioButton9.text=ansshfl[8]
        bind.radioButton10.text=ansshfl[9]
        bind.radioButton11.text=ansshfl[10]
        bind.radioButton12.text=ansshfl[11]
        bind.radioButton13.text=ansshfl[12]
        bind.radioButton14.text=ansshfl[13]
        bind.radioButton15.text=ansshfl[14]
    }
    fun pickClick(view:View){
        when(bind.radioGroup.checkedRadioButtonId){
            bind.radioButton1.id->pickedans= bind.radioButton1.text.toString()
            bind.radioButton2.id->pickedans= bind.radioButton2.text.toString()
            bind.radioButton3.id->pickedans= bind.radioButton3.text.toString()
            bind.radioButton4.id->pickedans= bind.radioButton4.text.toString()
            bind.radioButton5.id->pickedans= bind.radioButton5.text.toString()
            bind.radioButton6.id->pickedans= bind.radioButton6.text.toString()
            bind.radioButton7.id->pickedans= bind.radioButton7.text.toString()
            bind.radioButton8.id->pickedans= bind.radioButton8.text.toString()
            bind.radioButton9.id->pickedans= bind.radioButton9.text.toString()
            bind.radioButton10.id->pickedans= bind.radioButton10.text.toString()
            bind.radioButton11.id->pickedans= bind.radioButton11.text.toString()
            bind.radioButton12.id->pickedans= bind.radioButton12.text.toString()
            bind.radioButton13.id->pickedans= bind.radioButton13.text.toString()
            bind.radioButton14.id->pickedans= bind.radioButton14.text.toString()
            bind.radioButton15.id->pickedans= bind.radioButton15.text.toString()
        }
        if (pickedans!=""){
            var id=answers.indexOf(pickedans)
            intent.putExtra("pickedID",id.toString())
            intent.putExtra("pickedVal",pickedans)
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}