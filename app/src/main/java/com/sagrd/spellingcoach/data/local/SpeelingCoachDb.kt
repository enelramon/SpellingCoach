package com.sagrd.spellingcoach.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sagrd.spellingcoach.data.local.entity.WordEntity

@Database(
    entities = [WordEntity::class],
    exportSchema = true,
    version = 1
)
abstract class SpeelingCoachDb:RoomDatabase() {
    abstract val wordDao: WordDao
}