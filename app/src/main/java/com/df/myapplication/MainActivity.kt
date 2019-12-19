package com.df.myapplication
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.df.imageslider.SliderItem
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sliderItems = listOf(
            SliderItem(title = "T1" ,url = "https://ap.imagensbrasil.org/images/2019/11/29/Banner-home-novo-bf.jpg", link = "http://www.google.com"),
            SliderItem(url = "https://ap.imagensbrasil.org/images/2019/10/03/bannere037db3e3eca2528.png", link = "Link2"),
            SliderItem(resID = R.drawable.ic_apps_24, link = "link3"),
            SliderItem(title = "T2", resID = R.drawable.ic_apps_24, link = "link3")
        )

        slide.setPages(sliderItems)
        slide.handleAnimate(3500)

    }
}



