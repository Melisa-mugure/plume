package net.ezra.ui.home

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import net.ezra.navigation.ROUTE_CONTACT
import net.ezra.navigation.ROUTE_DASHBOARD
import net.ezra.navigation.ROUTE_FLY
import net.ezra.navigation.ROUTE_INSERT_PRODUCT
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_REGISTER
import net.ezra.navigation.ROUTE_SHOP
import net.ezra.navigation.ROUTE_SLIDERLAYOUT
import net.ezra.navigation.ROUTE_VIEW_PRODUCTS

@Composable
fun HomeScreen(navController: NavHostController) {
    Box (
    ){
        Image(painter = painterResource(id = R.drawable.backkk),
            contentDescription = null,
            modifier = Modifier.run {
                fillMaxWidth()
//                                        .blur(2.dp)
            },
            contentScale = ContentScale.Crop,

            )


        Column(
            modifier = Modifier
                .fillMaxSize()
            ,
            verticalArrangement = Arrangement.Center

        ){
            Column(modifier = Modifier
                .fillMaxWidth()
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center){
                Text(text = "PLUME",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.ExtraBold)
            }
            Spacer(modifier = Modifier.height(400.dp))
            Row{
                Column(modifier = Modifier
                    .fillMaxWidth()
                    ,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center){
                    Card  (
                        modifier = Modifier
                            .fillMaxSize()
                            .height(320.dp)
                            .width(300.dp)
                        ,
                        shape = RoundedCornerShape(140.dp,140.dp,0.dp,0.dp),

                        colors = CardDefaults.cardColors(Color(0x8FFFFFE6))
                    ){
                        Spacer(
                            modifier = Modifier
                                .height(35.dp))
                        Text(text = "Aviate, Navigate and",
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(1.dp),
                            fontSize = 25.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.Black
                        )
                        Text(text = "Explore the world",
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(1.dp),
                            fontSize = 25.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.Black
                        )


                        Spacer(modifier = Modifier.height(15.dp))

                        Text(text = "Get the best flight experience today!",
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally),
                            fontSize = 20.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Light,
                            color = Color.Black)
                        Text(text = "We guarantee the safest, fastest and most comfortable travel for our clients. ",
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally),
                            fontSize = 20.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Light,
                            color = Color.Black)
                        Spacer(modifier = Modifier.height(2.dp))

                        Icon(painter = painterResource(id = R.drawable.christmas),
                            contentDescription = "",
                            tint = Color.Black,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(2.dp)
                                .width(35.dp)
                        )

                        Spacer(modifier = Modifier.height(15.dp))
                        Row{

                            Button(onClick = {
                                navController.navigate(ROUTE_LOGIN)
                            },
                                modifier = Modifier
//                                    .align(Alignment.CenterHorizontally)
                                    .padding(5.dp)
                                    .height(45.dp)
                                    .width(165.dp),
                                colors = ButtonDefaults.buttonColors(Color(0xFF093A5A)),
                                shape = RoundedCornerShape(30.dp)
                            ) {

                                Text(text = "LOGIN",
                                )

                            }
                            Spacer(
                                modifier = Modifier
                                .width(28.dp))

                            Button(onClick = {
                                navController.navigate(ROUTE_REGISTER)
                            },
                                modifier = Modifier
//                                    .align(Alignment.CenterHorizontally)
                                    .padding(5.dp)
                                    .height(45.dp)
                                    .width(165.dp),
                                colors = ButtonDefaults.buttonColors(Color(0xFF093A5A)),
                                shape = RoundedCornerShape(30.dp)
                            ) {

                                Text(text = "REGISTER",
                                )

                            }
                        }
//                        Button(onClick = {
//                            navController.navigate(ROUTE_FLY)
//                        },
//                            modifier = Modifier
////                                    .align(Alignment.CenterHorizontally)
//                                .padding(5.dp)
//                                .height(45.dp)
//                                .width(165.dp),
//                            colors = ButtonDefaults.buttonColors(Color.Black),
//                            shape = RoundedCornerShape(30.dp)
//                        ) {
//
//                            Text(text = "Explore",
//                            )
//
//                        }
                    }


                }

            }

//Row {
//    Card (
//        modifier = Modifier
//        .fillMaxSize(),
//        colors = CardDefaults.cardColors(Color.Transparent)
//    )
//    {
//
//        Spacer(modifier = Modifier.height(35.dp))
//        Icon(Icons.AutoMirrored.Filled.ArrowForward,
//            contentDescription = null,
//            tint = Color.White,
//            modifier = Modifier
//                .size(40.dp)
//                .padding(4.dp)
//                .clickable {
//                    navController.navigate(ROUTE_DESTINATION)
//                }
//                .align(Alignment.End)
//                .background(Color.Black))
//
//    }
//}


        }


    }

}

@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    HomeScreen(rememberNavController())
}
