package com.doni.uas

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class TVShowResponse(
    @SerializedName("results") val tvshowes : List<TVShow>
) : Parcelable {
    constructor() : this(mutableListOf())
}