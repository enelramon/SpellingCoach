package com.sagrd.spellingcoach.data.local

import androidx.room.*
import com.sagrd.spellingcoach.data.local.entity.WordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insert(wordEntity: WordEntity)

    @Delete
    suspend fun Delete(wordEntity: WordEntity)

    @Query("""
        SELECT * 
        FROM Words
        ORDER BY wordId    
    """)
    fun GetList(): Flow<List<WordEntity>>
}