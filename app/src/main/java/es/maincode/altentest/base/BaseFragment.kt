package es.maincode.altentest.base

import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import es.maincode.altentest.view.activities.MainActivity

@AndroidEntryPoint
open class BaseFragment(layout: Int) : Fragment(layout) {
    fun onBackPressed() = (requireActivity() as MainActivity).onBackPressed()
}