package net.ezra.ui.contact

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_CONTACT
import net.ezra.navigation.ROUTE_FLY
import net.ezra.navigation.ROUTE_INSERT_PRODUCT
import net.ezra.ui.dashboard.MiniFabItems
import java.util.UUID



@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ContactScreen(navController: NavController, onProductAdded: () -> Unit) {
    var productName by remember { mutableStateOf("") }
    var productDescription by remember { mutableStateOf("") }
    var productPrice by remember { mutableStateOf("") }
    var productQuantity by remember { mutableStateOf("") }
//    var productImageUri by remember { mutableStateOf<Uri?>(null) }

    var productNameError by remember { mutableStateOf(false) }
    var productDescriptionError by remember { mutableStateOf(false) }
    var productPriceError by remember { mutableStateOf(false) }
    var productQuantityError by remember { mutableStateOf(false) }
//    var productImageError by remember { mutableStateOf(false) }

    var isUploading by remember { mutableStateOf(false) }




//    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
//        uri?.let {
//            productImageUri = it
//        }
//    }

    Box{
//        Image(painter = painterResource(id = R.drawable.setttt),
//            contentDescription = null,
//            modifier = Modifier
//                .fillMaxSize(),
//            contentScale = ContentScale.Crop
//        )
    }

    Scaffold (modifier = Modifier

        .fillMaxSize(),
        floatingActionButton = {
            net.ezra.ui.dashboard.MainUI(navController = navController)
        }
    ) {

    }



    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color(0x7C093A5A)
            )
            .padding(0.dp)
    ) {

        item {
//            if (productImageUri != null) {
//            Image(
//                painter = rememberAsyncImagePainter(productImageUri),
//                contentDescription = null,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp)
//            )
//        }
//            else {
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(200.dp),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Text("No Image Selected", modifier = Modifier.padding(8.dp))
//                }
//            }
//            Spacer(modifier = Modifier.height(16.dp))
//            Button( modifier = Modifier
////                                    .align(Alignment.CenterHorizontally)
//                .padding(5.dp)
//                .height(45.dp)
//                .width(165.dp),
//                colors = ButtonDefaults.buttonColors(backgroundColor = Color(
//                    0x8D1B1D1C
//                )
//                ),
//                shape = RoundedCornerShape(30.dp),
//                onClick = { launcher.launch("image/*") }
//            ) {
//                Text("Select Image",
//                    color = Color.White
//                )
//            }



            Row(modifier = Modifier
                .fillMaxWidth()
                .height(58.dp)
                .background(
                    Color(0x7C093A5A)
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
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = "Contact Us",
                fontFamily = FontFamily.Serif,
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier.padding(0.dp,20.dp,0.dp,0.dp))
            Spacer(modifier = Modifier.height(45.dp))
            Card( modifier = Modifier
                .padding(10.dp)
                .height(450.dp)
                .width(350.dp),
                shape = RoundedCornerShape(0.dp, 180.dp, 0.dp, 0.dp),
            ){
                Column{
                    Row{
                        Icon(imageVector =Icons.Default.Call,
                            contentDescription = null,tint = Color(0xFF001D66),
                            modifier = Modifier
                                .padding(32.dp,40.dp,10.dp,20.dp))
                        Text(text = "000-111-222-33",
                            modifier = Modifier
                                .padding(12.dp,40.dp,10.dp,20.dp))
                    }
                    Row{
                        Icon(imageVector =Icons.Default.Email,
                            contentDescription = null, tint = Color(0xFF001D66),
                            modifier = Modifier
                                .padding(32.dp,0.dp,10.dp,20.dp))
                        Text(text = "plumetravel@gmail.com",
                            modifier = Modifier
                                .padding(12.dp,0.dp,10.dp,20.dp))
                    }
                    Row{
                        Spacer(modifier = Modifier.width(35.dp))
                        Icon(painter = painterResource(id = R.drawable.right),
                            contentDescription = null,tint = Color(0xFF001D66),
                            modifier = Modifier
                                .size(23.dp)
                                )
                        Spacer(modifier = Modifier.width(5.dp))
//                                .padding(32.dp,0.dp,10.dp,10.dp))
                        Text(text = "30100",
                            modifier = Modifier
                                .padding(12.dp,0.dp,10.dp,10.dp))
                    }

                }
                Spacer(modifier = Modifier.height(12.dp))

                Row{
                    TextField(
                    value = productName,
                    onValueChange = { productName = it },
                    label = { Text("Name") },
                    isError = productNameError,
                    modifier = Modifier.width(150.dp)
                )
                    Spacer(modifier = Modifier.width(20.dp))

                    TextField(
                        value = productQuantity,
                        onValueChange = { productQuantity = it },
                        label = { Text(" Email ") },
                        isError = productNameError,
                        modifier = Modifier.width(150.dp)
                    )
                }
                Spacer(modifier = Modifier.height(14.dp))
                TextField(
                    value = productPrice,
                    onValueChange = { productPrice = it },
                    label = { Text("Phone number") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    isError = productPriceError,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(14.dp))

                TextField(
                    value = productDescription,
                    onValueChange = { productDescription = it },
                    label = { Text("Message") },
                    isError = productDescriptionError,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(18.dp))

                if (!isUploading) {
                    Button(
                        onClick = {
                            productNameError = productName.isBlank()
                            productDescriptionError = productDescription.isBlank()
                            productPriceError = productPrice.isBlank()
                            productQuantityError = productQuantity.isBlank()
//                        productImageError = productImageUri == null

                            if (!productNameError && !productDescriptionError && !productPriceError && !productQuantityError) {
                                isUploading = true
                                addProductToFirestore(
                                    navController,
                                    onProductAdded,
                                    productName,
                                    productDescription,
                                    productQuantity,
                                    productPrice.toDouble(),
//                                productImageUri,
                                    onUploadComplete = { isUploading = false }
                                )
                            }
                        },
                        modifier = Modifier
//                                    .align(Alignment.CenterHorizontally)
                            .padding(88.dp, 0.dp, 0.dp, 0.dp)
                            .height(45.dp)
                            .width(150.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF001D66)
                        ),
                        shape = RoundedCornerShape(20.dp),

                        ) {
                        Text("Send Message",
                            color = Color.White)
                    }
                }

            }







            if (productNameError) {
                Text("Name is required", color = Color.Red)
            }
            if (productDescriptionError) {
                Text("Message is required", color = Color.Red)
            }
            if (productPriceError) {
                Text("Phone number is required", color = Color.Red)
            }
//            if (productImageError) {
//                Text("Destination Image is required", color = Color.Red)
//            }
            if (productQuantityError) {
                Text("Email is required", color = Color.Red)
            }


            if (isUploading) {
                Spacer(modifier = Modifier.height(16.dp))
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(modifier = Modifier.size(48.dp),
                        color = Color(0xFF093A5A))
                    Text("Uploading...", modifier = Modifier.padding(start = 8.dp))
                }
            }

            var expanded by remember {
                mutableStateOf(false)
            }
            val items = listOf(
                MiniFabItems(Icons.Filled.Home,"Home"),
//        MiniFabItems(Icons.Filled.DateRange,"About",),
//        MiniFabItems(Icons.Filled.MailOutline,"Contact")
            )
            val context = LocalContext.current
            data class MiniFabItems(
                val icon:ImageVector,
                val title: String,


                )
            Column (
                modifier = Modifier.padding(272.dp,64.dp,0.dp,0.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.End){
                AnimatedVisibility(visible =  false,
                    enter = fadeIn() + slideInVertically(initialOffsetY = {it}) + expandVertically (),
                    exit = fadeOut() + slideOutVertically(targetOffsetY = {it}) + shrinkVertically (),

                    ) {
                    LazyColumn {
                        items(items.size){
                            ItemUI(
                                icon = items[it].icon, title = items[it].title,
                                navController = navController
                            )

                        }
                    }
                }

                FloatingActionButton(onClick =
                { navController.navigate(ROUTE_FLY)} ,
                    containerColor =( Color(0xFF093A5A))) {
                    androidx.compose.material3.Icon(imageVector = Icons.Filled.Home,
                        contentDescription = "", tint = Color.White)
                }
            }

//            Row (
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.End)
//            {
//
//                Spacer(modifier = Modifier.weight(1f))
//                Spacer(modifier = Modifier.width(10.dp))
//
//                val transition = updateTransition(targetState = expanded, label = "transition")
//                val rotation by transition.animateFloat (label = "rotation"){
//                    if (it) 315f else 0f
//                }
//                FloatingActionButton(onClick =  {
////                    expanded = !expanded
//                    navController.navigate(ROUTE_INSERT_PRODUCT)
//                    navController.navigate(ROUTE_ABOUT)
//                    navController.navigate(ROUTE_FLY)
//                },       modifier = Modifier.rotate(rotation)
//                    .size(55.dp)
//                    .padding(0.dp,0.dp,20.dp,0.dp),
//                    containerColor = Color(0xFF093A5A)){
//                    Icon(imageVector = Icons.Default.Home, contentDescription = "")
//                }
//
//            }
        }
    }
}


