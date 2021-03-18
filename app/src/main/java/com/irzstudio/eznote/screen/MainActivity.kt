package com.irzstudio.eznote.screen

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.irzstudio.eznote.R
import com.irzstudio.eznote.adapter.ListNoteAdapter
import com.irzstudio.eznote.data.Note
import com.irzstudio.eznote.data.NoteDataBase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottomsheet_fragment.*
import kotlinx.android.synthetic.main.empty_screen.*

class MainActivity : AppCompatActivity() {

    private val dataNote: ArrayList<Note> = ArrayList()
    private var database: NoteDataBase? = null

    lateinit var adapterNote: ListNoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = NoteDataBase.getInstance(this)

        btn_createoradd.setOnClickListener {
            val intent = Intent(applicationContext, CreateNoteActivity::class.java)
            startActivity(intent)
        }


        showWelcomeBottomSheetFragment()

    }

    override fun onResume() {
        super.onResume()
        showDataAdapter()
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
        dataNote.clear()
        val dataFromDb = database?.noteDao()?.getAll().orEmpty()
        dataNote.addAll(dataFromDb)


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

