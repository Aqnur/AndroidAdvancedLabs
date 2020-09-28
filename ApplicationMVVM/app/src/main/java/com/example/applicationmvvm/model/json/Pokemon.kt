package com.example.applicationmvvm.model.json

import com.google.gson.annotations.SerializedName

data class Pokemon (
    @SerializedName("id") val id : Int,
    @SerializedName("num") val num : Int,
    @SerializedName("name") val name : String,
    @SerializedName("img") val img : String,
    @SerializedName("type") val type : List<String>,
    @SerializedName("height") val height : String,
    @SerializedName("weight") val weight : String,
    @SerializedName("candy") val candy : String,
    @SerializedName("candy_count") val candy_count : Int,
    @SerializedName("egg") val egg : String,
    @SerializedName("spawn_chance") val spawn_chance : Double,
    @SerializedName("avg_spawns") val avg_spawns : Int,
    @SerializedName("spawn_time") val spawn_time : String,
    @SerializedName("multipliers") val multipliers : List<Double>,
    @SerializedName("weaknesses") val weaknesses : List<String>,
    @SerializedName("next_evolution") val next_evolution : List<Next_evolution>

)

data class Next_evolution (

    @SerializedName("num") val num : Int,
    @SerializedName("name") val name : String
)

data class PokemonResponse(
    val total_count: Int,
    val incomplete_results: Boolean,
    val items: List<Pokemon>
)