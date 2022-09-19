package es.maincode.altentest.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseActivity: AppCompatActivity()

fun AppCompatActivity.closeFragment(fragment: Fragment) {
    supportFragmentManager.commit {
        remove(fragment)
    }
}