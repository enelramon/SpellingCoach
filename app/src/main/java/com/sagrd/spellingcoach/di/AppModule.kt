package com.sagrd.spellingcoach.di

import android.content.Context
import androidx.room.Room
import com.sagrd.spellingcoach.data.WordsRepository
import com.sagrd.spellingcoach.data.local.SpeelingCoachDb
import com.sagrd.spellingcoach.data.local.WordDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): SpeelingCoachDb {
        val DATABASE_NAME = "SpeelingCoachDb"
        return Room.databaseBuilder(
            context,
            SpeelingCoachDb::class.java,
            DATABASE_NAME       )
            .fallbackToDestructiveMigration()
            //.createFromAsset()
            .build()
    }

    @Provides
    fun ProvideWordDAO(db: SpeelingCoachDb): WordDao {
        return db.wordDao
    }

    @Provides
    fun ProvideWordRepository(dao: WordDao): WordsRepository {
        return WordsRepository(dao)
    }
}