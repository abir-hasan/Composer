package com.example.abir.composer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.padding
import androidx.ui.material.*
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

val green = Color(0xFF1EB980)

private val themeColors = lightColorPalette(
    primary = green,
    surface = Color.DarkGray,
    onSurface = green
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp { MyScreen2() }
            //RingOfCircles()
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
    val counterState = state { 0 }
    Button(
        onClick = { counterState.value++ },
        backgroundColor = if (counterState.value % 2 == 0) green else Color.Red
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