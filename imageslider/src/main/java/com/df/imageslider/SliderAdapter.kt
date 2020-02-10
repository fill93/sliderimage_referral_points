package com.df.imageslider
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.slide_item_container.view.*

class SliderAdapter(private val context: Context, private val sliderItems: List<SliderItem> , private val erroImage : Int , private val callOnClickSlider: CallOnClickSlider) : PagerAdapter() {

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layout = LayoutInflater.from(context).inflate(R.layout.slide_item_container, container, false)
        container.addView(layout)

        val slide = sliderItems[position]

        if (slide.title.isNotBlank()) {
            layout.title_a.text = slide.title
            layout.title_a.visibility = View.VISIBLE
        } else {
            layout.title_a.visibility = View.GONE
        }

        if (slide.resID != 0) {
            Glide.with(context)
                .load(slide.resID)
                .apply(RequestOptions().error(erroImage).centerInside())
                .into(layout.img_a)
        }

        if (slide.url != null) {
            Glide.with(context)
                .load(slide.url)
                .apply(RequestOptions().error(erroImage).centerInside())
                .into(layout.img_a)
        }

        layout.setOnClickListener {
            callOnClickSlider.onClickSlider(slide)
        }

        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }

    override fun getCount() = sliderItems.size
}

