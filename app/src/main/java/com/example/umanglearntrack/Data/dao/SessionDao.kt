package com.example.umanglearntrack.Data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.umanglearntrack.Data.model.SessionsModel
import kotlinx.coroutines.flow.Flow

@Dao
interface SessionDao {
    @Insert
    suspend fun insertSessionInDb(session: SessionsModel)

    @Query("SELECT * FROM sessionsTable WHERE sessionId = :sessionId")
    suspend fun getSessionDataById(sessionId: String): SessionsModel?

    @Query("SELECT * FROM sessionsTable")
    fun getAllSessions(): Flow<List<SessionsModel>>
}
