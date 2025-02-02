package com.example.massproject_test.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.massproject_test.R
import com.example.massproject_test.ui.theme.Orange50

@Preview(
    showBackground = true,
)
@Composable
private fun WatchVideoButtonPreview() {
    Box(
        modifier = Modifier
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        WatchVideoButton()
    }
}

@Composable
fun WatchVideoButton(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(17.dp))
            .background(Color(0xFFFFE6D5)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Icon(
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    top = 9.dp,
                    end = 6.dp,
                    bottom = 9.dp,
                ),
            painter = painterResource(R.drawable.ic_play),
            contentDescription = null,
            tint = Orange50
        )
        Text(
            text = "Watch episodes",
            modifier = Modifier
                .padding(
                    end = 12.dp
                ),
            color = Orange50
        )
    }
}