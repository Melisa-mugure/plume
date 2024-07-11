package net.ezra.ui.australia

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
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_AMERICA
import net.ezra.navigation.ROUTE_CONTACT
import net.ezra.navigation.ROUTE_CONTINENTS
import net.ezra.navigation.ROUTE_FLY
import net.ezra.navigation.ROUTE_INSERT_PRODUCT

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Australia(navController: NavHostController){


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
                    .background(Color(0xFFF3FAFF))
            ){
                item{
                    Column()  {
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .height(58.dp)
                            .background(
                                Color(0xFF093A5A)
                            )){
                            IconButton(onClick = {
                                navController.navigate(ROUTE_CONTINENTS)
                            }) {
                                Icon(
                                    Icons.AutoMirrored.Filled.ArrowBack,
                                    "backIcon",
                                    tint = Color.White
                                )
                            }

                            Spacer(modifier = Modifier
                                .width(250.dp))

//
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
                            Spacer(modifier = Modifier
                                .width(3.dp))
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
                            } }

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .background(
                                Color(0xFF093A5A)
                            )){
                            Column{
                                Text(text = "ASIA'S",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily.Serif,
                                    color = Color.White
                                )
                                Spacer(modifier = Modifier
                                    .height(5.dp))
                                Text(text = "FINEST",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily.Serif,
                                    color = Color.White
                                )
                            }
                            Spacer(modifier = Modifier.width(25.dp))

//                            Column {
//                                Spacer(modifier = Modifier.height(10.dp))
//                                Icon(painter = painterResource(id = R.drawable.feather),
//                                    contentDescription = "",
//                                    tint = Color.Black,
//                                    modifier = Modifier
//                                        .padding(2.dp)
//                                        .height(100.dp)
//                                        .width(250.dp)
//                                )
//                            }
                        }

                        Row {
                            Column{
                                Card(
                                    modifier = Modifier
                                        .padding(10.dp)
                                        .width(160.dp)
                                        .height(210.dp),
                                    shape = CircleShape

                                ){
                                    Image(painter = painterResource(id = R.drawable.beach),
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
                                                tint = Color(0xFFFFFDF9),
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
                                    Column(verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier.width(140.dp)
                                    ){

                                        Text(text = "Indonesia",
                                            fontSize = 18.sp,
                                            color = Color.Black,
                                            fontWeight = FontWeight.Bold)
                                        Text(text = "    $35.00",
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
                                    Image(painter = painterResource(id = R.drawable.china),
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

                                        Text(text = "Thailand",
                                            fontSize = 18.sp,
                                            color = Color.Black,
                                            fontWeight = FontWeight.Bold)
                                        Text(text = "    $42.00",
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
                                    Image(painter = painterResource(id = R.drawable.faces),
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
                                                navController.navigate(ROUTE_FLY)
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

                                        Text(text = "Japan",
                                            fontSize = 18.sp,
                                            color = Color.Black,
                                            fontWeight = FontWeight.Bold)
                                        Text(text = "    $31.00",
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
                                    Image(painter = painterResource(id = R.drawable.rwanda),
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

                                        Text(text = "Malaysia",
                                            fontSize = 18.sp,
                                            color = Color.Black,
                                            fontWeight = FontWeight.Bold)
                                        Text(text = "    $29.00",
                                            fontSize = 15.sp,
                                            color = Color.Black,
                                            fontWeight = FontWeight.Light)
                                    }
                                }

                            }


                            Column(modifier = Modifier
                                .padding(5.dp,50.dp,0.dp,0.dp)
                            ){
                                Card(
                                    modifier = Modifier
                                        .padding(5.dp)
                                        .width(160.dp)
                                        .height(210.dp),
                                    shape = CircleShape

                                ){
                                    Image(painter = painterResource(id = R.drawable.canyon),
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

                                        Text(text = "Singapore",
                                            fontSize = 18.sp,
                                            color = Color.Black,
                                            fontWeight = FontWeight.Bold)
                                        Text(text = "    $41.00",
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
                                    Image(painter = painterResource(id = R.drawable.italy),
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

                                        Text(text = "South Korea",
                                            fontSize = 18.sp,
                                            color = Color.Black,
                                            fontWeight = FontWeight.Bold)
                                        Text(text = "    $37.00",
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
                                    Image(painter = painterResource(id = R.drawable.arch),
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

                                        Text(text = "China",
                                            fontSize = 18.sp,
                                            color = Color.Black,
                                            fontWeight = FontWeight.Bold)
                                        Text(text = "   $62.00",
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
                                        Text(text = "    $26.00",
                                            fontSize = 15.sp,
                                            color = Color.Black,
                                            fontWeight = FontWeight.Light)
                                    }
                                }
                                Spacer(modifier = Modifier
                                    .height(65.dp))
                            }
                        }
                    }
                }
            }

        },

        bottomBar = { net.ezra.ui.fly.BottomBar(navController = navController) }

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
    net.ezra.ui.australia.Australia(rememberNavController())
}