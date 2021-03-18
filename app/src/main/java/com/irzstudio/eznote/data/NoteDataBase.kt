package com.irzstudio.eznote.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract class NoteDataBase : RoomDatabase() {

    abstract fun noteDao() : NoteDao
    companion object{
        private var INSTANCE: NoteDataBase? = null

        fun getInstance(context: Context): NoteDataBase? {
            if (INSTANCE == null) {
                synchronized(NoteDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                                NoteDataBase::class.java, "notedata.db").allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}