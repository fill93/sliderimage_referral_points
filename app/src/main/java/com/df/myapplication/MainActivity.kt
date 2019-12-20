package com.df.myapplication
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.df.imageslider.CallOnClickSlider
import com.df.imageslider.SliderItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , CallOnClickSlider{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sliderItems = listOf(
            SliderItem(title = "T1" ,url = "https://ap.imagensbrasil.org/images/2019/11/29/Banner-home-novo-bf.jpg", link = "http://www.google.com"),
            SliderItem(url = "https://ap.imagensbrasil.org/images/2019/10/03/bannere037db3e3eca2528.png", link = "Link2"),
            SliderItem(resID = R.drawable.ic_apps_24, link = "link3"),
            SliderItem(title = "T2", resID = R.drawable.ic_apps_24, link = "link4")
        )

        slide.setPages(sliderItems)
        slide.handleAnimate(3500)
        slide.actionSetCall(this)

    }

    override fun onClickSlider(item: SliderItem) {
        try{
            val url = item.link
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }catch (a : ActivityNotFoundException){
            Toast.makeText(this, "Link inválido", Toast.LENGTH_SHORT).show()
            a.printStackTrace()
        }
    }
}



