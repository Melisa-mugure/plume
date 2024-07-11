package net.ezra.ui.about

import android.annotation.SuppressLint
import android.content.res.Configuration
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.AutoScrollingList
import net.ezra.R
import net.ezra.autoScrollingList
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_AFRICA
import net.ezra.navigation.ROUTE_AMERICA
import net.ezra.navigation.ROUTE_AUSTRALIA
import net.ezra.navigation.ROUTE_CONTACT
import net.ezra.navigation.ROUTE_CONTINENTS
import net.ezra.navigation.ROUTE_EUROPE
import net.ezra.navigation.ROUTE_FLY
import net.ezra.navigation.ROUTE_HOME


@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AboutScreen(navController: NavHostController) {
//Column (modifier = Modifier.fillMaxSize(),
//    horizontalAlignment = Alignment.CenterHorizontally,
//    verticalArrangement = Arrangement.Center) {
//    AutoScrollingList(autoScrollingList)
//
//}
//
//
//
//
//
//}
//
//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
//@Composable
//fun HomeScreenPreviewLight() {
//    AboutScreen(rememberNavController())
//}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AboutScreen(navController: NavHostController){

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
//            )
        }, content = {
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(58.dp)
                .background(
                    Color(0xFF093A5A)
                )){
                IconButton(onClick = {
                    navController.navigate(ROUTE_FLY)
                }) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        "backIcon",
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier
                    .width(250.dp))

//                                Icon(painter = painterResource(id = R.drawable.location ),
//                                    contentDescription = "",
//                                    tint = Color.Black,
//                                    modifier = Modifier
//                                        .padding(5.dp)
//                                        .width(29.dp)
//                                        .clickable {
//                                            navController.navigate(ROUTE_CONTINENTS)
//                                        },
//                                )
                Spacer(modifier = Modifier
                    .width(3.dp))
                Card(
                    modifier = Modifier
                        .size(46.dp)
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
                } }
            Column (  modifier = Modifier
                .padding(135.dp,65.dp,0.dp,0.dp)
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
                ){
                Text(text = "ABOUT US",
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color =  Color(0xFF093A5A))
            }
            Column (  modifier = Modifier
                .padding(18.dp,95.dp,10.dp,0.dp)
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Text(text = "Welcome to Plume, your go-to destination for all your flight review needs." +
                        "Our mission is to make air travel accessible, affordable and convenient for everyone.",
                    fontSize = 17.sp,
                    fontStyle = FontStyle.Normal,
                    fontFamily = FontFamily.SansSerif,
//                    fontWeight = FontWeight.Bold,
                    color =  Color.Black)
            }
            Column (  modifier = Modifier
                .padding(130.dp,205.dp,0.dp,0.dp)
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Text(text = "What We Offer",
                    fontSize = 18.sp,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color =  Color(0xFF093A5A))
            }
            Row (  modifier = Modifier
                .padding(101.dp,228.dp,0.dp,0.dp)
                ,
//                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Text(text = "Wide Range of Flights",
                    fontSize = 17.sp,
                    fontStyle = FontStyle.Normal,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color =  Color.Black)
//                Text(text = "We partner with major airlines around the globe to offer you a vast selection of flights at competitive prices",
//                    fontSize = 17.sp,
//                    fontStyle = FontStyle.Normal,
//                    fontFamily = FontFamily.SansSerif,
////                    fontWeight = FontWeight.Bold,
//                    color =  Color.Black)
            }
            Row (  modifier = Modifier
                .padding(101.dp,248.dp,0.dp,0.dp)
                ,
//                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Text(text = "Easy Booking Process",
                    fontSize = 17.sp,
                    fontStyle = FontStyle.Normal,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color =  Color.Black)
