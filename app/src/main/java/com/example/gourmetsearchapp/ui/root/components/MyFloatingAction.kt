package com.example.gourmetsearchapp.ui.root.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.gourmetsearchapp.ui.theme.GourmetSearchAppTheme
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun MyFloatingActionButton() {
    FloatingActionButton(
        onClick = { /* TODO */ },
        modifier = Modifier
            .size(80.dp)
            .border(
                width = 3.dp,
                color = MaterialTheme.colorScheme.secondary,
                shape = hexagonShape()
            ),
        shape = hexagonShape(),
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        elevation = FloatingActionButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp)
    ) {
        Icon(
            Icons.Filled.Search,
            modifier = Modifier.size(35.dp),
            contentDescription = "検索ボタン"
        )
    }
}

// 六角形
class hexagonShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            val radius = size.width / 2f

            // 六角形
            moveTo(radius, 0f)
            lineTo(
                radius + radius * cos(PI * 11 / 6).toFloat(),
                radius + radius * sin(PI * 11 / 6).toFloat()
            )
            lineTo(
                radius + radius * cos(PI / 6).toFloat(),
                radius + radius * sin(PI / 6).toFloat()
            )
            lineTo(radius, size.height) // 4
            lineTo(
                radius + radius * cos(PI * 5 / 6).toFloat(),
                radius + radius * sin(PI * 5 / 6).toFloat()
            )
            lineTo(
                radius + radius * cos(PI * 7 / 6).toFloat(),
                radius + radius * sin(PI * 7 / 6).toFloat()
            )
            close()
        }

        return Outline.Generic(path)
    }
}

@Preview()
@Composable
fun MyFloatingActionButtonPreview() {
    GourmetSearchAppTheme() {
        MyFloatingActionButton()
    }
}