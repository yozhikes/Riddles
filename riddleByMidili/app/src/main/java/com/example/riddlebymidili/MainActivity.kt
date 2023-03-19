package com.example.riddlebymidili

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import com.example.riddlebymidili.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bind: ActivityMainBinding
    var zagadki= listOf("")
    var zagshfl= listOf("")
    var qty=0
    var yep=0
    var bruh=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind= ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        zagadki= listOf("Тебе дано, а люди им пользуются.","Под гору — коняшка," +
                " в гору — деревяшка.","На деревья, на кусты с неба падают цветы. Белые, пушистые," +
                " только не душистые.","Сидит в темнице, красная девица, а коса на улице.","Зимой —" +
                " звезда, весной — вода.","Кто зимой холодной ходит злой, голодный?","Не лает, не " +
                "кусает, а в дом не пускает.","Сто одёжек и все без застежек.","Сидит дед, в шубу" +
                " одет, кто его раздевает, тот слёзы проливает.","Белые поросятки прилегли на" +
                " грядке.","К нам приехали с бахчи полосатые мячи.","Ах, не трогайте меня:" +
                " обожгу и без огня!","В поле лестница лежит, дом по лестнице бежит.","Чем больше" +
                " взяли, тем больше стала.","Вот иголки и булавки выползают из-под лавки. На меня" +
                " они глядят, молока они хотят.")
        zagshfl=zagadki.shuffled()
    }
    fun showriddleClick(view: View){
        bind.answerTxt.setBackgroundColor(Color.WHITE)
        bind.answerTxt.text=""
        bind.qtyTxt.text="${qty+1}/10"
        bind.riddleTxt.text=zagshfl[qty]
        qty++
        bind.answerBtn.isEnabled=true
        bind.showriddleBtn.isEnabled=false
    }
    fun restartClick(view: View){
        zagshfl=zagadki.shuffled()
        bind.restartBtn.isEnabled=false
        bind.statBtn.isEnabled=false
        bind.exitBtn.isEnabled=false
        bind.exitBtn.isVisible=false
        bind.exitBtn.isVisible=false
        bind.showriddleBtn.isEnabled=true
        bind.qtyTxt.text="0/10"
        bind.riddleTxt.text=""
        bind.answerTxt.text=""
        bind.answerTxt.setBackgroundColor(Color.WHITE)
        qty=0
        yep=0
        bruh=0
    }
    fun statClick(view: View){
        val intent= Intent(this,StatActivity::class.java)
        intent.putExtra("yep",yep.toString())
        intent.putExtra("bruh",bruh.toString())
        startActivity(intent)
    }
    fun answerClick(view: View){
        val intent= Intent(this,PickActivity::class.java)
        startActivityForResult(intent,100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode== 100 && resultCode== RESULT_OK && data!=null){
            bind.answerTxt.text=data.getStringExtra("pickedVal")
            if(data.getStringExtra("pickedID")==zagadki.indexOf(zagshfl[qty-1]).toString()){
                bind.answerTxt.setBackgroundColor(Color.GREEN)
                yep++
            }
            else{
                bind.answerTxt.setBackgroundColor(Color.RED)
                bruh++
            }
            bind.answerBtn.isEnabled=false
            if(qty!=10){
                bind.showriddleBtn.isEnabled=true
            }
            else{
                bind.statBtn.isEnabled=true
                bind.restartBtn.isVisible=true
                bind.exitBtn.isVisible=true
                bind.restartBtn.isEnabled=true
                bind.exitBtn.isEnabled=true
            }
        }
    }

    fun exitClick(view: View){
        finish()
    }
}