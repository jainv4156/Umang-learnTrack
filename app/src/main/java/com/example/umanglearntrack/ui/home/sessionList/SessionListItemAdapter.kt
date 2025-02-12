package com.example.umanglearntrack.ui.home.sessionList


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.umanglearntrack.Data.model.SessionsModel
import com.example.umanglearntrack.R

class SessionListItemAdapter(
    private val onClick: RecyclerViewClick
):
        RecyclerView.Adapter<SessionListItemAdapter.SessionViewHolder>() {
        private var sessionList = emptyList<SessionsModel>()
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_session_list, parent, false)
            return SessionViewHolder(itemView,onClick)
        }

        override fun onBindViewHolder(holder: SessionViewHolder, position: Int) {
            val currentSession = sessionList[position]
            holder.bind(currentSession)
        }

        class SessionViewHolder(itemView: View, private val listener: RecyclerViewClick) : RecyclerView.ViewHolder(itemView) {
            private val sessionNameTextView: TextView = itemView.findViewById(R.id.textViewSessionName)
            private val sessionDateTextView: TextView = itemView.findViewById(R.id.textViewSessionDate)
            private val sessionTimeTextView: TextView = itemView.findViewById(R.id.textViewSessionTime)
            private val sessionStatusTextView: TextView = itemView.findViewById(R.id.textViewSessionStatus)
            fun bind(session: SessionsModel) {
                itemView.setOnClickListener{
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(session.sessionId)
                    }
                }
                sessionNameTextView.text = session.sessionName
                sessionDateTextView.text = session.date
                sessionTimeTextView.text = session.startTime
                sessionStatusTextView.text = "Upcoming"
            }

        }

    override fun getItemCount() = sessionList.size
    fun setSessions(sessions: List<SessionsModel>) {
        this.sessionList = sessions
        notifyDataSetChanged()
    }
    }
