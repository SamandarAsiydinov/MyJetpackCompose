package uz.context.mycomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.core.text.isDigitsOnly
import uz.context.mycomposable.compose.CustomComponent
import uz.context.mycomposable.ui.theme.MyComposableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposableTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    var value by remember { mutableStateOf(0) }

                    CustomComponent(
                        indicatorValue = value
                    )
                    TextField(
                        value = value.toString(),
                        onValueChange = {
                            value = if (it.isNotEmpty() && it.isDigitsOnly() && it.length <= 3) {
                                it.toInt()
                            } else {
                                0
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        )
                    )
                }
            }
        }
    }
}
/*
@Composable
fun OutlineTextField() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var name by remember { mutableStateOf("") }
        val maxChar = 10

        OutlinedTextField(
            value = name,
            onValueChange = {
                if (it.length <= maxChar) {
                    name = it
                }
            },
            label = { Text(text = "Name") },
            placeholder = { Text(text = "Enter your name") },
            maxLines = 1
        )
    }
}

 */