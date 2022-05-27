package com.sagrd.spellingcoach.util

sealed class Screen( val route: String) {
    object WordScreen: Screen("Word")
    object WordsListScreen: Screen("WordsList")
}