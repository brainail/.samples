package org.brainail.Everboxing.sample.NetworkPaging

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface KitsuSpecApi {
    @GET("anime")
    fun filterKitsu(
            @Query("filter[text]") filter: String,
            @Query("page[limit]") limit: Int,
            @Query("page[offset]") offset: Int): Call<KitsuResponse>
}