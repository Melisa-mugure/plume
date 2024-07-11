package net.ezra.ui.continents

import android.annotation.SuppressLint
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
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_AFRICA
import net.ezra.navigation.ROUTE_AMERICA
import net.ezra.navigation.ROUTE_AUSTRALIA
import net.ezra.navigation.ROUTE_CONTACT
import net.ezra.navigation.ROUTE_CONTINENTS
import net.ezra.navigation.ROUTE_EUROPE
import net.ezra.navigation.ROUTE_FLY

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Continents(navController: NavHostController){
    var search by remember { mutableStateOf(TextFieldValue("")) }

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
            Box{
//                Image(painter = painterResource(id = R.drawable.setttt),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .fillMaxSize(),
//                    contentScale = ContentScale.Crop
//                )

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFFFFFFF))
                ){
                    item{
                        Column {
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
                                Spacer(modifier = Modifier.width(55.dp))

                                androidx.compose.material.Text(
                                    text = "CONTINENTS",
                                    modifier = Modifier
                                        .padding(9.dp, 14.dp, 0.dp, 0.dp),
                                    color = Color.White,
                                    fontStyle = FontStyle.Italic,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 17.sp,
                                    fontFamily = FontFamily.Serif
                                )

                                Spacer(modifier = Modifier
                                    .width(75.dp))

//            Spacer(modifier = Modifier
//                .width(250.dp))

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
//            Spacer(modifier = Modifier
//                .width(3.dp))
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

//                            Spacer(modifier = Modifier
//                                .height(10.dp))
//
//
//                            Row (modifier = Modifier
//                                    .fillMaxWidth()
//                                .height(38.dp)
//                                .background(
//                                    Color.White
//                                )){
//                                Text(text = "CONTINENTS",
//                                    modifier = Modifier.padding(100.dp,0.dp,0.dp,0.dp),
////                                        .align(Alignment.CenterHorizontally),
//                                    color = (   Color(0xFF093A5A)),
//                                    fontSize = 20.sp,
//                                    fontWeight = FontWeight.Bold,
//                                    fontFamily = FontFamily.Serif,
//                                    fontStyle = FontStyle.Italic)
//                            }

//                            Spacer(modifier = Modifier.height(8.dp))
//                            Row{
//                                Spacer(modifier = Modifier.width(45.dp))
//                                OutlinedTextField(
//                                    leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
//                                    label = { androidx.compose.material.Text("Search Continent") },
//                                    colors = OutlinedTextFieldDefaults.colors(
//                                        focusedBorderColor = Color.Black,
//                                        unfocusedBorderColor = Color.Black,
//                                        focusedTextColor = Color.Cyan,
//                                        unfocusedTextColor = Color.Green,
//                                        focusedLabelColor = Color.Magenta,
//                                        unfocusedLabelColor = Color.Cyan
//
//
//
//                                    ),
//                                    value = search,
//                                    onValueChange = {search = it},
//                                    modifier = Modifier
//                                        .width(280.dp)
//                                        .background(Color.Transparent),
//                                )
//                            }

                            Spacer(modifier = Modifier
                                .height(1.dp))


                            Card(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth()
                                    .height(210.dp)
                                    .clickable {
                                        navController.navigate(ROUTE_AMERICA)
                                    },
                                shape = RoundedCornerShape(25.dp)

                            ){

                                Image(painter = painterResource(id = R.drawable.tue),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                                Row{
                                    Card(
                                        modifier = Modifier
                                            .padding(5.dp, 3.dp, 0.dp, 0.dp)
                                            .size(25.dp),
                                        shape = CircleShape

                                    ){
                                        Image(painter = painterResource(id = R.drawable.america),
                                            contentDescription = null,
                                            contentScale = ContentScale.Crop,

                                            modifier = Modifier
                                                .fillMaxSize()
//                                                .align(Alignment.CenterHorizontally)
                                                .clickable {
                                                    navController.navigate(ROUTE_AMERICA)
                                                },


                                            )
                                    }

                                }
                                Text(text = "AMERICA",
                                    color = Color.White,
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily.SansSerif,
                                    modifier = Modifier
                                        .padding(5.dp,180.dp,0.dp,0.dp))
                            }
                            Spacer(modifier = Modifier.height(7.dp))


                            Card(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth()
                                    .height(210.dp)
                                    .clickable {
                                        navController.navigate(ROUTE_EUROPE)
                                    },
                                shape = RoundedCornerShape(25.dp)

                            ){
                                Image(painter = painterResource(id = R.drawable.germany),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                                Row{
                                    Card(
                                        modifier = Modifier
                                            .padding(5.dp, 3.dp, 0.dp, 0.dp)
                                            .size(25.dp),
                                        shape = CircleShape

                                    ){
                                        Image(painter = painterResource(id = R.drawable.europe),
                                            contentDescription = null,
                                            contentScale = ContentScale.Crop,

                                            modifier = Modifier
                                                .fillMaxSize()
//                                                .align(Alignment.CenterHorizontally)
                                                .clickable {
                                                    navController.navigate(ROUTE_AMERICA)
                                                },


                                            )
                                    }

                                }
                                Text(text = "EUROPE",
                                    color = Color.White,
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily.SansSerif,
                                    modifier = Modifier
                                        .padding(5.dp,180.dp,0.dp,0.dp))
                            }
                            Spacer(modifier = Modifier.height(7.dp))


                            Card(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth()
                                    .height(210.dp)
                                    .clickable {
                                        navController.navigate(ROUTE_AFRICA)
                                    },
                                shape = RoundedCornerShape(25.dp)

                            ){
                                Image(painter = painterResource(id = R.drawable.wildlife),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                                Row{
                                    Card(
                                        modifier = Modifier
                                            .padding(5.dp, 3.dp, 0.dp, 0.dp)
                                            .size(25.dp),
                                        shape = CircleShape

                                    ){
                                        Image(painter = painterResource(id = R.drawable.africa),
                                            contentDescription = null,
                                            contentScale = ContentScale.Crop,

                                            modifier = Modifier
                                                .fillMaxSize()
//                                                .align(Alignment.CenterHorizontally)
                                                .clickable {
                                                    navController.navigate(ROUTE_AMERICA)
                                                },


                                            )
                                    }

                                }
                                Text(text = "AFRICA",
                                color = Color.White,
                                fontSize = 20.sp,
                                fontFamily = FontFamily.SansSerif,
                                modifier = Modifier
                                    .padding(5.dp,180.dp,0.dp,0.dp))
                            }
                            Spacer(modifier = Modifier.height(7.dp))


                            Card(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth()
                                    .height(210.dp)
                                    .clickable {
                                        navController.navigate(ROUTE_AUSTRALIA)
                                    },
                                shape = RoundedCornerShape(25.dp)

                            ){
                                Image(painter = painterResource(id = R.drawable.china),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                                Row{
                                    Card(
                                        modifier = Modifier
                                            .padding(5.dp, 3.dp, 0.dp, 0.dp)
                                            .size(25.dp),
                                        shape = CircleShape

                                    ){
                                        Image(painter = painterResource(id = R.drawable.asia),
                                            contentDescription = null,
                                            contentScale = ContentScale.Crop,

                                            modifier = Modifier
                                                .fillMaxSize()
//                                                .align(Alignment.CenterHorizontally)
                                                .clickable {
                                                    navController.navigate(ROUTE_AMERICA)
                                                },


                                            )
                                    }

                                }
                                Text(text = "ASIA",
                                    color = Color.White,
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily.SansSerif,
                                    modifier = Modifier
                                        .padding(5.dp,180.dp,0.dp,0.dp))
                            }

                            Spacer(modifier = Modifier.height(72.dp))

                        }
                    }
                }



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
    Continents(rememberNavController())
}