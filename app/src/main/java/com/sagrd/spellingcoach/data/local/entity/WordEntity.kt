package com.sagrd.spellingcoach.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Words")
data class WordEntity(
    @PrimaryKey(autoGenerate = true)
    val wordId: Int,
    val name: String,
    val description: String
)