package net.ezra

import android.content.Intent.ShortcutIconResource
import androidx.annotation.DrawableRes

data class AutoScrollingModel(
    @DrawableRes val iconResource: Int,
    val contentDescription: String
)

val autoScrollingList = listOf(
    AutoScrollingModel(R.drawable.tower, "Paris"),
    AutoScrollingModel(R.drawable.cardinal, "Italy"),
    AutoScrollingModel(R.drawable.beach, "Maldives"),
    AutoScrollingModel(R.drawable.china, "China"),
    AutoScrollingModel(R.drawable.brazil, "America"),
    AutoScrollingModel(R.drawable.wildlife, "Kenya")
)