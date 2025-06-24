package com.autonotify.model

import androidx.room.*

@Dao
interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(contact: Contact)

    @Query("SELECT * FROM contacts ORDER BY id DESC LIMIT 5")
    suspend fun getRecentContacts(): List<Contact>
}
