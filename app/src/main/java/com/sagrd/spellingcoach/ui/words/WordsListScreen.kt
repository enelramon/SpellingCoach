package com.sagrd.spellingcoach.ui.words

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.sagrd.spellingcoach.data.local.entity.WordEntity
import com.sagrd.spellingcoach.util.collectAsStateLifecycleAware


@Composable
fun WordsListScreen(
    onNavigateToWord: () -> Unit,
    viewModel: WordViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Words List") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onNavigateToWord()
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Nuevo")
            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(modifier = Modifier.padding(it)) {
            val list by viewModel.words.collectAsStateLifecycleAware(initial = emptyList())

            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(list) { word ->
                    WordRow(word,{})
                }
            }
        }
    }

}


@Composable
fun WordRow(word: WordEntity, onClick: (word:WordEntity) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                enabled = true,
                onClick = {  })
    )
    {
        Text(
            text = word.name,
            style = MaterialTheme.typography.h5,
            maxLines = 1,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = word.description,
            maxLines = 3,
            modifier = Modifier.fillMaxWidth()
        )
    }
}


