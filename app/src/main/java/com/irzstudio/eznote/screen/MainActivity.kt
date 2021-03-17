package com.irzstudio.eznote.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.irzstudio.eznote.R
import com.irzstudio.eznote.adapter.ListNoteAdapter
import com.irzstudio.eznote.data.Note
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottomsheet_fragment.*
import kotlinx.android.synthetic.main.empty_screen.*

class MainActivity : AppCompatActivity() {

    private val dataNote: ArrayList<Note> = ArrayList()

    lateinit var adapterNote : ListNoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomSheetFragment = BottomSheetFragment()

        //btn_show.setOnClickListener {
            bottomSheetFragment.show(supportFragmentManager, "BottomSheetDialog")


        /*BottomSheetBehavior.from(layout_sheet).apply {
            peekHeight = 200
            this.state = BottomSheetBehavior.STATE_COLLAPSED
        }*/

        showDataAdapter()

    }

    private fun showDataAdapter() {

        /*
        val noteDummy = Note(tittle = "Resep Makanan", content = "In android, TextView is a user")
        val noteDummy2 = Note(tittle = "Catatan Sekoah", content = "In android, TextView is a user")
        val noteDummy3 = Note(tittle = "Daily", content = "In android, TextView is a user")
        val noteDummy4 = Note(tittle = "Jadwal Belajar", content = "In android, TextView is a user")
        val noteDummy5 = Note(tittle = "Progres Kerja", content = "In android, TextView is a user")
        val noteDummy6 = Note(tittle = "Tempat Wisata", content = "In android, TextView is a user")

        dataNote.add(noteDummy)
        dataNote.add(noteDummy2)
        dataNote.add(noteDummy3)
        dataNote.add(noteDummy4)
        dataNote.add(noteDummy5)
        dataNote.add(noteDummy6)

         */

        if (dataNote.size == 0){
            recyclerview_note.visibility = View.GONE
            layout_empty.visibility = View.VISIBLE
        }else{
            recyclerview_note.visibility = View.VISIBLE
            layout_empty.visibility = View.GONE
        }


           adapterNote = ListNoteAdapter(dataNote)

        recyclerview_note.adapter = adapterNote
        recyclerview_note.layoutManager = LinearLayoutManager(this)

    }


}

