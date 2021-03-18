package com.irzstudio.eznote.screen

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.irzstudio.eznote.R
import com.irzstudio.eznote.data.Note
import com.irzstudio.eznote.data.NoteDataBase
import kotlinx.android.synthetic.main.create_note.*
import java.util.zip.Inflater


class CreateNoteActivity : AppCompatActivity() {

    private var database: NoteDataBase? = null
    private var noteExtra : Note? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_note)

        database = NoteDataBase.getInstance(this)
        noteExtra = intent.getParcelableExtra("note")

        //menjadikan toolbar ke actionbar
        setSupportActionBar(back_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_round_keyboard_backspace_24)
        supportActionBar?.title = "Create New Note"

        //cara memanggil dengan cara lambda expression
        back_toolbar.setNavigationOnClickListener {
            finish()
        }
        setNoteData()
    }

    private fun setNoteData(){
        if (noteExtra != null){
            txt_tittlenote.setText(noteExtra?.tittle)
            txt_contentnote.setText(noteExtra?.content)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the main_menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.appbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.ic_save -> {
                saveNote()
            }
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }

    private fun saveNote() {
        if (txt_tittlenote.length() == 0 || txt_contentnote.length() == 0) {
            Toast.makeText(applicationContext, "Tittle or content is empty", Toast.LENGTH_SHORT)
                .show()
        } else {
            val tittleNote = txt_tittlenote.text.toString()
            val tittleContent = txt_contentnote.text.toString()

            if (noteExtra == null){
                val note = Note(tittle = tittleNote, content = tittleContent)
                database?.noteDao()?.insert(note)
            }else{
                val note = Note(tittle = tittleNote, content = tittleContent, id = noteExtra?.id ?: 0)
                database?.noteDao()?.update(note)
            }

            finish()

        }
    }
}