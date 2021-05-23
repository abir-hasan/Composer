package com.example.abir.composer

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val green = Color(0xFF1EB980)

private val themeColors = lightColors(
    primary = green,
    surface = Color.DarkGray,
    onSurface = green
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //MyApp { MyScreen2() }
            RingOfCircles()
        }
    }
}


@Composable
fun MyApp(content: @Composable() () -> Unit) {
    MaterialTheme(colors = themeColors) {
        Surface {
            content()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        modifier = Modifier.padding(24.dp),
        style = MaterialTheme.typography.h2
    )
}

@Composable
fun MyScreen() {
    Column {
        Greeting(name = " 1")
        Divider(color = Color.Black)
        Greeting(name = "2")
    }
}

@Composable
fun MyScreen2(names: List<String> = listOf("1", "2", "3")) {
    Column {
        for (name in names) {
            Greeting(name = name)
            Divider(color = Color.Black)
        }
        Divider(color = Color.Transparent, modifier = Modifier.padding(32.dp))
        Counter()
        Divider(color = Color.Transparent, modifier = Modifier.padding(32.dp))
        Counter()
    }
}

@Composable
fun Counter() {
    val counterState = remember { mutableStateOf(0) }
    Button(
        onClick = { counterState.value++ },
        //background = if (counterState.value % 2 == 0) green else Color.Red
    ) {
        Text(
            text = "This buttons is clicked ${counterState.value} times",
            color = if (counterState.value % 2 == 0) Color.DarkGray else Color.White
        )
    }
}


@Preview
@Composable
fun DefaultPreview() {
    MyApp { MyScreen2() }
}