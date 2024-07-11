package net.ezra.ui.fly

import android.annotation.SuppressLint
import android.graphics.PorterDuff
import android.widget.RatingBar
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield
import net.ezra.R
import net.ezra.model.kidsList
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_AMERICA
import net.ezra.navigation.ROUTE_CONTACT
import net.ezra.navigation.ROUTE_CONTINENTS
import net.ezra.navigation.ROUTE_FLY
import net.ezra.navigation.ROUTE_INSERT_PRODUCT
import net.ezra.navigation.ROUTE_VIEW_PRODUCTS




@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Fly(navController: NavHostController){
    val images = listOf(
        R.drawable.maasai,
        R.drawable.uk,
        R.drawable.elephant,
        R.drawable.beach,

        )
//
//    val pagerState = rememberPagerState (pageCount = {images.size}
//
//    )
//    LaunchedEffect(Unit) {
//        while (true){
//            delay(2600)
//            val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
//            pagerState.scrollToPage(nextPage)
//        }
//    }
    val pagerState = rememberPagerState(
        pageCount = { kidsList.size},
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
    val scope = rememberCoroutineScope()

    var text by remember { mutableStateOf("")}
    var active by remember { mutableStateOf(false)}
    var items = remember {
        mutableStateListOf(
            "Europe",
            "Africa"
        )
    }


    Scaffold(
        topBar = {
//            TopAppBar(
//                title = {
//                    Text(text = "Top App Bar")
//                },
//                navigationIcon = {
//                    IconButton(onClick = {}) {
//                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "backIcon")
//                    }
//                },
//
//                )
        }, content = {
            Box{
                Image(painter = painterResource(id = R.drawable.setttt),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFFFFFFF))
            ){
                item{
                    Column()
                    {

                        Row (modifier = Modifier
                            .fillMaxWidth()
                            .height(58.dp)
                            .background(
                                Color(0xFF093A5A)
                            )){
                            Card(
                                modifier = Modifier
                                    .size(43.dp)
                                    .padding(5.dp),
                                shape = CircleShape

                            ){
                                Image(painter = painterResource(id = R.drawable.plume),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,

                                    modifier = Modifier
                                        .fillMaxSize()
//                                        .align(Alignment.CenterHorizontally)
                                       ,
                                    )
                            }

                            Spacer(modifier = Modifier.width(15.dp))

                            Text(text = "Welcome"  ,
                                modifier = Modifier
                                    .padding(9.dp,14.dp,0.dp,0.dp),
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Serif)

                            Spacer(modifier = Modifier
                                .width(195.dp))
                            Icon(painter = painterResource(id = R.drawable.location ),
                                contentDescription = "",
                                tint = Color.White,
                                modifier = Modifier
                                    .padding(5.dp)
                                    .width(27.dp)
                                    .clickable {
                                        navController.navigate(ROUTE_CONTINENTS)
                                    },
                            )
                        }
                        Row(modifier = Modifier
                            .height(70.dp)
                            .background(
                                Color(0xFF093A5A)
                            ))
                        {
                            Column {
                                Text(text = "Discover the Best Place",
                                    modifier = Modifier
                                        .padding(2.dp),
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 21.sp,
                                    fontFamily = FontFamily.Serif)
                                Text(text = "To Travel",
                                    modifier = Modifier
                                        .padding(2.dp),
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 21.sp,
                                    fontFamily = FontFamily.Serif)

                            }


                            Spacer(modifier = Modifier
                                .width(210.dp))


//                            Icon(painter = painterResource(id = R.drawable.location ),
//                                contentDescription = "",
//                                tint = Color.Black,
//                                modifier = Modifier
//                                    .padding(5.dp)
//                                    .width(29.dp)
//                                    .clickable {
//                                        navController.navigate(ROUTE_CONTINENTS)
//                                    },
//                            )
//                            Spacer(modifier = Modifier
//                                .width(3.dp))
                            Card(
                                modifier = Modifier
                                    .size(43.dp)
                                    .padding(5.dp),
                                shape = CircleShape

                            ){
                                Image(painter = painterResource(id = R.drawable.queen),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,

                                    modifier = Modifier
                                        .fillMaxSize()
//                                        .align(Alignment.CenterHorizontally)
                                        .clickable {
                                            navController.navigate(ROUTE_AMERICA)
                                        },


                                    )
                            }
                            Spacer(modifier = Modifier
                                .width(3.dp))

                            Icon(imageVector = Icons.Default.LocationOn, contentDescription = "")
                        }

                        Row (modifier = Modifier
                            .fillMaxWidth()
                            .height(118.dp)
                            .background(
                                Color(0xFF093A5A)
                            )){

                            SearchBar(
                                modifier = Modifier.fillMaxWidth()
                                   ,
                                query = text,
                                onQueryChange = {
                                    text = it
                                },
                                onSearch = {
                                    items.add(text)
                                    active = false
                                    text = ""

                                },
                                active = active,
                                onActiveChange = {
                                    active = it
                                },
                                placeholder = {
                                    Text (text = "Search destination")
                                },
                                leadingIcon = {
                                    Icon(imageVector = Icons.Default.Search, contentDescription = "")
                                },
                                trailingIcon = {
                                    if (active){
                                        Icon(
                                            modifier = Modifier
                                                .clickable{
                                                    if (text.isNotEmpty()){
                                                        text = ""
                                                    }else{
                                                        active = false
                                                    }

                                                }
                                            ,
                                            imageVector = Icons.Default.Close,
                                            contentDescription = "")
                                    }

                                }
                            ) {
                                items.forEach{
                                    Row(modifier = Modifier.padding(all = 14.dp)){
                                        Icon(
                                            modifier = Modifier
                                                .padding(end = 10.dp),
                                            imageVector = Icons.Default.Refresh,
                                            contentDescription ="" )
                                        Text(text = it)

                                    }
                                }

                            }
                        }




//                        Column(modifier = Modifier.fillMaxSize()){
//                            HorizontalPager(state = pagerState,
//                                modifier = Modifier
//                                    .weight(1f)
//                                    .padding(0.dp, 40.dp, 0.dp, 40.dp))
//                            {page ->
//                                Card(modifier = Modifier
//                                    .fillMaxSize()
//                                    .graphicsLayer {
//
//                                    }
//                                    .padding(25.dp, 0.dp, 25.dp, 0.dp)
//                                    .padding(10.dp)
//                                    .height(270.dp)
//                                    .width(380.dp),
////                                    elevation = CardDefaults.cardElevation(8.dp),
//                                    shape = RoundedCornerShape(50.dp, 50.dp, 50.dp, 50.dp),
//
//                                ){
//
//                                    val newKids = kidsList[page]
//                                    Box(modifier = Modifier
//                                        .fillMaxSize()
//                                        .background(Color.LightGray)
//                                        .align(Alignment.CenterHorizontally)
//                                    )
//                                    {
//                                        Image(painter = painterResource(
//                                            id = newKids.imgUri
//                                        ),
//                                            contentDescription = "Image",
//                                            contentScale = ContentScale.Crop,
//                                            modifier = Modifier.fillMaxSize()
//                                        )
//                                        Column (modifier = Modifier
//                                            .align(Alignment.BottomStart)
//                                            .padding(15.dp)){
//                                            Text(
//                                                text = newKids.title,
//                                                style = MaterialTheme.typography.h5,
//                                                color = Color.White,
//                                                fontWeight = FontWeight.Bold
//                                            )
//                                            val ratingBar = RatingBar(
//                                                LocalContext.current,null, com.google.android.material.R.attr.ratingBarStyleSmall
//                                            ).apply {
//                                                rating=newKids.rating
//                                                progressDrawable.setColorFilter(
//                                                    android.graphics.Color.parseColor("#FFF000"),
//                                                    PorterDuff.Mode.SRC_ATOP
//                                                )
//                                            }
//                                            AndroidView(factory = { ratingBar },
//                                                modifier = Modifier.padding(0.dp,8.dp,0.dp,8.dp)
//                                            )
//
//
//                                        }
//
//                                    }
//                                }
//                            }
//
//
//                        }

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

                                    androidx.compose.material3.    Card(modifier = Modifier
                                        .fillMaxSize()
                                        .graphicsLayer {

                                        }
                                        .padding(5.dp, 0.dp, 5.dp, 0.dp)
                                        .padding(10.dp)
                                        .height(270.dp)
                                        .width(410.dp),
//                                    elevation = CardDefaults.cardElevation(8.dp),
                                        shape = RoundedCornerShape(50.dp, 50.dp, 50.dp, 50.dp),

                                        ){

                                        val newKids = kidsList[currentPage]
                                        Box(modifier = Modifier
                                            .fillMaxSize()
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
                                    IconButton(
                                        onClick = {
                                                  val nextPage = pagerState.currentPage + 1
                                            if (nextPage < kidsList.size){
                                                scope.launch {
                                                    pagerState.scrollToPage(nextPage)
                                                }
                                            }
                                        },
                                        modifier = Modifier
                                            .padding(30.dp)
                                            .size(48.dp)
                                            .align(Alignment.CenterEnd)
                                            .clip(CircleShape),
                                        colors = IconButtonDefaults.iconButtonColors(
                                            containerColor = Color(0x70373737)
                                        )

                                    ) {
                                        Icon(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = null,
                                            modifier = Modifier.fillMaxSize(),
                                        tint = Color.LightGray)

                                    }
                                    IconButton(
                                        onClick = {
                                            val prevPage = pagerState.currentPage - 1
                                            if (prevPage >= 0){
                                            scope.launch {
                                                pagerState.scrollToPage(prevPage)
                                            }
                                        }},
                                        modifier = Modifier
                                            .padding(30.dp)
                                            .size(48.dp)
                                            .align(Alignment.CenterStart)
                                            .clip(CircleShape),
                                        colors = IconButtonDefaults.iconButtonColors(
                                            containerColor = Color(0x70373737)
                                        )

                                    ) {
                                        Icon(imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = null,
                                            modifier = Modifier.fillMaxSize(),
                                            tint = Color.LightGray)

                                    }
                                }
                            }
                            PageIndicator(
                                pageCount = kidsList.size,
                                currentPage = pagerState.currentPage,
                                modifier = Modifier
                            )

                        }

//
//                        LazyRow {
//                            item {
//                                Card ( modifier = Modifier
//                                    .padding(10.dp)
//                                    .height(250.dp)
//                                    .width(270.dp),
//
//                                    shape = RoundedCornerShape(50.dp, 50.dp, 50.dp, 50.dp),
//                                )
//                                {
//                                    Image(painter = painterResource(id = R.drawable.maasai),
//                                        contentDescription = null,
//                                        contentScale = ContentScale.Crop,
//                                        modifier = Modifier
//                                            .fillMaxSize()
//
//                                    )
//
//                                    Text(text = "DIVERSITY OF CULTURE",
//                                        color = Color.White,
//                                        fontSize = 20.sp,
//                                        fontFamily = FontFamily.SansSerif,
//                                        modifier = Modifier
//                                            .padding(5.dp,210.dp,0.dp,0.dp)
//
//                                    )
//                                }
//                                Card ( modifier = Modifier
//                                    .padding(10.dp)
//                                    .height(250.dp)
//                                    .width(270.dp),
//                                    shape = RoundedCornerShape(50.dp, 50.dp, 50.dp, 50.dp),
//                                )
//                                {
//                                    Image(painter = painterResource(id = R.drawable.uk),
//                                        contentDescription = null,
//                                        contentScale = ContentScale.Crop,
//                                        modifier = Modifier
//                                            .fillMaxSize()
//
//                                    )
//                                    Text(text = "AMAZING INFRASTRUCTURE",
//                                        color = Color.White,
//                                        fontSize = 20.sp,
//                                        fontFamily = FontFamily.SansSerif,
//                                        modifier = Modifier
//                                            .padding(5.dp,210.dp,0.dp,0.dp)
//
//                                    )
//                                }
//                                Card ( modifier = Modifier
//                                    .padding(10.dp)
//                                    .height(250.dp)
//                                    .width(270.dp),
//                                    shape = RoundedCornerShape(50.dp, 50.dp, 50.dp, 50.dp),
//                                )
//                                {
//                                    Image(painter = painterResource(id = R.drawable.elephant),
//                                        contentDescription = null,
//                                        contentScale = ContentScale.Crop,
//                                        modifier = Modifier
//                                            .fillMaxSize()
//
//                                    )
//                                    Text(text = "SERENE MOTHER NATURE",
//                                        color = Color.White,
//                                        fontSize = 20.sp,
//                                        fontFamily = FontFamily.SansSerif,
//                                        modifier = Modifier
//                                            .padding(5.dp,210.dp,0.dp,0.dp)
//
//                                    )
//                                }
//
//                                Card ( modifier = Modifier
//                                    .padding(10.dp)
//                                    .height(250.dp)
//                                    .width(270.dp),
//                                    shape = RoundedCornerShape(50.dp, 50.dp, 50.dp, 50.dp),
//                                )
//                                {
//                                    Image(painter = painterResource(id = R.drawable.beach),
//                                        contentDescription = null,
//                                        contentScale = ContentScale.Crop,
//                                        modifier = Modifier
//                                            .fillMaxSize()
//
//                                    )
//                                    Text(text = "WARM SANDY BEACHES",
//                                        color = Color.White,
//                                        fontSize = 20.sp,
//                                        fontFamily = FontFamily.SansSerif,
//                                        modifier = Modifier
//                                            .padding(5.dp,210.dp,0.dp,0.dp)
//
//                                    )
//                                }
//                            }
//
//                        }
//                        Row {
//                            Column{
//                                Text(text = "I would ",
//                                    color = Color(0xFF010F2B),
//                                    fontFamily = FontFamily.Monospace,
////                                    fontWeight = FontWeight.Bold,
//                                    fontSize = 16.sp
//                                )
//                                Text(text = "Like to Visit... ",
//                                    color = Color(0xFF010F2B),
//                                    fontFamily = FontFamily.Monospace,
//                                    fontWeight = FontWeight.ExtraBold,
//                                    fontSize = 16.sp
//                                )
//                            }
//
//
//                            Spacer(modifier = Modifier
//                                .width(102.dp))
//                            Icon(painter = painterResource(id = R.drawable.christmas),
//                                contentDescription = "",
//                                tint = Color.Black,
//                                modifier = Modifier
//                                    .width(25.dp)
//                            )
//                            Icon(painter = painterResource(id = R.drawable.feather),
//                                contentDescription = "",
//                                tint = Color.Black,
//                                modifier = Modifier
//                                    .width(25.dp)
//                            )
//                            Icon(painter = painterResource(id = R.drawable.christmas),
//                                contentDescription = "",
//                                tint = Color.Black,
//                                modifier = Modifier
//                                    .width(25.dp)
//                            )
//                        }
//                        Spacer(modifier = Modifier
//                            .height(10.dp))
//
//                        Row {
//                            Column {
//                                Card(
//                                    modifier = Modifier
//                                        .size(50.dp),
//                                    shape = CircleShape
//
//                                ){
//                                    Image(painter = painterResource(id = R.drawable.america),
//                                        contentDescription = null,
//                                        contentScale = ContentScale.Crop,
//
//                                        modifier = Modifier
//                                            .fillMaxSize()
//                                            .align(Alignment.CenterHorizontally)
//                                            .clickable {
//                                                navController.navigate(ROUTE_AMERICA)
//                                            },
//
//
//                                        )
//                                }
//
//                                Text(text = " America",
//                                    fontWeight = FontWeight.Bold,
//                                    modifier = Modifier
//                                        .align(Alignment.CenterHorizontally)
//
//                                )
//                            }
//                            Spacer(modifier = Modifier
//                                .width(45.dp))
//                            Column {
//                                Card(
//                                    modifier = Modifier
//                                        .size(50.dp),
//                                    shape = CircleShape
//
//                                ){
//                                    Image(painter = painterResource(id = R.drawable.europe),
//                                        contentDescription = null,
//                                        contentScale = ContentScale.Crop,
//
//                                        modifier = Modifier
//                                            .fillMaxSize()
//                                            .align(Alignment.CenterHorizontally)
//                                            .clickable {
//                                                navController.navigate(ROUTE_EUROPE)
//                                            },
//
//                                        )
//                                }
//
//                                Text(text = " Europe",
//                                    fontWeight = FontWeight.Bold,
//                                    modifier = Modifier
//                                        .align(Alignment.CenterHorizontally)
//                                )
//                            }
//                            Spacer(modifier = Modifier
//                                .width(45.dp))
//
//                            Column {
//                                Card(
//                                    modifier = Modifier
//                                        .size(50.dp),
//                                    shape = CircleShape
//
//                                ){
//                                    Image(painter = painterResource(id = R.drawable.africa),
//                                        contentDescription = null,
//                                        contentScale = ContentScale.Crop,
//
//                                        modifier = Modifier
//                                            .fillMaxSize()
//                                            .align(Alignment.CenterHorizontally)
//                                            .clickable {
//                                                navController.navigate(ROUTE_AFRICA)
//                                            },
//
//                                        )
//                                }
//
//                                Text(text = " Africa",
//                                    fontWeight = FontWeight.Bold,
//                                    modifier = Modifier
//                                        .align(Alignment.CenterHorizontally)
//
//                                )
//                            }
//                            Spacer(modifier = Modifier
//                                .width(45.dp))
//                            Column {
//                                Card(
//                                    modifier = Modifier
//                                        .size(50.dp),
//                                    shape = CircleShape
//
//                                ){
//                                    Image(painter = painterResource(id = R.drawable.asia),
//                                        contentDescription = null,
//                                        contentScale = ContentScale.Crop,
//
//                                        modifier = Modifier
//                                            .fillMaxSize()
//                                            .align(Alignment.CenterHorizontally)
//                                            .clickable {
//                                                navController.navigate(ROUTE_AUSTRALIA)
//                                            },
//
//                                        )
//                                }
//
//                                Text(text = " Asia",
//                                    fontWeight = FontWeight.Bold,
//                                    modifier = Modifier
//                                        .align(Alignment.CenterHorizontally)
//
//                                )
//                            }
//
//                        }
                        Spacer(modifier = Modifier
                            .height(15.dp))
                        Row{
//
//                            Button(onClick = {
//                                navController.navigate(ROUTE_INSERT_PRODUCT)
//                            },
//                                modifier = Modifier
////                                    .align(Alignment.CenterHorizontally)
//                                    .padding(5.dp)
//                                    .height(55.dp)
//                                    .width(165.dp),
//                                colors = ButtonDefaults.buttonColors(Color.Black),
//                                shape = RoundedCornerShape(30.dp)
//                            ) {
//
//                                Text(text = "INSERT DESTINATION",
//                                )
//
//                            }
//                            Spacer(
//                                modifier = Modifier
//                                    .width(28.dp))

                            Button(onClick = {
                                navController.navigate(ROUTE_VIEW_PRODUCTS)
                            },
                                modifier = Modifier
//                                    .align(Alignment.CenterHorizontally)
                                    .padding(13.dp,0.dp,3.dp,0.dp)
                                    .height(38.dp)
                                    .width(328.dp),
                                colors = ButtonDefaults.buttonColors(Color.Black),
                                shape = RoundedCornerShape(30.dp)
                            ) {
                                Column{
                                    Text(text = "VIEW DESTINATION",
                                        fontSize = 16.sp
                                    )

                                }



                            }
                        }
                        Spacer(modifier = Modifier
                            .height(15.dp))

                        Text(text = "POPULAR DESTINATIONS",
                            color = Color(0xFF010F2B),
                            fontStyle = FontStyle.Italic,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 16.sp,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )


                        Row {
                            Column{
                                Card(
                                    modifier = Modifier
                                        .padding(10.dp)
                                        .width(160.dp)
                                        .height(210.dp),
                                    shape = CircleShape

                                ){
                                    Image(painter = painterResource(id = R.drawable.brazil),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale = ContentScale.Crop

                                    )
                                    Row(
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.Bottom
                                    ){
                                        Button(
                                            onClick = {
                                                navController.navigate(ROUTE_INSERT_PRODUCT)
                                            },
                                            modifier = Modifier
                                                .padding(0.dp, 0.dp, 0.dp, 0.dp)
                                                .width(100.dp)
                                                .height(40.dp),
                                            colors = ButtonDefaults.buttonColors(Color(0xFF323235)),
                                            shape = RoundedCornerShape(100.dp)
                                        ) {

                                            Text(
                                                text = "LIKE",
                                                color = Color.White,
                                                fontSize =14.sp
                                            )
                                            Spacer(modifier = Modifier.width(3.dp))

                                            Icon(painter = painterResource(id = R.drawable.love),
                                                contentDescription = "",
                                                tint = Color.White,
                                                modifier = Modifier
                                                    .padding(2.dp)
                                                    .height(40.dp)
                                                    .width(100.dp)
                                            )

                                        }

                                    }
                                }
                                Box(modifier = Modifier
                                    .align(Alignment.CenterHorizontally),
                                )
                                {
                                    Column(
                                    ){

                                        Text(text = "Brazil",
                                            fontSize = 18.sp,
                                            color = Color.Black,
                                            fontWeight = FontWeight.Bold)
                                        Text(text = "   $65.00",
                                            fontSize = 15.sp,
                                            color = Color.Black,
                                            fontWeight = FontWeight.Light)
                                    }
                                }
                                Spacer(modifier = Modifier
                                    .height(20.dp))

                                Card(
                                    modifier = Modifier
                                        .padding(10.dp)
                                        .width(160.dp)
                                        .height(210.dp),
                                    shape = CircleShape

                                ){
                                    Image(painter = painterResource(id = R.drawable.germany),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale = ContentScale.Crop

                                    )
                                    Row(
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.Bottom
                                    ){
                                        Button(
                                            onClick = {
                                                navController.navigate(ROUTE_INSERT_PRODUCT)
                                            },
                                            modifier = Modifier
                                                .padding(0.dp, 0.dp, 0.dp, 0.dp)
                                                .width(100.dp)
                                                .height(40.dp),
                                            colors = ButtonDefaults.buttonColors(Color(0xFF323235)),
                                            shape = RoundedCornerShape(100.dp)
                                        ) {

                                            Text(
                                                text = "LIKE",
                                                color = Color.White,
                                                fontSize =14.sp
                                            )
                                            Spacer(modifier = Modifier.width(3.dp))

                                            Icon(painter = painterResource(id = R.drawable.love),
                                                contentDescription = "",
                                                tint = Color.White,
                                                modifier = Modifier
                                                    .padding(2.dp)
                                                    .height(40.dp)
                                                    .width(100.dp)
                                            )

                                        }

                                    }
                                }
                                Box(modifier = Modifier
                                    .align(Alignment.CenterHorizontally),
                                )
                                {
                                    Column(
                                    ){

                                        Text(text = "Germany",
                                            fontSize = 18.sp,
                                            color = Color.Black,
                                            fontWeight = FontWeight.Bold)
                                        Text(text = "   $58.00",
                                            fontSize = 15.sp,
                                            color = Color.Black,
                                            fontWeight = FontWeight.Light)
                                    }
                                }
                                Spacer(modifier = Modifier
                                    .height(20.dp))

                                Card(
                                    modifier = Modifier
                                        .padding(10.dp)
                                        .width(160.dp)
                                        .height(210.dp),
                                    shape = CircleShape

                                ){
                                    Image(painter = painterResource(id = R.drawable.jaguar),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale = ContentScale.Crop

                                    )
                                    Row(
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.Bottom
                                    ){
                                        Button(
                                            onClick = {
                                                navController.navigate(ROUTE_INSERT_PRODUCT)
                                            },
                                            modifier = Modifier
                                                .padding(0.dp, 0.dp, 0.dp, 0.dp)
                                                .width(100.dp)
                                                .height(40.dp),
                                            colors = ButtonDefaults.buttonColors(Color(0xFF323235)),
                                            shape = RoundedCornerShape(100.dp)
                                        ) {

                                            Text(
                                                text = "LIKE",
                                                color = Color.White,
                                                fontSize =14.sp
                                            )
                                            Spacer(modifier = Modifier.width(3.dp))

                                            Icon(painter = painterResource(id = R.drawable.love),
                                                contentDescription = "",
                                                tint = Color.White,
                                                modifier = Modifier
                                                    .padding(2.dp)
                                                    .height(40.dp)
                                                    .width(100.dp)
                                            )

                                        }

                                    }
                                }
                                Box(modifier = Modifier
                                    .align(Alignment.CenterHorizontally),
                                )
                                {
                                    Column(
                                    ){

                                        Text(text = "Phillipines",
                                            fontSize = 18.sp,
                                            color = Color.Black,
                                            fontWeight = FontWeight.Bold)
                                        Text(text = "  $26.00",
                                            fontSize = 15.sp,
                                            color = Color.Black,
                                            fontWeight = FontWeight.Light)
                                    }
                                }
                                Spacer(modifier = Modifier
                                    .height(20.dp))


                            }


                            Column(modifier = Modifier
                                .padding(5.dp,5.dp,0.dp,0.dp)
                            ){
                                Spacer(modifier = Modifier.height(20.dp))
                                Card(
                                    modifier = Modifier
                                        .padding(5.dp)
                                        .width(160.dp)
                                        .height(210.dp),
                                    shape = CircleShape

                                ){
                                    Image(painter = painterResource(id = R.drawable.tower),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale = ContentScale.Crop

                                    )
                                    Row(
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.Bottom
                                    ){
                                        Button(
                                            onClick = {
                                                navController.navigate(ROUTE_INSERT_PRODUCT)
                                            },
                                            modifier = Modifier
                                                .padding(0.dp, 0.dp, 0.dp, 0.dp)
                                                .width(100.dp)
                                                .height(40.dp),
                                            colors = ButtonDefaults.buttonColors(Color(0xFF323235)),
                                            shape = RoundedCornerShape(100.dp)
                                        ) {

                                            Text(
                                                text = "LIKE",
                                                color = Color.White,
                                                fontSize =14.sp
                                            )
                                            Spacer(modifier = Modifier.width(3.dp))

                                            Icon(painter = painterResource(id = R.drawable.love),
                                                contentDescription = "",
                                                tint = Color.White,
                                                modifier = Modifier
                                                    .padding(2.dp)
                                                    .height(40.dp)
                                                    .width(100.dp)
                                            )

                                        }

                                    }
                                }
                                Box(modifier = Modifier
                                    .align(Alignment.CenterHorizontally),
                                )
                                {
                                    Column(
                                    ){

                                        Text(text = "France",
                                            fontSize = 18.sp,
                                            color = Color.Black,
                                            fontWeight = FontWeight.Bold)
                                        Text(text = "  $62.00",
                                            fontSize = 15.sp,
                                            color = Color.Black,
                                            fontWeight = FontWeight.Light)
                                    }
                                }
                                Spacer(modifier = Modifier
                                    .height(45.dp))

                                Card(
                                    modifier = Modifier
                                        .padding(5.dp)
                                        .width(160.dp)
                                        .height(210.dp),
                                    shape = CircleShape

                                ){
                                    Image(painter = painterResource(id = R.drawable.south),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )
                                    Row(
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.Bottom
                                    ){
                                        Button(
                                            onClick = {
                                                navController.navigate(ROUTE_INSERT_PRODUCT)
                                            },
                                            modifier = Modifier
                                                .padding(0.dp, 0.dp, 0.dp, 0.dp)
                                                .width(100.dp)
                                                .height(40.dp),
                                            colors = ButtonDefaults.buttonColors(Color(0xFF323235)),
                                            shape = RoundedCornerShape(100.dp)
                                        ) {

                                            Text(
                                                text = "LIKE",
                                                color = Color.White,
                                                fontSize =14.sp
                                            )
                                            Spacer(modifier = Modifier.width(3.dp))

                                            Icon(painter = painterResource(id = R.drawable.love),
                                                contentDescription = "",
                                                tint = Color.White,
                                                modifier = Modifier
                                                    .padding(2.dp)
                                                    .height(40.dp)
                                                    .width(100.dp)
                                            )

                                        }

                                    }
                                }
                                Box(modifier = Modifier
                                    .align(Alignment.CenterHorizontally),
                                )
                                {
                                    Column(
                                    ){

                                        Text(text = "South Africa",
                                            fontSize = 18.sp,
                                            color = Color.Black,
                                            fontWeight = FontWeight.Bold)
                                        Text(text = "  $22.00",
                                            fontSize = 15.sp,
                                            color = Color.Black,
                                            fontWeight = FontWeight.Light)
                                    }
                                }
                                Spacer(modifier = Modifier
                                    .height(45.dp))

                                Card(
                                    modifier = Modifier
                                        .padding(5.dp)
                                        .width(160.dp)
                                        .height(210.dp),
                                    shape = CircleShape

                                ){
                                    Image(painter = painterResource(id = R.drawable.tue),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale = ContentScale.Crop

                                    )
                                    Row(
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.Bottom
                                    ){
                                        Button(
                                            onClick = {
                                                navController.navigate(ROUTE_INSERT_PRODUCT)
                                            },
                                            modifier = Modifier
                                                .padding(0.dp, 0.dp, 0.dp, 0.dp)
                                                .width(100.dp)
                                                .height(40.dp),
                                            colors = ButtonDefaults.buttonColors(Color(0xFF323235)),
                                            shape = RoundedCornerShape(100.dp)
                                        ) {

                                            Text(
                                                text = "LIKE",
                                                color = Color.White,
                                                fontSize =14.sp
                                            )
                                            Spacer(modifier = Modifier.width(3.dp))

                                            Icon(painter = painterResource(id = R.drawable.love),
                                                contentDescription = "",
                                                tint = Color.White,
                                                modifier = Modifier
                                                    .padding(2.dp)
                                                    .height(40.dp)
                                                    .width(100.dp)
                                            )

                                        }

                                    }
                                }
                                Box(modifier = Modifier
                                    .align(Alignment.CenterHorizontally),
                                )
                                {
                                    Column(
                                    ){

                                        Text(text = "United States",
                                            fontSize = 18.sp,
                                            color = Color.Black,
                                            fontWeight = FontWeight.Bold)
                                        Text(text = "  $72.00",
                                            fontSize = 15.sp,
                                            color = Color.Black,
                                            fontWeight = FontWeight.Light)
                                    }
                                }
                                Spacer(modifier = Modifier
                                    .height(60.dp))


                            }
                        }
                    }
                }
            }

        },

        bottomBar = {BottomBar(navController = navController)}

    )


}

