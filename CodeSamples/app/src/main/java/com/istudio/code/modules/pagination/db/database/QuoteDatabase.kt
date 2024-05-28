package com.istudio.code.modules.pagination.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.istudio.code.modules.pagination.db.dao.QuoteDao
import com.istudio.code.modules.pagination.db.dao.RemoteKeysDao
import com.istudio.code.modules.pagination.models.QuoteRemoteKeys
import com.istudio.code.modules.pagination.models.Result

@Database(entities = [Result::class, QuoteRemoteKeys::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun quoteDao() : QuoteDao
    abstract fun remoteKeysDao() : RemoteKeysDao
}