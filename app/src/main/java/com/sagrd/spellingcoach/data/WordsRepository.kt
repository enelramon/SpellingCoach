package com.sagrd.spellingcoach.data

import androidx.room.Delete
import androidx.room.Query
import com.sagrd.spellingcoach.data.local.WordDao
import com.sagrd.spellingcoach.data.local.entity.WordEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WordsRepository @Inject constructor(
    val dao : WordDao
) {
    suspend fun Insert(wordEntity: WordEntity){
        dao.Insert(wordEntity)
    }

    suspend fun Delete(wordEntity: WordEntity){
        dao.Delete(wordEntity)
    }

    fun GetList(): Flow<List<WordEntity>>{
        return dao.GetList()
    }
}