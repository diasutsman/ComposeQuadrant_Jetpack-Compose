package com.dias.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dias.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    ComposableQuadrant()
                }
            }
        }
    }
}

@Composable
fun ComposableQuadrant() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f).fillMaxWidth()) {
            Quadrant(stringResource(R.string.text_composable),
                stringResource(R.string.text_desc),
                Color.Green, Modifier.weight(1f))
            Quadrant(stringResource(R.string.image_composable),
                stringResource(R.string.image_desc),
                Color.Yellow, Modifier.weight(1f))
        }
        Row(Modifier.weight(1f).fillMaxWidth()) {
            Quadrant(stringResource(R.string.row_composable),
                stringResource(R.string.row_desc),
                Color.Blue, Modifier.weight(1f))
            Quadrant(stringResource(R.string.column_composable),
                stringResource(R.string.column_desc),
                Color.Gray, Modifier.weight(1f))
        }
    }
}

@Composable
fun Quadrant(title: String, desc: String, bgColor: Color, modifier: Modifier) {
    Surface(color = bgColor, modifier = modifier
        .fillMaxHeight()) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = desc,
                textAlign = TextAlign.Justify,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantTheme {
        ComposableQuadrant()
    }
}