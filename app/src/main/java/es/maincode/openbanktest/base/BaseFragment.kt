package es.maincode.openbanktest.base

import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseFragment(layout: Int) : Fragment(layout)