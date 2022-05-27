package es.maincode.openbanktest.view.activities

import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import es.maincode.openbanktest.R
import es.maincode.openbanktest.base.BaseActivity
import es.maincode.openbanktest.base.closeFragment
import es.maincode.openbanktest.view.fragments.DetailFragment
import es.maincode.openbanktest.view.fragments.ListFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<ListFragment>(R.id.container)
        }
    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager.fragments.lastOrNull()
        fragment?.let {
            when(fragment) {
                is ListFragment -> finish()
                is DetailFragment -> closeFragment(it)
            }
        }
    }

}

