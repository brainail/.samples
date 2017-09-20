package org.brainail.Everboxing.sample.NetworkPaging

import android.arch.paging.PagedListAdapter
import android.support.v7.recyclerview.extensions.DiffCallback
import android.view.ViewGroup

class KitsuPagedListAdapter : PagedListAdapter<KitsuItem, KitsuViewHolder>(diffCallback) {
    override fun onBindViewHolder(holder: KitsuViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KitsuViewHolder = KitsuViewHolder(parent)

    companion object {
        private val diffCallback = object : DiffCallback<KitsuItem>() {
            override fun areItemsTheSame(oldItem: KitsuItem, newItem: KitsuItem): Boolean = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: KitsuItem, newItem: KitsuItem): Boolean = oldItem == newItem
        }
    }
}