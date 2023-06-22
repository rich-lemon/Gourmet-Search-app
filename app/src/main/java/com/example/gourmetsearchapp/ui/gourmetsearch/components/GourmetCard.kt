package com.example.gourmetsearchapp.ui.gourmetsearch.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.gourmetsearchapp.domain.model.Gourmet
import com.example.gourmetsearchapp.ui.theme.GourmetSearchAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GourmetCard(
    gourmet: Gourmet,
    onClick: (Gourmet) -> Unit
) {
    Card(
        onClick = { onClick(gourmet) },
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        shape = RoundedCornerShape(0),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
    ) {
        Column(verticalArrangement = Arrangement.SpaceBetween) {
            // 画像
            if (gourmet.mobile_l != null) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(gourmet.mobile_l)
                        .crossfade(true)
                        .build(),
                    contentDescription = gourmet.mobile_l,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(4f / 3f),
                    contentScale = ContentScale.Crop
                )
            } else if (gourmet.mobile_s != null) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(gourmet.mobile_s)
                        .crossfade(true)
                        .build(),
                    contentDescription = gourmet.mobile_s,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(4f / 3f),
                    contentScale = ContentScale.Crop
                )
            }

            // 店舗情報
            Column(
                Modifier.padding(
                    top = 5.dp,
                    start = 5.dp,
                    end = 5.dp
                )
            ) {
                Text(
                    gourmet.name,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    gourmet.address,
                    style = MaterialTheme.typography.labelMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}

@Preview()
@Composable
fun GourmetCardPreview() {
    val gourmet = Gourmet(
        name = "Title",
        logo_image = null,
        address = "Sub title",
        station_name = null,
        mobile_l = null,
        mobile_s = "https://imgfp.hotp.jp/IMGH/70/07/P038317007/P038317007_100.jpg",
        open = null,
        close = null
    )

    GourmetSearchAppTheme() {
        GourmetCard(gourmet, {})
    }
}