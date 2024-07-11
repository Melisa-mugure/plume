package net.ezra.ui.products

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
import androidx.compose.foundation.shape.CircleShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Scaffold
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import net.ezra.R
import net.ezra.navigation.ROUTE_AMERICA
import net.ezra.navigation.ROUTE_FLY
import net.ezra.navigation.ROUTE_VIEW_PRODUCTS


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(navController: NavController, productId: String) {

    var product by remember { mutableStateOf<Product?>(null) }

    LaunchedEffect(Unit) {
        fetchProduct(productId) { fetchedProduct ->
            product = fetchedProduct
        }
    }

    Scaffold(
        topBar = {
//            CenterAlignedTopAppBar(
//                title = {
//                    // Display the product name if available
//                    Text(
//                        text = product?.name ?:"Details",
//                        fontSize = 20.sp,
//                        color = Color.White
//                    )
//                },
//                navigationIcon = {
//                    IconButton(onClick = {
//                        navController.navigate(ROUTE_VIEW_PRODUCTS)
//                    }) {
//                        Icon(
//                            Icons.AutoMirrored.Filled.ArrowBack,
//                            "backIcon",
//                            tint = Color.Black
//                        )
//                    }
//                },
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = Color.Transparent,
//                    titleContentColor = Color.Black,
//                )
//            )
        },
        content = {
//            Box{
//                Image(painter = painterResource(id = R.drawable.bac),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .fillMaxSize(),
//                    contentScale = ContentScale.Crop
//                )
//            }

            Row(modifier = Modifier
                .fillMaxWidth()
                .height(58.dp)
                .background(
                    Color(0xFF093A5A)
                )){
                IconButton(onClick = {
                    navController.navigate(ROUTE_VIEW_PRODUCTS)
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
                androidx.compose.material.Card(
                    modifier = Modifier
                        .size(46.dp)
                        .padding(5.dp),
                    shape = CircleShape

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.plume),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,

                        modifier = Modifier
                            .fillMaxSize()
//                                        .align(Alignment.CenterHorizontally)
                            ,


                        )
                }
            }

            Column(
                modifier = Modifier
                    .padding(0.dp,40.dp,0.dp,0.dp)
                    .fillMaxSize()
                    .background(
                Color(0x2A093A56)
            )
            ) {
                product?.let {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Card(
                            modifier = Modifier
                                .padding(25.dp, 20.dp, 0.dp, 0.dp)
                                .height(310.dp)
                                .width(280.dp)
                            ,
                            shape = CircleShape,
                            colors = CardDefaults.cardColors(Color(0x8FFFFFE5))
                        ){
                            Image(
                                painter = rememberAsyncImagePainter(it.imageUrl),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .align(Alignment.CenterHorizontally),
                                contentScale = ContentScale.Crop
                            )
                        }

                        Spacer(modifier = Modifier.height(50.dp))

                        Text(text = it.name,
                            modifier = Modifier
                                .padding(1.dp),
                            fontSize = 30.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.ExtraBold,
                                color =   Color(0xFF093A5A),)

                        Spacer(modifier = Modifier.height(22.dp))

                        Row{
                            Text(text = it.description,
                                modifier = Modifier
                                    .padding(1.dp),
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.ExtraLight,
                                color = Color.Black)
                        }

                        Spacer(modifier = Modifier.height(35.dp))

                        androidx.compose.material3.Text(text = "Timelines",
                            modifier = Modifier
//                                                .align(Alignment.CenterHorizontally)
                            .padding(1.dp),
                            fontSize = 15.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.Black)

                        Spacer(modifier = Modifier.height(5.dp))

                        Row {
                            Text(text = "Early-Morning",color =   Color(0xFF093A5A),)
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(text = "Mid-Morning",color =   Color(0xFF093A5A))
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(text = "Afternoon",color =    Color(0xFF093A5A),)
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(text = "Evening",color =   Color(0xFF093A5A))

                        }


                        Spacer(modifier = Modifier.height(45.dp))

                        Row{Text(text = "Ticket Price",
                            modifier = Modifier
//                                                .align(Alignment.CenterHorizontally)
                            .padding(1.dp),
                            fontSize = 20.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.Black)
                            Spacer(modifier = Modifier.width(140.dp))
                            Text(text = "Seats",
                                modifier = Modifier
//                                                .align(Alignment.CenterHorizontally)
                                .padding(1.dp),
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.Black)
                        }


                        Row{

                            Text(text = " $${it.price}",
                                modifier = Modifier
//                                                .align(Alignment.CenterHorizontally)
                                    .padding(1.dp),
                                fontSize = 25.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.Black)

                            Spacer(modifier = Modifier.width(200.dp))
                            Text(text = it.quantity,
                                modifier = Modifier
//                                                .align(Alignment.CenterHorizontally)
                                    .padding(1.dp),
                                fontSize = 25.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.Black)
                        }



                    }
                }
            }
        }
    )
}

