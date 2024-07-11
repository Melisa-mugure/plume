package net.ezra.ui.auth

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import net.ezra.R
import net.ezra.navigation.ROUTE_DASHBOARD
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_REGISTER


@Composable
fun SignUpScreen(navController: NavController, onSignUpSuccess: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }
    var isLoading by remember { mutableStateOf(false) }
    val context = LocalContext.current

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
            .padding(2.dp),
//            .background(
//                Color(0x7C093A5A)
//            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card( modifier = Modifier
            .padding(0.dp)
            .height(380.dp)
            .width(550.dp),
            shape = RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp),
        )
        {
            Image(painter = painterResource(id = R.drawable.backkk),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize())
        }

        Text("Sign Up",
            color = Color(0xFF093A5A),
            style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth().padding(3.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))


        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth().padding(3.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth().padding(3.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.size(48.dp),
                color = Color(0xFF093A5A))
        } else {
            Button(
                colors = ButtonDefaults.buttonColors(Color(0xFF093A5A)),
                onClick = {
                    if (email.isBlank()){
                        error = "Email is required"
                    } else if (password.isBlank()){
                        error = "Password is required"
                    } else if(confirmPassword.isBlank()) {
                        error = "Password Confirmation required"
                    } else if (password != confirmPassword) {
                        error = "Passwords do not match"
                    } else {
                        isLoading = true
                        signUp(email, password, {
                            isLoading = false
                            Toast.makeText(context, "Sign-up successful!", Toast.LENGTH_SHORT).show()
                            navController.navigate(ROUTE_LOGIN)
                            onSignUpSuccess()
                        }) { errorMessage ->
                            isLoading = false
                            error = errorMessage
                        }
                    }
                },
                modifier = Modifier
                    .height(45.dp)
                    .width(185.dp),
                shape = RoundedCornerShape(30.dp)
            ) {
                Text("Sign Up",
                    color = Color.White)
            }

            Spacer(modifier = Modifier.height(19.dp))

            androidx.compose.material3.Text(
                modifier = Modifier

                    .clickable {
                        navController.navigate(ROUTE_LOGIN) {
                            popUpTo(ROUTE_REGISTER) { inclusive = true }
                        }
                    },
                text = "go to login",
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
private fun signUp(email: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit) {
    FirebaseAuth.getInstance().fetchSignInMethodsForEmail(email)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val signInMethods = task.result?.signInMethods ?: emptyList()
                if (signInMethods.isNotEmpty()) {
                    onError("Email is already registered")
                } else {
                    // Email is not registered, proceed with sign-up
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener { signUpTask ->
                            if (signUpTask.isSuccessful) {
                                onSuccess()
                            } else {
                                onError(signUpTask.exception?.message ?: "Sign-up failed")
                            }
                        }
                }
            } else {
                onError(task.exception?.message ?: "Failed to check email availability")
            }
        }
}


