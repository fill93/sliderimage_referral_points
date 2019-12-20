package com.df.imageslider
import android.os.Parcelable
import android.view.View
import kotlinx.android.parcel.Parcelize


/**
 * check class builders SliderItem
 */
@Parcelize
data class SliderItem constructor(
    var title: String = "",
    var url: String? = null,
    var resID: Int = 0,
    var link : String = ""
    //var clickListener : ClickAction? = null
    //val act : () -> Unit
) : Parcelable {

    constructor(title: String, resID: Int): this(title, null, resID)

    constructor(title: String, url: String): this(title, url, 0)

    constructor(resID: Int): this("", null, resID)

    constructor(url: String): this("", url, 0)

//    constructor(title: String, resID: Int , link: String): this(title, null, resID,link)
//
    //constructor( url: String, link: String): this( "",url, link = link)
//
//    constructor(resID: Int, link: String): this("", null, resID)
//
//    constructor(url: String, link: String): this("", url, 0)

}