package com.example.newschannelproject.presentation

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.example.newschannelproject.newsData.Article

@Composable
fun NewsItem(article: Article) {
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp)
            .width(120.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Surface {
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {
                Image(modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.2f),
                    painter = rememberImagePainter(
                        data = article.urlToImage,
                        builder = {
                            scale(Scale.FILL)
                            placeholder(com.example.newschannelproject.R.drawable.ic_launcher_background)
                            transformations(CircleCropTransformation())
                        }

                    ), contentDescription = article.url)
                Column(
                    modifier = Modifier
                        .clickable {
                            Log.e("Column", "is choose")
                        }
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = article.author?:"",
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold,
                        color = Color.Unspecified
                    )
                    Text(
                        text = article.content?:"",
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold,
                        color = Color.Unspecified
                    )
                    Text(
                        text = article.description?:"",
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = article.title?: "" ,
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        text = article.publishedAt?:"",
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold
                    )

                }
            }
        }

    }

}