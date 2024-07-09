package net.ezra.ui.products

import android.annotation.SuppressLint
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import net.ezra.R
import net.ezra.navigation.ROUTE_CONTINENTS
import net.ezra.navigation.ROUTE_FLY
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_VIEW_PRODUCTS
import java.util.UUID

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun InsertProductScreen(navController: NavController, onProductAdded: () -> Unit) {
    var productName by remember { mutableStateOf("") }
    var productDescription by remember { mutableStateOf("") }
    var productPrice by remember { mutableStateOf("") }
    var productQuantity by remember { mutableStateOf("") }
    var productImageUri by remember { mutableStateOf<Uri?>(null) }

    var productNameError by remember { mutableStateOf(false) }
    var productDescriptionError by remember { mutableStateOf(false) }
    var productPriceError by remember { mutableStateOf(false) }
    var productQuantityError by remember { mutableStateOf(false) }
    var productImageError by remember { mutableStateOf(false) }

    var isUploading by remember { mutableStateOf(false) }

    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            productImageUri = it
        }
    }
//    Box{
//        Image(painter = painterResource(id = R.drawable.bac),
//            contentDescription = null,
//            modifier = Modifier
//                .fillMaxSize(),
//            contentScale = ContentScale.Crop
//        )
//    }
    Icon(Icons.AutoMirrored.Filled.ArrowBack,
        "backIcon",
        tint = Color.Black,
        modifier = Modifier
            .padding(5.dp)
            .width(29.dp)
            .clickable {
                navController.navigate(ROUTE_FLY)
            },
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color(0xFF7C9AAD)
            )
            .padding(10.dp)
    ) {


        item {
            if (productImageUri != null) {
                Image(
                    painter = rememberAsyncImagePainter(productImageUri),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No Image Selected",
                        modifier = Modifier
                            .padding(8.dp),
                        color =  Color(0xFF093A5A))
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button( modifier = Modifier
//                                    .align(Alignment.CenterHorizontally)
                .padding(85.dp,0.dp,0.dp,0.dp)
                .height(45.dp)
                .width(165.dp),
                colors = androidx.compose.material.ButtonDefaults.buttonColors(backgroundColor =  Color(0xFF093A5A)
                ),
                shape = RoundedCornerShape(30.dp),
                onClick = { launcher.launch("image/*") }
            ) {
                Text("Select Image",
                    color = Color.White
                   )
            }
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = productName,
                onValueChange = { productName = it },
                label = { Text("Destination") },
                isError = productNameError,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = productQuantity,
                onValueChange = { productQuantity = it },
                label = { Text(" Seats ") },
                isError = productNameError,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = productDescription,
                onValueChange = { productDescription = it },
                label = { Text("Destination Description") },
                isError = productDescriptionError,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = productPrice,
                onValueChange = { productPrice = it },
                label = { Text("Ticket Price") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                isError = productPriceError,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            if (productNameError) {
                Text("Destination is required", color = Color.Red)
            }
            if (productDescriptionError) {
                Text("Destination Description is required", color = Color.Red)
            }
            if (productPriceError) {
                Text("Ticket Price is required", color = Color.Red)
            }
            if (productImageError) {
                Text("Destination Image is required", color = Color.Red)
            }
            if (productQuantityError) {
                Text("Available seats is required", color = Color.Red)
            }

            if (!isUploading) {
                Button(
                    onClick = {
                        productNameError = productName.isBlank()
                        productDescriptionError = productDescription.isBlank()
                        productPriceError = productPrice.isBlank()
                        productQuantityError = productQuantity.isBlank()
                        productImageError = productImageUri == null

                        if (!productNameError && !productDescriptionError && !productPriceError && !productImageError && !productQuantityError) {
                            isUploading = true
                            addProductToFirestore(
                                navController,
                                onProductAdded,
                                productName,
                                productDescription,
                                productQuantity,
                                productPrice.toDouble(),
                                productImageUri,
                                onUploadComplete = { isUploading = false }
                            )
                        }
                    },
                    modifier = Modifier
//                                    .align(Alignment.CenterHorizontally)
                        .padding(82.dp,0.dp,0.dp,0.dp)
                        .height(45.dp)
                        .width(185.dp),
                    colors = androidx.compose.material.ButtonDefaults.buttonColors(backgroundColor =  Color(0xFF093A5A)
                    ),
                    shape = RoundedCornerShape(30.dp),

                ) {
                    Text("Save Destination",
                        color = Color.White)
                }
            }

            if (isUploading) {
                Spacer(modifier = Modifier.height(16.dp))
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                    Text("Uploading...", modifier = Modifier.padding(start = 8.dp))
                }
            }
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
    productImageUri: Uri?,
    onUploadComplete: () -> Unit
) {
    if (productImageUri == null) return

    val productId = UUID.randomUUID().toString()
    val firestore = Firebase.firestore
    val productData = hashMapOf(
        "name" to productName,
        "description" to productDescription,
        "price" to productPrice,
        "quantity" to productQuantity,
        "imageUrl" to ""
    )

    firestore.collection("destinations").document(productId)
        .set(productData)
        .addOnSuccessListener {
            uploadImageToStorage(productId, productImageUri) { imageUrl ->
                firestore.collection("destinations").document(productId)
                    .update("imageUrl", imageUrl)
                    .addOnSuccessListener {
                        Toast.makeText(navController.context, "Destination added successfully!", Toast.LENGTH_SHORT).show()
                        navController.navigate(ROUTE_VIEW_PRODUCTS)
                        onProductAdded()
                        onUploadComplete()
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(navController.context, "Failed to update destination image URL.", Toast.LENGTH_SHORT).show()
                        onUploadComplete()
                    }
            }
        }
        .addOnFailureListener { e ->
            Toast.makeText(navController.context, "Failed to add destination.", Toast.LENGTH_SHORT).show()
            onUploadComplete()
        }
}

private fun uploadImageToStorage(productId: String, imageUri: Uri?, onSuccess: (String) -> Unit) {
    if (imageUri == null) {
        onSuccess("")
        return
    }

    val storageRef = Firebase.storage.reference
    val imagesRef = storageRef.child("destinations/$productId.jpg")

    imagesRef.putFile(imageUri)
        .addOnSuccessListener {
            imagesRef.downloadUrl
                .addOnSuccessListener { uri ->
                    onSuccess(uri.toString())
                }
                .addOnFailureListener {
                    onSuccess("")
                }
        }
        .addOnFailureListener {
            onSuccess("")
        }
}
