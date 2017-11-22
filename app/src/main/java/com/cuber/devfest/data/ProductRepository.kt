package com.cuber.devfest.data

import android.support.annotation.VisibleForTesting
import com.cuber.devfest.data.model.Product
import com.cuber.devfest.data.source.local.LocalProductSource
import com.cuber.devfest.data.source.remote.RemoteProductSource
import io.reactivex.Single

class ProductRepository(

        private var remoteProductSource: ProductRepositoryImp,
        private var localProductSource: ProductRepositoryImp

) : ProductRepositoryImp {

    override fun getProductById(productId: String): Single<Product> {
        return remoteProductSource.getProductById(productId)
                .onErrorReturn { localProductSource.getProductById(productId).blockingGet() }
    }

    override fun getProductList(): Single<List<Product>> {
        return remoteProductSource.getProductList()
                .onErrorReturn { localProductSource.getProductList().blockingGet() }
    }

    companion object {

        private var INSTANCE: ProductRepository? = null

        @JvmStatic
        fun getInstance(): ProductRepository {
            return INSTANCE ?: ProductRepository(

                    RemoteProductSource.getInstance(),

                    LocalProductSource.getInstance())

                    .apply { INSTANCE = this }
        }

        @VisibleForTesting
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}