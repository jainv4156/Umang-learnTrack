package com.example.umanglearntrack.Data

import com.example.umanglearntrack.Data.dao.SessionDao
import com.example.umanglearntrack.Data.model.SessionsModel
import kotlinx.coroutines.flow.Flow

class SessionRepository(private val sessionDao: SessionDao){

    suspend fun addSessionInDb(session:SessionsModel) {
        sessionDao.insertSessionInDb(session)
    }
    suspend fun getSessionDataByIdFromDb(sessionId: String): SessionsModel? {
        return sessionDao.getSessionDataById(sessionId)
    }
    fun  getAllSessionsFromDb(): Flow<List<SessionsModel>> {
        return sessionDao.getAllSessions()
    }
}