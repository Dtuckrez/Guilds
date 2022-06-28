package com.tuckz.guilds.screens.tavern

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tuckz.guilds.R
import com.tuckz.guilds.data.character.Character
import com.tuckz.guilds.navigation.Screen
import com.tuckz.guilds.ui.theme.GuildsTheme


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TavernScreen(navController: NavHostController?) {

    var characterList = ArrayList<Character>();
    characterList.add(Character("Dave", "He likes toads."))

    Box(
    ) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        ) {
            items(characterList.size) {
                CharacterCard(navController!!)
            }
        }
    }
}

@Composable
fun CharacterCard(navController: NavHostController?) {
    Row(
        Modifier
            .clickable { navController!!.navigate(route = Screen.Character.route) }
            .background(Color.White)
            .shadow(1.dp, shape = MaterialTheme.shapes.small),
        verticalAlignment = Alignment.Top
    ) {
        val image: Painter = painterResource(id = R.drawable.img)
        Image(painter = image, contentDescription = "", Modifier.padding(8.dp))
        Column(
            Modifier
                .padding(8.dp)
                .background(Color.White)
                .shadow(1.dp, shape = MaterialTheme.shapes.small),
        ) {
            Text("Name: Test Character", Modifier.padding(8.dp, 0.dp))
            Text("Race: Rabbit Person", Modifier.padding(8.dp, 0.dp))
            Text("Job: Fighter", Modifier.padding(8.dp, 0.dp))
            CharacterStatsRow()
        }
    }
}

@Composable
fun CharacterStatsRow() {
    Column(
        Modifier
            .background(Color.White)
            .shadow(1.dp, shape = MaterialTheme.shapes.small),
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(8.dp, 2.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text("Health: 6")
            Text("Power: 6")
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(8.dp, 2.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text("Attack: 6")
            Text("Defence: 6")
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(8.dp, 2.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text("Power: 6")
            Text("Resilience: 6")
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(8.dp, 2.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text("Luck: 6")
            Text("Speed: 6")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GuildsTheme {
        var navController = rememberNavController()
        TavernScreen(navController)
    }
}