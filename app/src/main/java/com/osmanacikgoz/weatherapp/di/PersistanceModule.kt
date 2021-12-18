package com.osmanacikgoz.weatherapp.di

import androidx.room.Room
import com.osmanacikgoz.weatherapp.const.Const
import com.osmanacikgoz.weatherapp.room.AppDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val persistenceModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDataBase::class.java,
            Const.DB_NAME
        )
            .allowMainThreadQueries()
            .build()
    }
    single {
        get<AppDataBase>().searchDao()
    }

}
