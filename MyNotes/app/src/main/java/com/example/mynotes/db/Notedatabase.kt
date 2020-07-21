package com.example.mynotes.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Note::class],
    version = 1,
            exportSchema = false
)
 abstract class Notedatabase : RoomDatabase(){
    abstract fun getNoteDao():NoteDao
    companion object{
        @Volatile private var instance : Notedatabase? = null
        private val LOCK=Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){// null checkoperator
            instance ?: buildDatabase(context).also {
                instance=it
            }
        }

        private fun buildDatabase(context: Context)=Room.databaseBuilder(
            context.applicationContext,
            Notedatabase::class.java,
            "notedatabase"
        ).build()

    }
}