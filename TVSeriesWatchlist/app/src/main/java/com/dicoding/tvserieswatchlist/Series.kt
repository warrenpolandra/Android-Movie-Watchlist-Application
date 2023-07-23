package com.dicoding.tvserieswatchlist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Series(
    var name: String = "",
    var year: Int = 0,
    var genre: String = "",
    var detail: String = "",
    var photo: Int = 0,
    var rating: String = "0.0",
    var link: String = ""
) : Parcelable