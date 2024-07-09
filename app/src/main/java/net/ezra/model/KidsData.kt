package net.ezra.model

import net.ezra.R

data class KidsData (

    val title :String,
    val rating  :Float,
    val imgUri :Int

)

val kidsList = listOf(
    KidsData(
        title ="Diversity of Culture",
        rating = 4.0f,
        R.drawable.maasai
    ),
    KidsData(
        title ="Amazing infrastructure",
        rating = 4.0f,
        R.drawable.uk
    ),
    KidsData(
        title ="Serene Mothernature",
        rating = 4.0f,
        R.drawable.elephant
    ),
    KidsData(
        title ="Warm Sandy beaches",
        rating = 4.0f,
        R.drawable.beach
    ),
    KidsData(
        title ="Historical Monuments ",
        rating = 4.0f,
        R.drawable.pyriamid
    ),

)