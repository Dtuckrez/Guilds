package com.tuckz.guilds

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tuckz.guilds.navigation.Screen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainMenuScreen(navController: NavHostController?) {
    val list = ArrayList<Int>()
    list.add(0)
    list.add(1)

    Column {
        MenuHeader()

        LazyVerticalGrid(
            cells = GridCells.Fixed(2)
        ) {
            items(list.size) {
                MenuGridItem(navController!!)
            }
        }
    }

}


@Composable
fun MenuHeader() {
    Row(
        Modifier
            .background(Color.White)
            .fillMaxWidth()
            .shadow(1.dp, shape = MaterialTheme.shapes.large),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(modifier = Modifier.padding(8.dp, 8.dp)) {
            Text(
                text = "Gold: 4009",
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "Crystals: 1",
                style = MaterialTheme.typography.body1
            )
        }

        Column {
            Text(
                text = "Tavern",
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.h5
            )
        }

        Column(modifier = Modifier.padding(8.dp, 8.dp)) {
            val image: Painter = painterResource(id = R.drawable.img)
            Image(painter = image, contentDescription = "", Modifier.size(32.dp))
        }

    }

}

@Composable
fun MenuGridItem(navController: NavHostController) {
    TextButton(onClick = {
        navController.navigate(route = Screen.Tavern.route)
    }) {
        val image: Painter = painterResource(id = R.drawable.img)
        Image(painter = image, contentDescription = "", Modifier.size(16.dp))
        Spacer(modifier = Modifier.width(50.dp))
        Text(text = "Tavern")
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    GuildsTheme {
//        MainMenuScreen(null)
//    }
//}