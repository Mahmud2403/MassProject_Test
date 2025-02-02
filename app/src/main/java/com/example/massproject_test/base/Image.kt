package com.example.massproject_test.base

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.massproject_test.R

@Preview
@Composable
private fun AdjustableImagePreview() {
    AdjustableImage(
        model = null
    )
}

@Composable
fun AdjustableImage(
    modifier: Modifier = Modifier,
    model: Any?,
    isDead: Boolean = false,
) {
    AsyncImage(
        modifier = modifier
            .size(120.dp)
            .clip(RoundedCornerShape(40.dp)),
        model = model,
        placeholder = painterResource(R.drawable.placeholder),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        colorFilter = if (isDead) ColorFilter.colorMatrix(ColorMatrix().apply {
            setToSaturation(0f)
        }) else null
    )
}