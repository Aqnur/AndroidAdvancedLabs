package com.example.applicationmvvm.model.json

import com.google.gson.annotations.SerializedName

data class Item (
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("img") val img : String
)

data class Next_evolution (
    @SerializedName("num") val num : Int,
    @SerializedName("name") val name : String
)