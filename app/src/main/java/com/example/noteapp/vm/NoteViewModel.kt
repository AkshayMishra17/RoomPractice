package com.example.noteapp.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.noteapp.model.Note
import com.example.noteapp.model.NoteDB
import com.example.noteapp.repo.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(application: Application):AndroidViewModel(application){
    private val repository:NoteRepository
    val allNotes:LiveData<List<Note>>

    init {
        val noteDao = NoteDB.getDatabase(application).noteDao()
        repository = NoteRepository(noteDao)
        allNotes = repository.allNotes
    }

    fun addNote(title:String,body:String){
        viewModelScope.launch {
            repository.addNote(Note(title = title, body = body))
        }
    }
    fun deleteNote(note: Note){
        viewModelScope.launch {
            repository.deleteNote(note)
        }
    }
    fun updateNote(note: Note){
        viewModelScope.launch {
            repository.updateNote(note)
        }
    }

}