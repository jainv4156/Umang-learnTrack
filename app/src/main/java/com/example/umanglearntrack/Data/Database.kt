package com.example.umanglearntrack.Data

import android.content.Context
import androidx.room.Room
import android.util.Log
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.umanglearntrack.Data.dao.SessionDao
import com.example.umanglearntrack.Data.model.SessionsModel
import com.example.umanglearntrack.MyApplication

@Database(entities = [SessionsModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val sessionDao: SessionDao
    companion object {
        fun getDatabase(context: Context): AppDatabase {
            val db = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "umang_database"
            ).build()
            Log.d("MyApplication", db.toString())
            return db
        }
    }
}

