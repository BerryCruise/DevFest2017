package com.cuber.devfest.data.source.remote.response

import com.cuber.devfest.data.model.Product
import com.google.gson.annotations.SerializedName

data class ProductResponse(

        @SerializedName("product")
        var product: Product

) : BaseResponse()