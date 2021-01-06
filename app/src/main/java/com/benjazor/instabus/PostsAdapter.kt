package com.benjazor.instabus

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.benjazor.instabus.data.Station
import kotlinx.android.synthetic.main.post_row.view.*
import kotlinx.android.synthetic.main.station_row.view.*

class PostsAdapter(private val posts: List<Post>) : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    private var parentContext: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_row, parent, false)
        this.parentContext = parent.context
        return ViewHolder(view)

    }

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position%2==1) {
            holder.itemView.setBackgroundColor(Color.parseColor("#DFDFDF"))
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"))

        }
        val post = posts[position]
        holder.post_content.text = post.Content
        holder.post_image.setImageURI(Uri.parse(post.Path))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val post_content: TextView = itemView.post_content
        val post_image: ImageView = itemView.post_image
    }
}