//                Text(text = "We partner with major airlines around the globe to offer you a vast selection of flights at competitive prices",
//                    fontSize = 17.sp,
//                    fontStyle = FontStyle.Normal,
//                    fontFamily = FontFamily.SansSerif,
////                    fontWeight = FontWeight.Bold,
//                    color =  Color.Black)
            }
            Row (  modifier = Modifier
                .padding(101.dp,267.dp,0.dp,0.dp)
                ,
//                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Text(text = "24/7 Customer Support",
                    fontSize = 17.sp,
                    fontStyle = FontStyle.Normal,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color =  Color.Black)
//                Text(text = " Our dedicated team is always ready to assist you with any queries or issues you many have.",
//                    fontSize = 17.sp,
//                    fontStyle = FontStyle.Normal,
//                    fontFamily = FontFamily.SansSerif,
////                    fontWeight = FontWeight.Bold,
//                    color =  Color.Black)
            }
            Column (  modifier = Modifier
                .padding(141.dp,310.dp,0.dp,0.dp)
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Text(text = "Our Vision",
                    fontSize = 18.sp,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color =  Color(0xFF093A5A))
            }
            Spacer(modifier = Modifier.height(13.dp))
            Column (  modifier = Modifier
                .padding(22.dp,330.dp,6.dp,0.dp)
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Text(text = "We aim to provide our customers with seamless  and enjoyable travel experiences." +
                        "We aim to connect people to new places,cultures and experiences through our comprehensive flight options and exceptional customer service.",
                    fontSize = 17.sp,
                    fontStyle = FontStyle.Normal,
                    fontFamily = FontFamily.SansSerif,
//                    fontWeight = FontWeight.Bold,
                    color =  Color.Black)
            }
            Column (  modifier = Modifier
                .padding(78.dp,463.dp,0.dp,0.dp)
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Text(text = "Join Us on Our Journey",
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color =  Color(0xFF093A5A))
            }
            Column (  modifier = Modifier
                .padding(124.dp,492.dp,0.dp,0.dp)
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Text(text = "Let's Visit ...",
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color =  Color(0xFF093A5A))
            }
            Column (  modifier = Modifier
                .width(500.dp)
                .height(750.dp)
                .padding(0.dp, 547.dp, 0.dp, 0.dp)
                .background(
                    Color(0xFF093A5A)
                ),
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Text(text = "ABOUT US",
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color =  Color(0xFF093A5A))
            }
//            Column (  modifier = Modifier
//                .width(30.dp)
//                .height(750.dp)
//                .padding(0.dp,55.dp,0.dp,0.dp)
//                .background(
//                    Color(0xFF093A5A)
//                ),
//                horizontalAlignment = Alignment.CenterHorizontally,
//            ){
//                Text(text = "ABOUT US",
//                    fontSize = 20.sp,
//                    fontStyle = FontStyle.Italic,
//                    fontFamily = FontFamily.SansSerif,
//                    fontWeight = FontWeight.Bold,
//                    color =  Color(0xFF093A5A))
//            }
            Column (  modifier = Modifier
                .width(30.dp)
                .height(750.dp)
                .padding(60.dp, 55.dp, 0.dp, 0.dp)
                .background(
                    Color(0xFF093A5A)
                ),
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Text(text = "ABOUT US",
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color =  Color(0xFF093A5A))
            }








            Column (
                modifier = Modifier.padding(0.dp,547.dp,0.dp,0.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Bottom)
            {
                AutoScrollingList(autoScrollingList)
            }



        },

        bottomBar = { BottomBar(navController = navController) }

    )










}
@Composable
fun BottomBar(navController: NavHostController) {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(
        backgroundColor = Color(0xFF7C9AAD)
        ,
        elevation = 10.dp) {

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Home,"", tint = Color.White
            )
        },
            label = { Text(text = "Home",color = Color.White) },
            selected = (selectedIndex.value == 0),
            onClick = {
                navController.navigate(ROUTE_FLY)
            })

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
            Icon(imageVector = Icons.Default.MailOutline,"",tint = Color.White,)
        },
            label = { Text(text = "Contact", color = Color.White) },
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
   AboutScreen(rememberNavController())
}

