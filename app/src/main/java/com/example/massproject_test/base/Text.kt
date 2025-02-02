package com.example.massproject_test.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.massproject_test.ui.theme.BackgroundGreen
import com.example.massproject_test.ui.theme.Orange50
import com.example.massproject_test.ui.theme.TextGreen

@Preview
@Composable
private fun StatusVideoPreview() {
    StatusVideo(status = "Alive")
}

@Composable
fun CustomText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 16.sp,
    fontWeight: FontWeight = FontWeight(400),
    color: Color = Color.Black,
    maxLines: Int = 1,
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        fontWeight = fontWeight,
        color = color,
        maxLines = maxLines,
    )
}

@Composable
fun StatusVideo(
    modifier: Modifier = Modifier,
    status: String,
    backgroundColor: Color = BackgroundGreen,
    textColor: Color = TextGreen,
) {
    Text(
        text = status,
        modifier = modifier
            .clip(RoundedCornerShape(25.dp))
            .background(backgroundColor)
            .padding(
                vertical = 4.dp,
                horizontal = 8.dp
            ),
        fontSize = 14.sp,
        color = textColor,
    )
}