@Composable
fun PageIndicator(pageCount: Int, currentPage: Int, modifier: Modifier) {

    Row (horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier){
        repeat(pageCount){
            IndicatorDots(isSelected = it == currentPage,modifier = Modifier)
        }

    }
}

@Composable
fun IndicatorDots(isSelected: Boolean, modifier: Modifier.Companion) {
    val size = animateDpAsState(targetValue = if (isSelected) 12.dp else 10.dp, label = "")
    Box(modifier = Modifier
        .padding(2.dp)
        .size(size.value)
        .clip(CircleShape)
        .background(if (isSelected) Color(0xff373737) else Color(0xff373747)))

}


@Composable
fun BottomBar(navController: NavHostController) {

    val selectedIndex = remember { mutableStateOf(0) }

    BottomNavigation(
        backgroundColor = Color(0xFF7C9AAD)
        ,
        elevation = 10.dp) {

        BottomNavigationItem(
            icon = {
            Icon(imageVector = Icons.Default.Home,"", tint = Color.White
            )
        },
            label = { Text(text = "Home",color = Color.White) },
            selected = (selectedIndex.value == 0),
            onClick = {
               navController.navigate(ROUTE_FLY)
            },)

        BottomNavigationItem(icon = {
            Icon(painter = painterResource(id = R.drawable.location ),
                contentDescription = "", tint = Color.White,
                modifier = Modifier
                    .width(25.dp)
                    .height(20.dp))
        },
            label = { Text(text = "Explore",color = Color.White) },
            selected = (selectedIndex.value == 1),
            onClick = {
                navController.navigate(ROUTE_CONTINENTS)
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.DateRange,"",tint = Color.White,)
        },
            label = { Text(text = "About", color = Color.White) },
            selected = (selectedIndex.value == 2),
            onClick = {
                navController.navigate(ROUTE_ABOUT)
            }
        )
        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.ShoppingCart,"",tint = Color.White,)
        },
            label = { Text(text = "Add", color = Color.White) },
            selected = (selectedIndex.value == 2),
            onClick = {
                navController.navigate(ROUTE_INSERT_PRODUCT)
            }
        )
        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.MailOutline,"",tint = Color.White,)
        },
            label = { Text(text = "Query", color = Color.White) },
            selected = (selectedIndex.value == 2),
            onClick = {
                navController.navigate(ROUTE_CONTACT)
            }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    Fly(rememberNavController())
}