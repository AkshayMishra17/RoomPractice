package com.example.noteapp.model

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class NoteDB:RoomDatabase(){
    abstract fun noteDao():NoteDao

    companion object{
        @Volatile
        private var INSTANCE: NoteDB? = null

        fun getDatabase(context: Context):NoteDB{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDB::class.java,
                    "note_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}