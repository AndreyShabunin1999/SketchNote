package com.anshabunin.sketchnote.di

import android.content.Context
import androidx.room.Room
import com.anshabunin.sketchnote.database.NotesDatabase
import com.anshabunin.sketchnote.entities.Note
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNotesDatabase(@ApplicationContext context: Context): NotesDatabase {
        return Room.databaseBuilder(
            context,
            NotesDatabase::class.java, "weather_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(db: NotesDatabase) = db.noteDao()

    @Provides
    fun provideEntity() = Note()
}