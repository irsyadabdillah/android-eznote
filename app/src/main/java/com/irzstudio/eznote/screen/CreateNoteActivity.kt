package com.irzstudio.eznote.screen

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.irzstudio.eznote.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.create_note.*

class CreateNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_note)

        //cara memanggil dengan cara lambda expression
        back_toolbar.setNavigationOnClickListener{
            finish()
        }
        /* cara memanggil dengan interface
        back_toolbar.setNavigationOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                finish()
            }
        })
         */
    }


}