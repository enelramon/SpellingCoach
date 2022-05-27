package com.sagrd.spellingcoach.util

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sagrd.spellingcoach.ui.words.WordViewModel
import  androidx.lifecycle.viewmodel.compose.viewModel
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun WordScreen(
    onSave: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: WordViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Words Creation") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.Save()
                    onSave()

                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Save, contentDescription = "New")
            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(modifier = Modifier.padding(it)) {
            OutlinedTextField(
                label = {
                    Text(text = "Name")
                },
                value = viewModel.name,
                onValueChange = { viewModel.name = it },
                modifier = modifier.fillMaxWidth()
            )
            OutlinedTextField(
                label = {
                    Text(text = "Description")
                },
                value = viewModel.description,
                onValueChange = { viewModel.description = it },
                modifier =  modifier.fillMaxWidth()
            )
        }
    }

} 