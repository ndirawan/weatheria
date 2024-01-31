package com.ndirawan.weatheria.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ndirawan.weatheria.entity.*

@Database(entities = [
    CountryCodeEntity::class,
    MainInfoEntity::class,
    CityEntity::class
                     ],
    exportSchema = false, version = 5)
abstract class AppDatabase : RoomDatabase(){
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getIntance(context: Context): AppDatabase{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "weatheria.db"
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

    abstract fun CountryCodeDao(): CountryCodeDao
    abstract fun MainInfoDao(): MainInfoDao
    abstract fun CityDao(): CityDao
}


