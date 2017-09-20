package org.brainail.Everboxing.sample.NetworkPaging

class KitsuResponse(
        val data: List<KitsuItem>)

data class KitsuItem(
        val id: Int,
        val type: String?,
        val attributes: KitsuItemAttributes?)

data class KitsuItemAttributes(
        val synopsis: String?,
        val subtype: String?,
        val titles: KitsuItemAttributesTitles?,
        val posterImage: KitsuItemAttributesImage?)

data class KitsuItemAttributesTitles(
        val en_jp: String?)

data class KitsuItemAttributesImage(
        val small: String?)