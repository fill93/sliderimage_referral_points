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

        val sliderItems = ArrayList<SliderItem>()

        sliderItems.add(SliderItem("https://ap.imagensbrasil.org/images/2019/12/12/65.jpg"))
        sliderItems.add(SliderItem("https://ap.imagensbrasil.org/images/2019/12/12/d252372c8131aa156bfdacc56861b4cd.jpg"))
        sliderItems.add(SliderItem(R.drawable.ic_apps_24))

        slide.setPages(sliderItems)

    }
}



