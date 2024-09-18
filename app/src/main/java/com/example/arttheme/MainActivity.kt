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
    val stringTitles: Array<String> =  stringArrayResource(R.array.titles)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.art_institute),
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(30.dp))
        Text(
            text = stringTitles[1],
            fontSize = 30.sp
        )
        Text (
            text = "TBD"
        )
        Spacer(modifier = Modifier.size(40.dp))
        Row {
            Button(
                onClick = { /*TODO*/ },
            ) {

            }
            Spacer(modifier = Modifier.size(100.dp))
            Button(
                onClick = { /*TODO*/ },
            ) {

            }
        }


    }
}



@Preview(showBackground = true)
@Composable
fun ArtThemePreview() {
    ArtThemeTheme {
        ArtThemeLayout()

    }
}