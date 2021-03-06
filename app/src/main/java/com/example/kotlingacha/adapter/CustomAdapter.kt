package com.example.kotlingacha.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlingacha.R
import com.example.kotlingacha.activity.CardViewActivity
import com.example.kotlingacha.obj.Inventory
import com.squareup.picasso.Picasso

class CustomAdapter(private val context: Context) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = Inventory.inventoryData[position]

        Picasso.get()
            .load(itemsViewModel.image)
            .into(holder.imageView)

        // sets the text to the textview from our itemHolder class
        holder.textView.text = itemsViewModel.name

        holder.imageView.setOnClickListener{
            val intent = Intent(context, CardViewActivity::class.java)

            intent.putExtra(CardViewActivity.IMAGE, itemsViewModel.image)
            intent.putExtra(CardViewActivity.NAME, holder.textView.text)
            intent.putExtra(CardViewActivity.HEIGHT, itemsViewModel.height)
            intent.putExtra(CardViewActivity.POKEDEXID, itemsViewModel.pokedexid)
            intent.putExtra(CardViewActivity.WEIGHT, itemsViewModel.weight)
            intent.putExtra(CardViewActivity.TYPE1, itemsViewModel.type1)
            intent.putExtra(CardViewActivity.TYPE2, itemsViewModel.type2)
            intent.putExtra(CardViewActivity.ID, position)

            context.startActivity(intent)

            //Log.d("Item", ItemsViewModel.text)
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return Inventory.inventoryData.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.cardImageButton)
        val textView: TextView = itemView.findViewById(R.id.nameTextView)
    }
}