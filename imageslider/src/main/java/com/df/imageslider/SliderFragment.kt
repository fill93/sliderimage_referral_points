package com.df.imageslider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class SliderFragment : Fragment() {

    companion object {
        private const val KEY_ITEM = "KEY_ITEM"
        private const val KEY_POSITION = "KEY_POSITION"

        fun newInstance(item: SliderItem, position: Int) = SliderFragment().apply {
            arguments = Bundle().apply {
                putParcelable(KEY_ITEM, item)
                putInt(KEY_POSITION, position)
            }
        }
    }

    private var item: SliderItem? = null

    private var position = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = arguments?.getParcelable(KEY_ITEM)
        position = arguments?.getInt(KEY_POSITION) ?: 0
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.slide_item_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        if (item != null) {
//            val slide = item as SliderItem
//
//            if (slide.title.isNotBlank()) {
//                titl.text = slide.title
//                title.visibility = View.VISIBLE
//            } else {
//                title.visibility = View.GONE
//            }
//
//            if (slide.resID != 0) {
//                Glide.with(view.context)
//                    .load(slide.resID)
//                    .into(img)
//            }
//
//            if (slide.url != null) {
//                Glide.with(view.context)
//                    .load(slide.url)
//                    .into(img)
//            }
//        }
    }

//    fun showTitle() {
//        title?.visibility = View.VISIBLE
//    }
//
//    fun hideTitle() {
//        title?.visibility = View.GONE
//    }
}

