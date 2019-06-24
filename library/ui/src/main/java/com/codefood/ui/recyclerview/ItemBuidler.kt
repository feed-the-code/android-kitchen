package com.codefood.ui.recyclerview

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codefood.ui.inflate
import kotlin.properties.Delegates

fun <T> listAdapter(block: ListAdapterBuilder<T>.() -> Unit): ListAdapter<T, RecyclerView.ViewHolder> =
    ListAdapterBuilder<T>().apply(block).build()

typealias ViewBinding<T> = View.(T) -> Unit

class ListAdapterBuilder<T> {
    var items: List<T>? = null
    var diff: DiffUtil.ItemCallback<T>? = null
    var layout: Int by Delegates.notNull()
    var binding: ViewBinding<T> = {}

    fun bindLayout(@LayoutRes layout: Int, binding: ViewBinding<T>) {
        this.layout = layout
        this.binding = binding
    }

    fun build() =
        object : ListAdapter<T, RecyclerView.ViewHolder>(diff ?: Diff()) {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
                ViewHolder(parent inflate layout)

            override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                holder.itemView.binding(getItem(position))
            }
        }.apply { submitList(items ?: emptyList()) }
}

private class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

private class Diff<T> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }
}