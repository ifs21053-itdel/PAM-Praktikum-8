package com.ifs21053.pampraktikum8;

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Kontak(
    var icon: Int,
    var name: String,
    var description: String,
) : Parcelable

