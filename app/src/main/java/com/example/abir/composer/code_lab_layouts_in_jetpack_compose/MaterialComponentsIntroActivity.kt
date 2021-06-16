package com.example.abir.composer.code_lab_layouts_in_jetpack_compose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.abir.composer.code_lab_layouts_in_jetpack_compose.ui.theme.ComposerTheme

class MaterialComponentsIntroActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposerTheme {
                LayoutsCodeLab()
            }
        }
    }
}

@Composable
fun LayoutsCodeLab() {
    val result = remember { mutableStateOf("") }
    val selectedItem = remember { mutableStateOf("remember") }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "LayoutsCodelab")
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    }
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Filled.Search, contentDescription = null)
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                content = {
                    BottomNavigation {
                        BottomNavigationItem(
                            icon = { Icon(Icons.Filled.Upload, "") },
                            selected = selectedItem.value == "upload",
                            onClick = {
                                selectedItem.value = "upload"
                                result.value = "Upload Icon Clicked"
                            },
                            label = { Text(text = "Upload") },
                            alwaysShowLabel = false
                        )
                        BottomNavigationItem(
                            icon = { Icon(Icons.Filled.Air, "") },
                            selected = selectedItem.value == "air",
                            onClick = {
                                selectedItem.value = "air"
                                result.value = "Air Icon Clicked"
                            },
                            label = { Text(text = "Air") },
                            alwaysShowLabel = false
                        )
                        BottomNavigationItem(
                            icon = { Icon(Icons.Filled.Agriculture, "") },
                            selected = selectedItem.value == "agriculture",
                            onClick = {
                                selectedItem.value = "agriculture"
                                result.value = "Agriculture Icon Clicked"
                            },
                            label = { Text(text = "Agriculture") },
                            alwaysShowLabel = false
                        )
                        BottomNavigationItem(
                            icon = { Icon(Icons.Filled.AcUnit, "") },
                            selected = selectedItem.value == "acunit",
                            onClick = {
                                selectedItem.value = "acunit"
                                result.value = "AcUnit Icon Clicked"
                            },
                            label = { Text(text = "AcUnit") },
                            alwaysShowLabel = false
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        BodyContent(
            Modifier
                .padding(innerPadding)
                .padding(8.dp),
            result.value
        )
    }
}

@Composable
private fun BodyContent(modifier: Modifier = Modifier, selectedResult: String = "Hi there!") {
    Column(modifier = modifier) {
        Text(text = selectedResult, style = MaterialTheme.typography.h4)
        Text(text = "Thanks for going through the Layouts codelab")
    }
}


@Preview(showBackground = true)
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview3() {
    ComposerTheme {
        LayoutsCodeLab()
    }
}