private fun addProductToFirestore(
    navController: NavController,
    onProductAdded: () -> Unit,
    productName: String,
    productDescription: String,
    productQuantity: String,
    productPrice: Double,
//    productImageUri: Uri?,
    onUploadComplete: () -> Unit
) {
//    if (productImageUri == null) return

    val productId = UUID.randomUUID().toString()
    val firestore = Firebase.firestore
    val productData = hashMapOf(
        "name" to productName,
        "message" to productDescription,
        "number" to productPrice,
        "email" to productQuantity,
//        "imageUrl" to ""
    )

    firestore.collection("contacts").document(productId)
        .set(productData)
        .addOnSuccessListener {
//            uploadImageToStorage(productId, productImageUri) { imageUrl ->
                firestore.collection("contacts").document(productId)
//                    .update("imageUrl", imageUrl)
//                    .addOnSuccessListener {
                        Toast.makeText(navController.context, "message sent successfully!", Toast.LENGTH_SHORT).show()
                        navController.navigate(ROUTE_CONTACT)
                        onProductAdded()
                        onUploadComplete()
                    }
//                    .addOnFailureListener { e ->
//                        Toast.makeText(navController.context, "Failed to update destination image URL.", Toast.LENGTH_SHORT).show()
//                        onUploadComplete()
//                    }
            }

//        .addOnFailureListener { e ->
//            Toast.makeText(navController.context, "Failed to add destination.", Toast.LENGTH_SHORT).show()
//            onUploadComplete()
//        }
//}

//private fun uploadImageToStorage(productId: String, imageUri: Uri?, onSuccess: (String) -> Unit) {
//    if (imageUri == null) {
//        onSuccess("")
//        return
//    }
//
//    val storageRef = Firebase.storage.reference
//    val imagesRef = storageRef.child("destinations/$productId.jpg")
//
//    imagesRef.putFile(imageUri)
//        .addOnSuccessListener {
//            imagesRef.downloadUrl
//                .addOnSuccessListener { uri ->
//                    onSuccess(uri.toString())
//                }
//                .addOnFailureListener {
//                    onSuccess("")
//                }
//        }
//        .addOnFailureListener {
//            onSuccess("")
//        }
//}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainUI (navController: NavController){

}








@Composable
fun ItemUI (icon: ImageVector, title:String, navController: NavController){


}












