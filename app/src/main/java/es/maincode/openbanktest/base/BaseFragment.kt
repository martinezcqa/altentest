package es.maincode.openbanktest.base

import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import es.maincode.openbanktest.view.activities.MainActivity

@AndroidEntryPoint
open class BaseFragment(layout: Int) : Fragment(layout) {

    fun onBackPressed() = (requireActivity() as MainActivity).onBackPressed()
}