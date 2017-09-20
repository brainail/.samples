package org.brainail.Everboxing.sample.NetworkPaging

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object KitsuRestApi {
    private val kitsuApi: KitsuSpecApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://kitsu.io/api/edge/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        kitsuApi = retrofit.create(KitsuSpecApi::class.java)
    }

    fun getKitsu(filter: String, offset: Int, limit: Int): Call<KitsuResponse> {
        return kitsuApi.filterKitsu(filter, limit, offset)
    }
}