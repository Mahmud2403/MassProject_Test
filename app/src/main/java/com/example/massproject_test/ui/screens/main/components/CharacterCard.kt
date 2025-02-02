package com.example.massproject_test.ui.screens.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.massproject_test.R
import com.example.massproject_test.base.AdjustableImage
import com.example.massproject_test.base.CustomText
import com.example.massproject_test.base.StatusVideo
import com.example.massproject_test.base.WatchVideoButton
import com.example.massproject_test.domain.model.Location
import com.example.massproject_test.domain.model.Origin
import com.example.massproject_test.domain.model.Result
import com.example.massproject_test.ui.theme.BackgroundGray
import com.example.massproject_test.ui.theme.BackgroundGreen
import com.example.massproject_test.ui.theme.BackgroundRed
import com.example.massproject_test.ui.theme.Gray30
import com.example.massproject_test.ui.theme.TextGray
import com.example.massproject_test.ui.theme.TextGreen
import com.example.massproject_test.ui.theme.TextRed
import java.util.Locale

@Preview
@Composable
private fun CharacterCardPreview() {
    CharacterCard(
        result = Result(
            id = 1,
            name = "Rick Sanchez",
            status = "Alive",
            species = "Human",
            type = "",
            gender = "Male",
            origin = Origin(
                name = "Earth",
                url = "https://rickandmortyapi.com/api/location/1"
            ),
            location = Location(
                name = "Earth",
                url = "https://rickandmortyapi.com/api/location/20"
            ),
            image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            episode = listOf(
                "https://rickandmortyapi.com/api/episode/1",
                "https://rickandmortyapi.com/api/episode/2"
            ),
            url = "https://rickandmortyapi.com/api/character/1",
            created = "2017-11-04T18:48:46.250Z"
        )
    )
}

@Composable
fun CharacterCard(
    modifier: Modifier = Modifier,
    result: Result,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        AdjustableImage(
            model = result.image,
            isDead = result.status == "Dead"
        )
        Column(
            modifier = Modifier
                .padding(
                    start = 18.dp,
                )
        ) {
            CustomText(
                text = result.name,
                fontSize = 21.sp,
            )
            CustomText(
                modifier = Modifier.padding(
                    top = 4.dp,
                    bottom = 12.dp
                ),
                text = "${result.species}, ${result.gender}",
                fontSize = 14.sp,
            )
            WatchVideoButton()
            Row(
                modifier = Modifier.padding(
                    top = 10.dp
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.padding(
                        end = 6.dp
                    ),
                    painter = painterResource(R.drawable.ic_placemark),
                    contentDescription = null,
                )
                CustomText(
                    modifier = Modifier
                        .width(70.dp),
                    text = result.location.name,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Gray30
                )
            }
        }
            StatusVideo(
                modifier = Modifier
                    .align(Alignment.Top)
                    .padding(
                        start = 8.dp
                    ),
                status = result.status.uppercase(Locale.getDefault()),
                textColor = when (result.status) {
                    "Alive" -> TextGreen
                    "Dead" -> TextRed
                    "unknown" -> TextGray
                    else -> Color.White
                },
                backgroundColor = when (result.status) {
                    "Alive" -> BackgroundGreen
                    "Dead" -> BackgroundRed
                    "unknown" -> BackgroundGray
                    else -> Color.Black
                }
            )

    }
}