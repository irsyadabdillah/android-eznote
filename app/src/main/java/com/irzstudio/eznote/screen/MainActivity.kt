package com.irzstudio.eznote.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.irzstudio.eznote.R
import com.irzstudio.eznote.adapter.ListNoteAdapter
import com.irzstudio.eznote.data.Note
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapterNote: ListNoteAdapter
    private  val dataNote: ArrayList<Note> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showDataAdapter()

    }

    private fun showDataAdapter(){
        val noteDummy = Note(tittle = "this is title", content = "This is content of item view")

        dataNote.add(noteDummy)
        dataNote.add(noteDummy)
        dataNote.add(noteDummy)
        dataNote.add(noteDummy)
        dataNote.add(noteDummy)
        dataNote.add(noteDummy)

        adapterNote = ListNoteAdapter(dataNote)

        recyclerview_note.adapter = adapterNote
        recyclerview_note.layoutManager = GridLayoutManager(this, 3)

    }

}

