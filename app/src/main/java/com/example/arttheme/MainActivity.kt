package com.example.arttheme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
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
    var state by remember { mutableIntStateOf(0) }
    val count: Array<String> =  stringArrayResource(R.array.titles)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFB1DFF2)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {

        ComposeTextAndImage(state)

        Spacer(modifier = Modifier.size(40.dp))

        Row {
            Button(

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF841818),
                    contentColor = Color.White
                ),
                onClick = { if (state > 0) {
                    state--
                } else if (state == 0){
                    state = count.size - 1
                } },
            ) {
                Text(text = "Back",
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic
                )
            }
            Spacer(modifier = Modifier.size(100.dp))
            Button(

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2A8418),
                    contentColor = Color.White
                ),
                onClick = { if (state < count.size - 1) {
                    state++
                } else if (state == count.size - 1){
                    state = 0
                }},
            ) {
                Text(text = "Next",
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic
                )
            }
        }
    }
}

@Composable
fun ComposeTextAndImage(currentStep: Int) {
    val stringTitles: Array<String> =  stringArrayResource(R.array.titles)
    val stringDesc: Array<String> =  stringArrayResource(R.array.descriptions)
    val imageArray = arrayOf(
        R.drawable.adler_planetarium,
        R.drawable.art_institute,
        R.drawable.chinatown,
        R.drawable.melenium_park,
        R.drawable.navy_pier,
        R.drawable.sears_tower,
        R.drawable.shedd_aquarium,
        R.drawable.wrigley_field
    )
    Image(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .background(Color(0xFF57C5F4))
            .border(width = 4.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
                .padding(2.dp),
        painter = painterResource(imageArray[currentStep]),
        contentDescription = null
    )
    Spacer(modifier = Modifier.size(30.dp))
    Text(
        text = stringTitles[currentStep],
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold
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