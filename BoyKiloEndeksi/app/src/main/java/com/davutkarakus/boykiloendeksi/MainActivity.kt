package com.davutkarakus.boykiloendeksi

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var Cinsiyet: String = ""
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageViewBoy.setOnClickListener {
            imageViewGirl.setImageResource(R.drawable.ic_girl_blur)
            imageViewBoy.setImageResource(R.drawable.ic_boy)
            Cinsiyet = "Erkek"

        }
        imageViewGirl.setOnClickListener {
            imageViewBoy.setImageResource(R.drawable.ic_boy_blur)
            imageViewGirl.setImageResource(R.drawable.ic_girl)
            Cinsiyet = "Kadın"

        }
        Toast.makeText(this, "Hoşgeldin", Toast.LENGTH_LONG).show()
        button.setOnClickListener {
            if (Cinsiyet.isEmpty()) {
                val uyariMesaji = AlertDialog.Builder(this)
                uyariMesaji.setTitle("Hata")
                uyariMesaji.setMessage("Lütfen Cinsiyet Seçiniz")
                uyariMesaji.setPositiveButton(
                    "Tamam",
                    DialogInterface.OnClickListener { dialog, which ->
                        Toast.makeText(this, "Baştan Deniyorsunuz", Toast.LENGTH_LONG).show()

                    })

                uyariMesaji.show()
            }
            println("Fonksiyon Çalıştı")
            var editText1 = editTextNumber1.text.toString()
            var editText2 = editTextNumber2.text.toString()
            if (editText1 == "" || editText2 == "") {
                val uyariMesaji = AlertDialog.Builder(this)
                uyariMesaji.setTitle("Hata")
                uyariMesaji.setMessage("Lütfen Değer/leri Giriniz")
                uyariMesaji.setPositiveButton(
                    "Tamam",
                    DialogInterface.OnClickListener { dialog, which ->
                        Toast.makeText(this, "Baştan Deniyorsunuz", Toast.LENGTH_LONG).show()

                    })

                uyariMesaji.show()
            }
            else {
                var kilo = editTextNumber1.text.toString().toFloat()
                var boy = (editTextNumber2.text.toString().toFloat()) / 100
                var endeks = kilo / (boy * boy)
                textView3.text = endeks.toString()
                textView3.visibility = View.VISIBLE
                button.visibility = View.INVISIBLE
                if(endeks<=18.5){
                    textView4.text="ZAYIF"
                }
                if(18.5<endeks && endeks<=24.9){
                    textView4.text="NORMAL KİLOLU"
                }
                if(25<endeks && endeks<=29.9){
                    textView4.text="FAZLA KİLOLU"
                }
                if(30<endeks && endeks<=34.9){
                    textView4.text="1.DERECE OBEZİTE"
                }
                if(35<endeks && endeks<=40){
                    textView4.text="2.DERECE OBEZİTE"
                }
                if(40<endeks){
                    textView4.text="3.DERECE OBEZİTE"
                }

                textView4.visibility=View.VISIBLE
                textView5.visibility=View.VISIBLE

            }

        }
        textView5.setOnClickListener {
            button.visibility=View.VISIBLE
            textView4.visibility=View.INVISIBLE
            textView3.visibility=View.INVISIBLE
            editTextNumber1.setText("")
            editTextNumber2.setText("")
            editTextNumber1.hint="00"
            editTextNumber2.hint="00"
            textView5.visibility=View.INVISIBLE

        }
        /*  fun button(view: View) {
                println("Fonksiyon Çalıştı")
                var kilo = editTextNumber1.text.toString().toDouble()
                var boy = (editTextNumber2.text.toString().toDouble()) / 100
                var endeks = kilo / (boy * boy)

                if (Cinsiyet == "Erkek") {
                        if(endeks<20){
                            println("Güzel")
                            button.visibility=View.INVISIBLE
                            textView3.visibility=View.VISIBLE
                        }
                    if(endeks>20)
                    {
                        println("Kötü")
                        button.visibility=View.INVISIBLE
                        textView3.visibility=View.VISIBLE
                    }
                    }
                if(Cinsiyet=="Kadın")
                {
                    println("Güzel")
                    button.visibility=View.INVISIBLE
                    textView3.visibility=View.VISIBLE
                }
                else
                {
                    val uyariMesaji=AlertDialog.Builder(applicationContext)
                    uyariMesaji.setTitle("Cinsiyet ")
                    uyariMesaji.setMessage("Lütfen Cinsiyet Seçiniz ")
                    uyariMesaji.setNeutralButton("Tamam",DialogInterface.OnClickListener { dialog, which ->
                        Toast.makeText(this,"Seçiyorsunuz",Toast.LENGTH_LONG).show()
                    })
                }

           */
    }
}








