package com.example.homework1

import com.google.gson.annotations.SerializedName
//{
//   "date": "12-20-2020",
//   "milliseconds_since_epoch": 1608450713043,
//   "time": "07:51:53 AM"
//}
data class DataDate(
    @SerializedName(value = "date")
    val date: String,

    @SerializedName(value = "milliseconds_since_epoch")
    val millisecondsSinceEpoch: Long,

    @SerializedName(value = "time")
    val time: String
)
