package net.ezra.ui.products

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.delay
import kotlinx.coroutines.tasks.await
import net.ezra.R
import net.ezra.navigation.ROUTE_AMERICA
import net.ezra.navigation.ROUTE_CONTINENTS
import net.ezra.navigation.ROUTE_FLY
import net.ezra.navigation.ROUTE_HOME

data class Product(
    var id: String = "",
    val name: String = "",
    val quantity: String = "",
    val description: String ="",
    val price: Double = 0.0,
    var imageUrl: String = ""
)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(navController: NavController, products: List<Product>) {
    var isLoading by remember { mutableStateOf(true) }
    var productList by remember { mutableStateOf(emptyList<Product>()) }
    var displayedProductCount by remember { mutableStateOf(6) }
    var progress by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        fetchProducts(
            onSuccess = { fetchedProducts ->
                productList = fetchedProducts
                isLoading = false
            },
            onError = {
                isLoading = false
                // Handle the error, e.g., show a toast or a message
            }
        )

        // Simulate progress for loading state
        while (isLoading) {
            delay(100)
            progress = (progress + 1) % 101
        }
    }

    Scaffold(
        topBar = {
//            CenterAlignedTopAppBar(
//                title = { Text(text = "DESTINATIONS") },
//                navigationIcon = {
//                    IconButton(onClick = { navController.navigate(ROUTE_FLY) }) {
//                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
//                    }
//                },
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = Color.Transparent,
//                    titleContentColor = Color.White,
//                )
//            )
        }
    ) {

//        Box{
//            Image(painter = painterResource(id = R.drawable.bac),
//                contentDescription = null,
//                modifier = Modifier
//                    .fillMaxSize(),
//                contentScale = ContentScale.Crop
//            )
//        }
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

            Text(text = "DESTINATIONS"  ,
                modifier = Modifier
                    .padding(9.dp,14.dp,0.dp,0.dp),
                color = Color.White,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                fontFamily = FontFamily.Serif)

            Spacer(modifier = Modifier
                .width(60.dp))

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
        Column(
            modifier = Modifier
                .padding(0.dp,80.dp,0.dp,0.dp)
                .fillMaxSize()
//                .background(Color(0xff9AEDC9))
        ) {
            if (isLoading) {
                // Progress indicator
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(progress = progress / 100f)
                    Text(text = "Loading... $progress%", fontSize = 20.sp)
                }
            } else {
                if (productList.isEmpty()) {
                    // No products found
                    Text(text = "No destination found", modifier = Modifier.align(Alignment.CenterHorizontally))
                } else {
                    // Products list
                    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                        items(productList.take(displayedProductCount)) { product ->
                            ProductListItem(product) {
                                navController.navigate("productDetail/${product.id}")
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    // Load More Button
                    if (displayedProductCount < productList.size) {
                        Button(
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF0B0E0D)),
                            onClick = { displayedProductCount += 1 },
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        ) {
                            Text(text = "Load More",
                                color = Color.White)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProductListItem(product: Product, onItemClick: (String) -> Unit) {
    Column{
        Card (
            modifier = Modifier
                .padding(10.dp)
                .width(160.dp)
                .height(210.dp)
                .clickable { onItemClick(product.id) },
            shape = RoundedCornerShape(15.dp),

        ){

            Image(
                painter = rememberAsyncImagePainter(product.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column {
                Text(text = product.name, modifier = Modifier.align(Alignment.CenterHorizontally), color = Color.Transparent)
                Text(text = "Available seats: ${product.quantity}", modifier = Modifier.align(Alignment.CenterHorizontally), color = Color.Transparent)
                Text(text = "Ticket price in $: ${product.price}", modifier = Modifier.align(Alignment.CenterHorizontally), color = Color.Transparent)
            }
        }
        Spacer(modifier = Modifier.height(1.dp))
        Column {
            Text(text = product.name,
                modifier = Modifier
                    .padding(20.dp,0.dp,0.dp,0.dp)
                .align(Alignment.CenterHorizontally),
                fontSize = 20.sp,
                color = Color.Cyan)
            Text(text = " Seats: ${product.quantity}",
                fontSize = 15.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(18.dp,0.dp,0.dp,0.dp)
                    .align(Alignment.CenterHorizontally))
            Text(text = "Ticket price - $${product.price}",
                fontSize = 15.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(25.dp,0.dp,0.dp,0.dp)
                    .align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(15.dp))
        }


    }
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp)
//            .clickable { onItemClick(product.id) }
//    ) {
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = Modifier.padding(16.dp)
//        ) {
//            // Product Image
//            Image(
//                painter = rememberAsyncImagePainter(product.imageUrl),
//                contentDescription = null,
//                modifier = Modifier
//                    .size(60.dp)
//            )
//
//            Spacer(modifier = Modifier.width(16.dp))
//
//            // Product Details
//            Column {
//                Text(text = product.name)
//                Text(text = "Available seats:{product.quantity}")
//                Text(text = "Ticket price in $: ${product.price}")
//            }
//
//        }
//    }
}

@Suppress("DEPRECATION")
private suspend fun fetchProducts(onSuccess: (List<Product>) -> Unit, onError: () -> Unit) {
    val firestore = Firebase.firestore
    try {
        val snapshot = firestore.collection("destinations").get().await()
        val productList = snapshot.documents.mapNotNull { doc ->
            val product = doc.toObject<Product>()
            product?.id = doc.id
            product
        }
        onSuccess(productList)
    } catch (e: Exception) {
        onError()
    }
}

suspend fun fetchProduct(productId: String, onSuccess: (Product?) -> Unit) {
    val firestore = Firebase.firestore
    val docRef = firestore.collection("destinations").document(productId)
    val snapshot = docRef.get().await()
    val product = snapshot.toObject<Product>()
    onSuccess(product)
}
