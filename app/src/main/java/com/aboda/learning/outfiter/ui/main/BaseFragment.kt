package com.aboda.learning.outfiter.ui.main

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.aboda.learning.outfiter.ui.utils.TODAY

abstract class BaseFragment<viewBinding : ViewBinding> : Fragment() {

    abstract val bindingInflater: (LayoutInflater) -> viewBinding
    private var _binding: viewBinding? = null

    protected val binding: viewBinding
        get() = _binding as viewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = bindingInflater(layoutInflater)
        return _binding!!.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun <T : Parcelable> createArgument(value: T) =
        this.apply {
            arguments = Bundle().apply {
                putParcelable(TODAY, value)
            }
        }
}