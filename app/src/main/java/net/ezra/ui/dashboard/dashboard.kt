package net.ezra.ui.dashboard

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_FLY
import net.ezra.navigation.ROUTE_INSERT_PRODUCT

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DashboardScreen(navController: NavHostController){
    Scaffold (modifier = Modifier

        .fillMaxSize(),
        floatingActionButton = {
            MainUI(navController = navController)
        }
    ) {

    }



}

@Composable
fun MainUI (navController: NavController){
    var expanded by remember {
        mutableStateOf(false)
    }
    val items = listOf(
       MiniFabItems(Icons.Filled.Home,"Home"),
//        MiniFabItems(Icons.Filled.DateRange,"About",),
//        MiniFabItems(Icons.Filled.MailOutline,"Contact")
    )
Column (horizontalAlignment = Alignment.End){

        AnimatedVisibility(visible = expanded,
            enter = fadeIn() + slideInVertically(initialOffsetY = {it}) + expandVertically (),
            exit = fadeOut() + slideOutVertically(targetOffsetY = {it}) + shrinkVertically (),

        ) {
            LazyColumn {
                items(items.size){
                    ItemUI(
                        icon = items[it].icon, title = items[it].title,
                        navController = navController
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

        }
    
    val transition = updateTransition(targetState = expanded, label = "transition")
    val rotation by transition.animateFloat (label = "rotation"){
        if (it) 315f else 0f
    }
FloatingActionButton(onClick =
{expanded = !expanded} ,
    modifier = Modifier.rotate(rotation),
    containerColor =Color(0xFF093A5A)) {
    androidx.compose.material3.Icon(imageVector = Icons.Filled.Add, contentDescription = "")
}
}
}




data class MiniFabItems(
    val icon:ImageVector,
    val title: String,


)



@Composable
fun ItemUI (icon: ImageVector, title:String, navController: NavController){
val context = LocalContext.current
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End)
    {
Spacer(modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.width(10.dp))
        FloatingActionButton(onClick =  {
            navController.navigate(ROUTE_INSERT_PRODUCT)
            navController.navigate(ROUTE_ABOUT)
            navController.navigate(ROUTE_FLY)
        }, modifier = Modifier.size(45.dp), containerColor = Color(0xFF093A5A)){
                Icon(imageVector = icon, contentDescription = "")
        }

    }

}






@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    DashboardScreen(rememberNavController())
}




