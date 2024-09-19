package com.example.arttheme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.arttheme.ui.theme.ArtThemeTheme


class MainActivity : ComponentActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
        ArtThemeTheme {
            ArtThemeLayout()

            }
        }
    }
}






@Composable
fun ArtThemeLayout() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ComposeTextAndImage(1)

        Spacer(modifier = Modifier.size(40.dp))

        Row {

            ComposeButton()
        }
    }
}

@Composable
fun ComposeButton() {
    var state by remember { mutableStateOf(0) }
    Button(

        onClick = { if (state > 0) {
            state--
        } },
    ) {


    }
    Spacer(modifier = Modifier.size(100.dp))
    Button(
        onClick = { if (state < 6) {
            state++
            ComposeTextAndImage(currentStep = state)
        } },
    ) {


    }
}

@Composable
fun ComposeTextAndImage(currentStep: Int) {
    val stringTitles: Array<String> =  stringArrayResource(R.array.titles)
    val stringDesc: Array<String> =  stringArrayResource(R.array.descriptions)
    Image(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth(),
        painter = painterResource(id = R.drawable.art_institute),
        contentDescription = null
    )
    Spacer(modifier = Modifier.size(30.dp))
    Text(
        text = stringTitles[currentStep],
        fontSize = 30.sp
    )
    Text (
        text = stringDesc[currentStep]
    )
}



@Preview(showBackground = true)
@Composable
fun ArtThemePreview() {
    ArtThemeTheme {
        ArtThemeLayout()

    }
}