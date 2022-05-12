package com.groupal.marketplace.data.model

import com.google.gson.annotations.SerializedName

class Category (
    @SerializedName("category") var category: String,
    @SerializedName("path") var path: String,
)