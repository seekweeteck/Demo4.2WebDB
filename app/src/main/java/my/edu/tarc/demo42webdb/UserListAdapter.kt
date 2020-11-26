package my.edu.tarc.demo42webdb

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class UserListAdapter internal constructor(context: Context) :
    RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var users = emptyList<User>() // Cached copy of user

    //To hold a single record
    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userNameTextView: TextView = itemView.findViewById(R.id.textViewName)
        val userContactTextView : TextView = itemView.findViewById(R.id.textViewContact)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = inflater.inflate(R.layout.user_record, parent, false)
        val userViewHolder = UserViewHolder(itemView)

        //Item click event handler
        userViewHolder.itemView.setOnClickListener {
            Toast.makeText(it.context, "User ID:" + users[userViewHolder.layoutPosition].id, Toast.LENGTH_SHORT).show()
        }
        


        return userViewHolder
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = users[position]
        holder.userNameTextView.text = currentUser.name
        holder.userContactTextView.text = currentUser.contact
    }

    internal fun setUsers(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }

    override fun getItemCount() = users.size
}