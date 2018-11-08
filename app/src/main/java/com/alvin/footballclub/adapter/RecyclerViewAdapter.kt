package com.alvin.footballclub.adapter

import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.alvin.footballclub.R
import com.alvin.footballclub.entity.Item
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

/**
 * Created by Alvin Tandiardi on 19/10/2018.
 */
class RecyclerViewAdapter(private val items: List<Item>, private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemListUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    class ItemListUI : AnkoComponent<ViewGroup> {

        override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(16)

                imageView {
                    id = R.id.club_image_id
                }.lparams(width = dip(50), height = dip(50))

                textView {
                    id = R.id.club_name_id
                }.lparams {
                    margin = dip(16)
                    gravity = Gravity.CENTER_VERTICAL
                }

            }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val name: TextView = view.find(R.id.club_name_id)
        val image: ImageView = view.find(R.id.club_image_id)

        fun bindItem(items: Item, listener: (Item) -> Unit) {
            name.text = items.name
            Glide.with(itemView.context).load(items.image).into(image)
            itemView.setOnClickListener {
                listener(items)
            }
        }

    }
}

