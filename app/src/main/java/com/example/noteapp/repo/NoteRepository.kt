package com.example.noteapp.repo

import androidx.lifecycle.LiveData
import com.example.noteapp.model.Note
import com.example.noteapp.model.NoteDao

class NoteRepository(private val noteDao: NoteDao) {
    val allNotes : LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun addNote(note: Note){
        noteDao.insertNote(note)
    }

    suspend fun deleteNote(note: Note){
        noteDao.deleteNote(note)
    }

    suspend fun updateNote(note: Note){
        noteDao.updateNote(note)
    }
}