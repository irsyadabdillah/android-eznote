package com.irzstudio.eznote.screen

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.irzstudio.eznote.R
import com.irzstudio.eznote.adapter.ListNoteAdapter
import com.irzstudio.eznote.data.Note
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottomsheet_fragment.*
import kotlinx.android.synthetic.main.empty_screen.*

class MainActivity : AppCompatActivity() {

    private val dataNote: ArrayList<Note> = ArrayList()

    lateinit var adapterNote: ListNoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //btn_show.setOnClickListener {

        btn_createoradd.setOnClickListener {
            val intent = Intent(applicationContext, CreateNoteActivity::class.java)
            startActivity(intent)

            /*
            val sp = getSharedPreferences("NotePref", MODE_PRIVATE)
            sp.edit().putString("greetings", "Hello World").apply()
            showGreetingPreference()

             */
        }


        /*
        img_empty.setOnClickListener {
            val sp = getSharedPreferences("NotePref", MODE_PRIVATE)
            sp.edit().remove("greetings").apply()
            showGreetingPreference()
        }

        //BottomSheetDialog yang gagal tidak bisa jalan
            BottomSheetBehavior.from(layout_sheet).apply {
            peekHeight = 200
            this.state = BottomSheetBehavior.STATE_COLLAPSED
        }*/

        showDataAdapter()
        showWelcomeBottomSheetFragment()

    }

    private fun showWelcomeBottomSheetFragment() {
        val sharedPrefereces = getSharedPreferences("prefNote", MODE_PRIVATE)
        val isWelcomeNeverShown = sharedPrefereces.getBoolean("welcome", true)

        val bottomSheetFragment = WelcomeBottomSheetFragment()

        if (isWelcomeNeverShown) {
            bottomSheetFragment.show(supportFragmentManager, "BottomSheetDialog")
            sharedPrefereces.edit().putBoolean("welcome", false).apply()

        }

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

        if (dataNote.size == 0) {
            recyclerview_note.visibility = View.GONE
            layout_empty.visibility = View.VISIBLE
        } else {
            recyclerview_note.visibility = View.VISIBLE
            layout_empty.visibility = View.GONE
        }


        adapterNote = ListNoteAdapter(dataNote)

        recyclerview_note.adapter = adapterNote
        recyclerview_note.layoutManager = LinearLayoutManager(this)

    }


}

