package org.brainail.Everboxing.sample.NetworkPaging

import android.arch.paging.LivePagedListProvider

object KitsuMediaPagedListProvider {
    private val dataSource = object: KitsuLimitOffsetNetworkDataSource<KitsuItem>(KitsuRestApi) {
        override fun convertToItems(items: KitsuResponse, size: Int): List<KitsuItem> {
            return List(size, { index ->
                items.data.elementAtOrElse(index, { KitsuItem(0, null, null) })
            })
        }
    }

    fun allKitsu(): LivePagedListProvider<Int, KitsuItem> {
        return object : LivePagedListProvider<Int, KitsuItem>() {
            override fun createDataSource(): KitsuLimitOffsetNetworkDataSource<KitsuItem> = dataSource
        }
    }

    fun setQueryFilter(queryFilter: String) {
        dataSource.queryFilter = queryFilter
    }
}