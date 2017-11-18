package com.cuber.devfest.ui.product.list

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cuber.devfest.R
import com.cuber.devfest.data.model.Product

/**
 * A placeholder fragment containing a simple view.
 */
class ProductListFragment : Fragment(), ProductListContract.View {

    private lateinit var presenter: ProductListPresenter
    private lateinit var categoryId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // data init
        arguments?.run {
            categoryId = getString(ARG_CATEGORY_ID)
        }

        savedInstanceState?.run {

        }

        presenter = ProductListPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_first, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getProductList(categoryId)
    }

    override fun onGetProductList(productList: List<Product>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onGetProductListError(throwable: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        val ARG_CATEGORY_ID = "ARG_CATEGORY_ID"
    }
}