package com.ip.locator.ui.main.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MainLoading() {
    Column(
        verticalArrangement = Arrangement.spacedBy(18.dp),

        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
    ) {
        Row {
            Text(text = "IP Address : ")
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(15.dp)
                    .clip(RoundedCornerShape(5.dp, 5.dp, 5.dp, 5.dp))
                    .background(shimmerBrush(targetValue = 1300f, showShimmer = true))
            ){}
        }
        Row {
            Text(text = "Country : ")
            Box(
                modifier = Modifier
                    .width(120.dp)
                    .height(15.dp)
                    .clip(RoundedCornerShape(5.dp, 5.dp, 5.dp, 5.dp))
                    .background(shimmerBrush(targetValue = 1300f, showShimmer = true))
            ){}
        }
        Row {
            Text(text = "Country Code : ")
            Box(
                modifier = Modifier
                    .width(120.dp)
                    .height(15.dp)
                    .clip(RoundedCornerShape(5.dp, 5.dp, 5.dp, 5.dp))
                    .background(shimmerBrush(targetValue = 1300f, showShimmer = true))
            ){}
        }
        Row {
            Text(text = "Region Name : ")
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(15.dp)
                    .clip(RoundedCornerShape(5.dp, 5.dp, 5.dp, 5.dp))
                    .background(shimmerBrush(targetValue = 1300f, showShimmer = true))
            ){}
        }
        Row {
            Text(text = "Region : ")
            Box(
                modifier = Modifier
                    .width(70.dp)
                    .height(15.dp)
                    .clip(RoundedCornerShape(5.dp, 5.dp, 5.dp, 5.dp))
                    .background(shimmerBrush(targetValue = 1300f, showShimmer = true))
            ){}
        }
        Row {
            Text(text = "Continent : ")
            Box(
                modifier = Modifier
                    .width(60.dp)
                    .height(15.dp)
                    .clip(RoundedCornerShape(5.dp, 5.dp, 5.dp, 5.dp))
                    .background(shimmerBrush(targetValue = 1300f, showShimmer = true))
            ){}
        }
        Row {
            Text(text = "Continent Code : ")
            Box(
                modifier = Modifier
                    .width(120.dp)
                    .height(15.dp)
                    .clip(RoundedCornerShape(5.dp, 5.dp, 5.dp, 5.dp))
                    .background(shimmerBrush(targetValue = 1300f, showShimmer = true))
            ){}
        }
        Row {
            Text(text = "District : ")
            Box(
                modifier = Modifier
                    .width(60.dp)
                    .height(15.dp)
                    .clip(RoundedCornerShape(5.dp, 5.dp, 5.dp, 5.dp))
                    .background(shimmerBrush(targetValue = 1300f, showShimmer = true))
            ){}
        }
        Row {
            Text(text = "City : ")
            Box(
                modifier = Modifier
                    .width(120.dp)
                    .height(15.dp)
                    .clip(RoundedCornerShape(5.dp, 5.dp, 5.dp, 5.dp))
                    .background(shimmerBrush(targetValue = 1300f, showShimmer = true))
            ){}
        }
        Row {
            Text(text = "Zip : ")
            Box(
                modifier = Modifier
                    .width(60.dp)
                    .height(15.dp)
                    .clip(RoundedCornerShape(5.dp, 5.dp, 5.dp, 5.dp))
                    .background(shimmerBrush(targetValue = 1300f, showShimmer = true))
            ){}
        }
        Row {
            Text(text = "Timezone : ")
            Box(
                modifier = Modifier
                    .width(60.dp)
                    .height(15.dp)
                    .clip(RoundedCornerShape(5.dp, 5.dp, 5.dp, 5.dp))
                    .background(shimmerBrush(targetValue = 1300f, showShimmer = true))
            ){}
        }
        Row {
            Text(text = "ISP : ")
            Box(
                modifier = Modifier
                    .width(60.dp)
                    .height(15.dp)
                    .clip(RoundedCornerShape(5.dp, 5.dp, 5.dp, 5.dp))
                    .background(shimmerBrush(targetValue = 1300f, showShimmer = true))
            ){}
        }
        Row {
            Text(text = "As : ")
            Box(
                modifier = Modifier
                    .width(60.dp)
                    .height(15.dp)
                    .clip(RoundedCornerShape(5.dp, 5.dp, 5.dp, 5.dp))
                    .background(shimmerBrush(targetValue = 1300f, showShimmer = true))
            ){}
        }
    }
}

@Composable
fun shimmerBrush(showShimmer: Boolean = true,targetValue:Float = 1000f): Brush {
    return if (showShimmer) {
        val shimmerColors = listOf(
            Color.LightGray.copy(alpha = 0.6f),
            Color.LightGray.copy(alpha = 0.2f),
            Color.LightGray.copy(alpha = 0.6f),
        )

        val transition = rememberInfiniteTransition()
        val translateAnimation = transition.animateFloat(
            initialValue = 0f,
            targetValue = targetValue,
            animationSpec = infiniteRepeatable(
                animation = tween(800), repeatMode = RepeatMode.Reverse
            )
        )
        Brush.linearGradient(
            colors = shimmerColors,
            start = Offset.Zero,
            end = Offset(x = translateAnimation.value, y = translateAnimation.value)
        )
    } else {
        Brush.linearGradient(
            colors = listOf(Color.Transparent, Color.Transparent),
            start = Offset.Zero,
            end = Offset.Zero
        )
    }
}