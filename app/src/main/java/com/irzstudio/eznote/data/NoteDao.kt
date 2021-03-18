package com.irzstudio.eznote.data

import android.icu.text.CaseMap
import androidx.room.*

@Dao
interface NoteDao {
    @Query("SELECT * From note")
    fun getAll():List<Note>

    @Insert //(onConflict = REPLACE), agar id tidak ad yg sama ketika tanpa autogenerate
    fun insert(note: Note)

    @Delete
    fun delete(note: Note)

  /*  @Query("UPDATE note SET tittle =: noteTittle, content =: noteContent WHERE id =: noteId")
    fun update(noteId:Int, noteTitle:String, noteContent:String)*/

}