package com.autonotify.model

import androidx.room.*

@Dao
interface MessageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(message: Message)

    @Query("SELECT * FROM messages ORDER BY id DESC LIMIT 5")
    suspend fun getRecentMessages(): List<Message>
}
