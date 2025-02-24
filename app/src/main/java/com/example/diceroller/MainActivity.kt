/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
            }
        }
    }
}



@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result1 by remember { mutableIntStateOf(1) }
    var result2 by remember { mutableIntStateOf(1) }
    var result3 by remember { mutableIntStateOf(1) }
    var result4 by remember { mutableIntStateOf(1) }


    var str by remember { mutableIntStateOf(0) }
    var dex by remember { mutableIntStateOf(0) }
    var con by remember { mutableIntStateOf(0) }
    var int by remember { mutableIntStateOf(0) }
    var wis by remember { mutableIntStateOf(0) }
    var cha by remember { mutableIntStateOf(0) }


    val imageResource1 = when (result1) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    val imageResource2 = when (result2) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    val imageResource3 = when (result3) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Center
        ) {

            Image(
                modifier = Modifier
                    .weight(1f, fill = false)
                    .aspectRatio(0.8f)
                    .size(75.dp),
                painter = painterResource(imageResource1),
                contentDescription = result1.toString(),
                contentScale = ContentScale.FillBounds
            )
            Image(
                modifier = Modifier
                    .weight(1f, fill = false)
                    .aspectRatio(0.8f)
                    .size(75.dp),
                painter = painterResource(imageResource2),
                contentDescription = result2.toString(),
                contentScale = ContentScale.FillBounds
            )
            Image(
                    modifier = Modifier
                        .weight(1f, fill = false)
                        .aspectRatio(0.8f)
                        .size(75.dp),
            painter = painterResource(imageResource3),
            contentDescription = result3.toString(),
            contentScale = ContentScale.FillBounds
            )
            Image(
                modifier = Modifier
                    .weight(1f, fill = false)
                    .aspectRatio(0.8f)
                    .size(75.dp),
                painter = painterResource(imageResource3),
                contentDescription = result3.toString(),
                contentScale = ContentScale.FillBounds
            )

        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                result1 = ((1..6).random())
                result2 = ((1..6).random())
                result3 = ((1..6).random())
                result4 = ((1..6).random())

                if (str == 0) {
                    str = result1 + result2 + result3 + result4 - minOf(result1, result2, result3, result4)
                }
                else if (dex == 0) {
                    dex = result1 + result2 + result3 + result4 - minOf(result1, result2, result3, result4)
                }
                else if (con == 0) {
                    con = result1 + result2 + result3 + result4 - minOf(result1, result2, result3, result4)
                }
                else if (int == 0) {
                    int = result1 + result2 + result3 + result4 - minOf(result1, result2, result3, result4)
                }
                else if (wis == 0) {
                    wis = result1 + result2 + result3 + result4 - minOf(result1, result2, result3, result4)
                }
                else if (cha == 0) {
                    cha = result1 + result2 + result3 + result4 - minOf(result1, result2, result3, result4)
                }
                else {
                    str = 0
                    dex = 0
                    con = 0
                    int = 0
                    wis = 0
                    cha = 0
                }
                      },
            modifier = Modifier.wrapContentSize()
        ) {
            Text(stringResource(R.string.roll))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "STR: $str",
        )
        Text(
            text = "DEX: $dex",
        )
        Text(
            text = "CON: $con",
        )
        Text(
            text = "INT: $int",
        )
        Text(
            text = "WIS: $wis",
        )
        Text(
            text = "CHA: $cha",
        )
    }

}

@Composable
@Preview
fun DiceRollerApp () {
    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}