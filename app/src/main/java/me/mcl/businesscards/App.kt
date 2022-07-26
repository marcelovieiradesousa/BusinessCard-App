package me.mcl.businesscards

import android.app.Application
import me.mcl.businesscards.data.AppDatabase
import me.mcl.businesscards.data.BusinessCardRepository

class App: Application() {
    val database by lazy { AppDatabase.getDatabase( this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}