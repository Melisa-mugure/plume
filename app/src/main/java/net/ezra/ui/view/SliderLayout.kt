package net.ezra.ui.view

import android.graphics.PorterDuff
import android.icu.util.IslamicCalendar.CalculationType
import android.widget.RatingBar
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize.Fill.calculateMainAxisPageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import net.ezra.R
import net.ezra.model.kidsList
import net.ezra.ui.home.HomeScreen
import kotlin.math.absoluteValue


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ViewerPagerSlider(navController: NavHostController){
    val pagerState = rememberPagerState(
        pageCount = {kidsList.size},
        initialPage = 2)

    LaunchedEffect(Unit) {
        while (true){
            yield()
            delay(2000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount),
                animationSpec = tween(600)
            )
        }

    }
    Column{
     HorizontalPager(state = pagerState,
         modifier = Modifier
             .weight(1f)
             .padding(0.dp, 40.dp, 0.dp, 40.dp))
     {page ->
         Card(modifier = Modifier
             .graphicsLayer {

             }
             .fillMaxWidth()
             .padding(25.dp, 0.dp, 25.dp, 0.dp),
             shape = RoundedCornerShape(20.dp)
         ){

             val newKids = kidsList[page]
             Box(modifier = Modifier
//                 .fillMaxSize()
                 .background(Color.LightGray)
                 .align(Alignment.CenterHorizontally)
             )
             {
                 Image(painter = painterResource(
                     id = newKids.imgUri
                 ),
                     contentDescription = "Image",
                     contentScale = ContentScale.Crop,
                     modifier = Modifier.fillMaxSize()
                     )
                 Column (modifier = Modifier
                     .align(Alignment.BottomStart)
                     .padding(15.dp)){
                     Text(
                         text = newKids.title,
                         style = MaterialTheme.typography.h5,
                         color = Color.White,
                         fontWeight = FontWeight.Bold
                     )
                     val ratingBar = RatingBar(
                         LocalContext.current,null, com.google.android.material.R.attr.ratingBarStyleSmall
                     ).apply {
                         rating=newKids.rating
                         progressDrawable.setColorFilter(
                             android.graphics.Color.parseColor("#FFF000"),
                             PorterDuff.Mode.SRC_ATOP
                         )
                     }
                     AndroidView(factory = { ratingBar },
                         modifier = Modifier.padding(0.dp,8.dp,0.dp,8.dp)
                     )


                 }

             }
         }
     }


      }

    }

@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    ViewerPagerSlider(rememberNavController())
}