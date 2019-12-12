package com.df.imageslider
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.slide_content.view.*
import java.util.ArrayList

class ImageSlider(mContext: Context, attrs: AttributeSet) : ConstraintLayout(mContext, attrs) {

    private val sliderItems = ArrayList<SliderItem>()
    private lateinit var mSectionsPagerAdapter: SliderAdapter

    private var dots: MutableList<TextView> = mutableListOf()
    private var activeDotPos = 0

    private val pageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
        override fun onPageScrollStateChanged(state: Int) {}

        override fun onPageSelected(position: Int) {
            switchDots(position, activeDotPos)
            activeDotPos = position
        }
    }

    // Configurable dot settings
    private var selectedDotColor = Color.WHITE
    private var dotColor = Color.parseColor("#40ffffff")
    private var dotSize = 25f
    private var selectedDotSize = 30f

    init {
        init(attrs)
    }

    private fun init(attrs: AttributeSet) {
        val root = View.inflate(context, R.layout.slide_content, this)
        // TODO - Atrrs
    }

    private fun initDots() {
        destroyView()
        pager.addOnPageChangeListener(pageChangeListener)

        val visibility = if (sliderItems.isNotEmpty()) View.VISIBLE else View.GONE

        dotsLayout.visibility = visibility

        for (i in 0 until sliderItems.size) {
            val tv = TextView(context)
            dots.add(tv)

            dots[i].text = "\u2022"


            if (i != 0) {
                dots[i].setTextColor(dotColor)
                dots[i].textSize = dotSize

            } else {
                dots[i].setTextColor(selectedDotColor)
                dots[i].textSize = selectedDotSize
            }

            dotsLayout.addView(dots[i])
        }
    }

    private fun switchDots(position: Int, activeDotPos: Int) {
        if (position != activeDotPos && dotsLayout.visibility == View.VISIBLE) {
            val oldPosition = dotsLayout.getChildAt(activeDotPos) as TextView
            val newPosition = dotsLayout.getChildAt(position) as TextView

            oldPosition.textSize = dotSize
            newPosition.textSize = selectedDotSize
            oldPosition.setTextColor(dotColor)
            newPosition.setTextColor(selectedDotColor)
        }
    }

    private fun destroyView() {
        dotsLayout.removeAllViews()
        dots.clear()
        pager.removeOnPageChangeListener(pageChangeListener)
        activeDotPos = 0
    }

    /*
    *******************************
    *     Public methods
    *******************************
    */

    /**
     * Receive image list List<SliderItem>
     */
    fun setPages(sliderItems: List<SliderItem>) {
        this.sliderItems.clear()
        this.sliderItems.addAll(sliderItems)

        mSectionsPagerAdapter = SliderAdapter(context, sliderItems)

        if (sliderItems.isNotEmpty()) {
            pager.adapter = mSectionsPagerAdapter
            pager.offscreenPageLimit = sliderItems.size
        }

        initDots()
    }

    fun showDots() {
        dotsLayout.visibility = View.VISIBLE
    }

    fun hideDots() {
        dotsLayout.visibility = View.GONE
    }

}
