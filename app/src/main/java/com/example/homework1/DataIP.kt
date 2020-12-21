package com.example.homework1

import com.google.gson.annotations.SerializedName

//{"ip": "109.184.86.130"}

data class DataIP(
    @SerializedName(value = "ip")
    val ip: String
)
