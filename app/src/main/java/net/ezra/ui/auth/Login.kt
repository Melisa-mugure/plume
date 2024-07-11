package net.ezra.ui.auth



import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import net.ezra.R
import net.ezra.navigation.ROUTE_DASHBOARD
import net.ezra.navigation.ROUTE_FLY
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_REGISTER

@Composable
fun LoginScreen(navController: NavController, onLoginSuccess: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }
    var isLoading by remember { mutableStateOf(false) }

    BackHandler {
        navController.popBackStack()

    }
//    Box{
//        Image(painter = painterResource(id = R.drawable.bac),
//            contentDescription = null,
//            modifier = Modifier
//                .fillMaxSize(),
//            contentScale = ContentScale.Crop
//        )
//    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(2.dp,),
//            .background(
//                Color(0x7C093A5A)
//            ),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {

        Card( modifier = Modifier
            .padding(0.dp)
            .height(400.dp)
            .width(550.dp),
            shape = RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp),
        )
        {
            Image(painter = painterResource(id = R.drawable.backkk),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize())

        }
        Spacer(modifier = Modifier.height(10.dp))

        Text("Login",
            color = Color(0xFF093A5A),
            style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(3.dp),

        )
        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(3.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.size(48.dp),
                color = Color(0xFF093A5A))
        } else {



            Button(
                colors = ButtonDefaults.buttonColors(Color(0xFF093A5A)),
                onClick = {
                    if (email.isBlank() || password.isBlank()) {
                        error = "Please fill in all fields"
                    } else {
                        isLoading = true
                        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener { task ->
                                isLoading = false
                                if (task.isSuccessful) {
                                    navController.navigate(ROUTE_FLY)
                                } else {
                                    error = task.exception?.message ?: "Login failed"
                                }
                            }
                    }
                },
                modifier = Modifier
                    .height(45.dp)
                    .width(185.dp),
                shape = RoundedCornerShape(30.dp)
            ) {
                Text("Login",
                    color = Color.White)
            }
            Spacer(modifier = Modifier.height(19.dp))

            androidx.compose.material3.Text(
                modifier = Modifier

                    .clickable {
                        navController.navigate(ROUTE_REGISTER) {
                            popUpTo(ROUTE_LOGIN) { inclusive = true }
                        }
                    },
                text = "go to register",
                textAlign = TextAlign.Center,
                color = androidx.compose.material3.MaterialTheme.colorScheme.onSurface
            )



        }

        error?.let {
            Text(
                text = it,
                color = MaterialTheme.colors.error,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}
