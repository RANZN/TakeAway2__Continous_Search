package com.ranzan.takeaway2.view

import android.os.Parcelable
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Suggestions(val suggestion: String) : Parcelable, SearchSuggestion {

    override fun getBody(): String {
        return suggestion
    }

}