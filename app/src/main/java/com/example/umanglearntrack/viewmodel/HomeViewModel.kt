package com.example.umanglearntrack.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.umanglearntrack.Data.AppDatabase
import com.example.umanglearntrack.Data.SessionRepository
import com.example.umanglearntrack.Data.dao.SessionDao
import com.example.umanglearntrack.Data.model.SessionsModel
import com.example.umanglearntrack.databinding.FragmentAddSessionBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class HomeViewModel(context: Context):ViewModel() {


    private val sessionDao: SessionDao = AppDatabase.getDatabase(context =context).sessionDao
    private val repository: SessionRepository = SessionRepository(sessionDao)
    var allSessions:LiveData<List<SessionsModel>> = repository.getAllSessionsFromDb().asLiveData()
init {
    Log.d("message",allSessions.value.toString())
}
    fun addSessionInDb(binding: FragmentAddSessionBinding) {
        if(binding.editTextSessionName.text.toString().isNotEmpty() && binding.editTextDate.text.toString().isNotEmpty() && binding.editTextStartTime.text.toString().isNotEmpty() && binding.editTextEndTime.text.toString().isNotEmpty() && binding.editTextFacilitatorId.text.toString().isNotEmpty()) {
            viewModelScope.launch {
                repository.addSessionInDb(SessionsModel( sessionName = binding.editTextSessionName.text.toString(), date = binding.editTextDate.text.toString(), startTime = binding.editTextStartTime.text.toString(), endTime = binding.editTextEndTime.text.toString(), facilitatorId = binding.editTextFacilitatorId.text.toString()))
            }
        }
    }

}