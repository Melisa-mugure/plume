package net.ezra.ui.shop

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.currentComposer
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import net.ezra.R
import net.ezra.ui.contact.ContactScreen



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShopScreen(navController: NavHostController,){
    val images = listOf(
        R.drawable.maasai,
        R.drawable.uk,
        R.drawable.elephant,
        R.drawable.beach,

    )
    val pagerState = rememberPagerState (pageCount = {images.size}

    )
    LaunchedEffect(Unit) {
        while (true){
            delay(2000)
            val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
            pagerState.scrollToPage(nextPage)
        }
    }


    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally)
    {

    Box(modifier = Modifier.wrapContentSize()){
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .wrapContentSize()

        )
        { currentPage->

            Card ( modifier = Modifier
                .wrapContentSize()
                .padding(26.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Image(painter = painterResource(id = images[currentPage]), contentDescription = "")
            }
        }


    }

    }


}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    ShopScreen(rememberNavController())
}
