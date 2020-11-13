package com.onoh.checklistapp.data.local

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    var username:String? = null,
    var password:String? = null,
    var token:String? = null
):Parcelable