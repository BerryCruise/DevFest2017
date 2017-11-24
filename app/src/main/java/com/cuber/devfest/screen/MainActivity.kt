package com.cuber.devfest.screen

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.cuber.devfest.R
import com.cuber.devfest.data.source.local.preference.PreferencesKey
import com.cuber.devfest.data.source.local.preference.PreferencesProvider
import com.cuber.devfest.screen.product.detail.ProductDetailFragment
import com.cuber.devfest.screen.product.list.ProductListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.container, ProductListFragment())
                    .commit()
        }

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()

            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ProductDetailFragment())
                    .addToBackStack(null)
                    .commit()
        }

        PreferencesProvider.getInstance().put(PreferencesKey.TOKEN_AUTH, "111")

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
