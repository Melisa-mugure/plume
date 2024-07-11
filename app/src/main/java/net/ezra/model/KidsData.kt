package net.ezra.model

import net.ezra.R

data class KidsData (

    val title :String,
    val rating  :Float,
    val imgUri :Int

)

val kidsList = listOf(
    KidsData(
        title ="Serene Mothernature",
        rating = 4.0f,
        R.drawable.elephant
    ),
    KidsData(
        title ="Amazing infrastructure",
        rating = 4.0f,
        R.drawable.uk
    ),
    KidsData(
        title ="Warm Sandy beaches",
        rating = 4.0f,
        R.drawable.beach
    ),
    KidsData(
        title ="Diversity of culture",
        rating = 4.0f,
        R.drawable.maasai
    ),
    KidsData(
        title ="Historical Monuments ",
        rating = 4.0f,
        R.drawable.pyriamid
    ),

)