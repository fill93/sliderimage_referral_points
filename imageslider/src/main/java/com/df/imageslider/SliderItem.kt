package com.df.imageslider
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/**
 * check class builders SliderItem
 */
@Parcelize
data class SliderItem constructor(
    var title: String,
    var url: String? = null,
    var resID: Int = 0
) : Parcelable {

    constructor(title: String, resID: Int): this(title, null, resID)

    constructor(title: String, url: String): this(title, url, 0)

    constructor(resID: Int): this("", null, resID)

    constructor(url: String): this("", url, 0)

}