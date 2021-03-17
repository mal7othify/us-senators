package com.example.ussenators.domain.model

import com.google.gson.annotations.SerializedName

class Senator {
    @SerializedName("caucus")
    val caucus: Any? = null

    @SerializedName("congress_numbers")
    val congress_numbers: List<Int> = listOf()

    @SerializedName("current")
    val current: Boolean = false

    @SerializedName("description")
    val description: String = ""

    @SerializedName("district")
    val district: Any? = null

    @SerializedName("enddate")
    val enddate: String = ""

    @SerializedName("extra")
    val extra: Extra? = null

    @SerializedName("leadership_title")
    val leadership_title: Any? = null

    @SerializedName("party")
    val party: String = ""

    @SerializedName("person")
    val person: Person? = null

    @SerializedName("phone")
    val phone: String = ""

    @SerializedName("role_type")
    val role_type: String = ""

    @SerializedName("role_type_label")
    val role_type_label: String = ""

    @SerializedName("senator_class")
    val senator_class: String = ""

    @SerializedName("senator_class_label")
    val senator_class_label: String = ""

    @SerializedName("senator_rank")
    val senator_rank: String = ""

    @SerializedName("senator_rank_label")
    val senator_rank_label: String = ""

    @SerializedName("startdate")
    val startdate: String = ""

    @SerializedName("state")
    val state: String = ""

    @SerializedName("title")
    val title: String = ""

    @SerializedName("title_long")
    val title_long: String = ""

    @SerializedName("website")
    val website: String = ""
}
