package com.ip.locator.ui.main

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import org.jetbrains.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.ip.locator.ui.main.components.MainLoading


class MainScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val viewModel = getScreenModel<MainViewModel>()
        val state by viewModel.state.collectAsState()

        LifecycleEventEffect(Lifecycle.Event.ON_START) {
            viewModel.onEvent(MainEvent.SearchIpAddress(query = ""))
        }

        Scaffold(
            containerColor = Color(0xFF3A6D8C),
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color(0xFF3A6D8C),
                    ),
                    title = {
                        Text(text = "IP Locator", color = Color(0xFFEEF7FF))
                    },
                    modifier = Modifier.clip(RoundedCornerShape(15.dp, 0.dp, 0.dp, 15.dp))
                )
            },
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding(),

        ){
            MainContent(
                modifier = Modifier
                    .padding(it),
                state = state,
                onEvent = viewModel::onEvent
            )
        }
    }

}

@Composable
private fun MainContent(
    modifier: Modifier = Modifier,
    state: MainState,
    onEvent: (MainEvent) -> Unit,
){

    var search by remember {
        mutableStateOf("")
    }

    val focusManager = LocalFocusManager.current

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(18.dp),
        modifier = modifier
            .fillMaxSize()
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(50.dp)
                .padding(16.dp, 0.dp)
        ) {
            TextField(
                value = search,
                onValueChange = { search = it },
                label = {
                    Text(text = "Search IP Address")
                },
                colors = androidx.compose.material3.TextFieldDefaults.colors(
                    focusedIndicatorColor = Color(0xFF001F3F),
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent
                ),
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(15.dp, 0.dp, 0.dp, 15.dp))
                    .background(Color(0xFFEEF7FF))
            )
            Spacer(modifier = Modifier.width(8.dp))
            Card(
                backgroundColor = Color(0xFF001F3F),
                modifier = Modifier
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(0.dp, 15.dp, 15.dp, 0.dp))
                    .clickable {
                        onEvent(MainEvent.SearchIpAddress(query = search))
                        focusManager.clearFocus()
                    }
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxHeight()
                ) {
                    Text(text = "Search", color = Color.White)
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .clip(RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp))
                .background(Color(0xFFEEF7FF))
                .padding(20.dp, 20.dp)
        ) {
            if (state.isLoading) {
                MainLoading()
            } else {
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text(text = "IP Address : ")
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(text = state.ipAddress.query,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp)
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text(text = "Country : ")
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(text = state.ipAddress.country,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp)
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text(text = "Country Code : ")
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(text = state.ipAddress.countryCode,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp)
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text(text = "Region Name : ")
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(text = state.ipAddress.regionName,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp)
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text(text = "Region : ")
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(text = state.ipAddress.region,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp)
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text(text = "Continent : ")
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(text = state.ipAddress.continent,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp)
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text(text = "Continent Code : ")
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(text = state.ipAddress.continentCode,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp)
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text(text = "City : ")
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(text = state.ipAddress.city,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp)
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text(text = "Timezone : ")
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(text = state.ipAddress.timezone,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp)
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text(text = "ISP : ")
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(text = state.ipAddress.isp,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp)
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text(text = "As : ")
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(text = state.ipAddress.asName,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp)
                    }
                }
            }
        }
    }
}