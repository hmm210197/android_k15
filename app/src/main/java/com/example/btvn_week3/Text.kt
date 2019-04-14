package com.example.btvn_week3

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Text (var tex : String, var col : Int) : Parcelable