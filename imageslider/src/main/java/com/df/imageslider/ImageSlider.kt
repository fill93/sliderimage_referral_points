package com.df.imageslider
import android.content.ActivityNotFoundException
import android.content.Context
import android.graphics.Color
import android.os.Handler
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.slide_content.view.*
import java.util.*


class ImageSlider(mContext: Context, attrs: AttributeSet) : ConstraintLayout(mContext, attrs) , CallOnClickSlider {

    private val sliderItems = ArrayList<SliderItem>()
    private lateinit var mSectionsPagerAdapter: SliderAdapter

    private var dots: MutableList<TextView> = mutableListOf()
    private var activeDotPos = 0

    lateinit var timer : Timer
    private var current_position = 0
    lateinit var callOnClickSlider: CallOnClickSlider

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
     * RECEIVE IMAGE LIST List<SliderItem>
     *      @param sliderItems List with objects of type SliderItem
     */
    fun setPages(sliderItems: List<SliderItem> , idErroImage : Int = 0 ) {
        this.sliderItems.clear()
        this.sliderItems.addAll(sliderItems)

        mSectionsPagerAdapter = SliderAdapter(context, sliderItems, idErroImage , this)

        if (sliderItems.isNotEmpty()) {
            pager.adapter = mSectionsPagerAdapter
            pager.offscreenPageLimit = sliderItems.size
        }
        initDots()
    }

    /**
     * THIS FUNCTION AUTOMATICALLY ANIMATES THE IMAGE SLIDE
     *      @param timeScroll It's the time it takes for the auto scroll to pass the slide
     */
    fun handleAnimate(timeScroll : Long){
        val handle = Handler()
        val runnable = Runnable{
            if(current_position == sliderItems.size){
                current_position = 0
            }
            pager.setCurrentItem(current_position++,true)
        }

        timer = Timer()
        timer.schedule( object : TimerTask() {
            override fun run() {
                handle.post(runnable)
            }
        },1000,timeScroll)

    }

    /**
     * SHOW CURRENT POSITION REFERENCE POINTS
     */
    fun showDots() {
        dotsLayout.visibility = View.VISIBLE
    }

    /**
     * HIDES CURRENT POSITION REFERENCE POINTS
     */
    fun hideDots() {
        dotsLayout.visibility = View.GONE
    }

    /**
     * SET CALLBACK
     */
    fun actionSetCall(callOnClickSlider: CallOnClickSlider ){
        this.callOnClickSlider = callOnClickSlider
    }

    override fun onClickSlider(item: SliderItem) {
        this.callOnClickSlider.onClickSlider(item)
    }



}
