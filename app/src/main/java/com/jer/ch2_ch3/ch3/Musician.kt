package com.jer.ch2_ch3.ch3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Musician(
    var username : String,
    var photoProfil: String,
): Parcelable
