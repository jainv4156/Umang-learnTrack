package com.example.umanglearntrack.Data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID


@Entity(tableName = "sessionsTable")
data class SessionsModel(
    @PrimaryKey
    val sessionId: String=UUID.randomUUID().toString(),
    val sessionName: String,
    val date: String,
    val startTime: String,
    val endTime: String?,
    val facilitatorId: String,
    val status:Int=0
)
