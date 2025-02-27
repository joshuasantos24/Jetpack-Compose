package com.example.app

import android.os.Bundle
import android.content.res.Configuration
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                PersonalData(name = "Joshua")
            }
        }
    }
}

@Composable
private fun PersonalData(name: String) {
    MaterialTheme {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.logo_ucateci_2),
                contentDescription = "Esta es una imagen de jetpack",
                modifier = Modifier.height(200.dp)
            )
            Text(
                text = "Mi nombre es $name",
                style = MaterialTheme.typography.headlineLarge
            )
            Text(text = "Soy Joshua")
            Text(text = "Estoy en camino a aprender jetpack compose")
            MyComponent()
            ListExample()
        }
    }
}

@Composable
private fun MyComponent() {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp)
    ) {
        MyImage()
        MyTexts()
    }
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(R.drawable.nuevologo_png),
        contentDescription = "Este es mi logo",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
            .size(80.dp)
    )
}

@Composable
fun MyTexts() {
    Column(modifier = Modifier.padding(start = 8.dp)) {
        MyText(
            text = "Probando Jetpack Compose",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            text = "Vamos por buen camino",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Composable
fun MyText(text: String, color: Color, style: TextStyle, lines: Int = Int.MAX_VALUE) {
    Text(text = text, color = color, style = style, maxLines = lines)
}

@Composable
fun ListExample() {
    var expanded = false
    val elementos = listOf(
        "Elemento 1 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sollicitudin commodo vehicula. Maecenas quis nunc sed purus pharetra convallis ac vitae felis. Integer in justo lorem.",
        "Elemento 2 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sollicitudin commodo vehicula. Maecenas quis nunc sed purus pharetra convallis ac vitae felis. Integer in justo lorem.",
        "Elemento 3 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sollicitudin commodo vehicula. Maecenas quis nunc sed purus pharetra convallis ac vitae felis. Integer in justo lorem.",
        "Elemento 4 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sollicitudin commodo vehicula. Maecenas quis nunc sed purus pharetra convallis ac vitae felis. Integer in justo lorem.",
        "Elemento 5 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sollicitudin commodo vehicula. Maecenas quis nunc sed purus pharetra convallis ac vitae felis. Integer in justo lorem.",
        "Elemento 6 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sollicitudin commodo vehicula. Maecenas quis nunc sed purus pharetra convallis ac vitae felis. Integer in justo lorem.",
        "Elemento 7 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sollicitudin commodo vehicula. Maecenas quis nunc sed purus pharetra convallis ac vitae felis. Integer in justo lorem.",
        "Elemento 8 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sollicitudin commodo vehicula. Maecenas quis nunc sed purus pharetra convallis ac vitae felis. Integer in justo lorem.",
        "Elemento 9 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sollicitudin commodo vehicula. Maecenas quis nunc sed purus pharetra convallis ac vitae felis. Integer in justo lorem.",
        "Elemento 10 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sollicitudin commodo vehicula. Maecenas quis nunc sed purus pharetra convallis ac vitae felis. Integer in justo lorem.",
        "Elemento 11 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sollicitudin commodo vehicula. Maecenas quis nunc sed purus pharetra convallis ac vitae felis. Integer in justo lorem.",
        "Elemento 12 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sollicitudin commodo vehicula. Maecenas quis nunc sed purus pharetra convallis ac vitae felis. Integer in justo lorem.",
        "Elemento 13 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sollicitudin commodo vehicula. Maecenas quis nunc sed purus pharetra convallis ac vitae felis. Integer in justo lorem.")
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .clickable { expanded = !expanded }
    ) {
        items(elementos) { item ->
            MyText(
                text = item,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary,
                lines = if (expanded) Int.MAX_VALUE else 2
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPersonalData() {
    AppTheme {
        PersonalData(name = "Joshua")
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponents() {
    AppTheme {
        MyComponent()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewListExample() {
    AppTheme {
        ListExample()
    }
}
