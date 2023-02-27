package com.task.ui.components.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.task.R
import com.task.data.dto.network.HomeListModel
import com.task.databinding.FragmentHomeBinding
import com.task.ui.base.BaseFragment
import com.task.ui.components.adapter.HomeAdapter
import com.task.ui.components.callback.PopupMenuCallback
import com.task.ui.components.viewmodel.HomeViewModel
import com.task.utils.SingleEvent
import com.task.utils.observeEvent
import com.task.utils.toGone
import com.task.utils.toVisible
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class HomeFragment : BaseFragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModelHome: HomeViewModel
    private var adapter: HomeAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelHome = ViewModelProvider(this).get(HomeViewModel::class.java)
        observeViewModel()
    }

    override fun initOnClickListener() {
        binding.inlHomeHeader.imgSettingAppHeader.setOnClickListener(this)
    }

    override fun init() {
    }

    override fun appHeaderAction() {
        binding.inlHomeHeader.imgCloseAppHeader.toGone()
        binding.inlHomeHeader.imgLeftArrowAppHeader.toGone()
        binding.inlHomeHeader.imgSettingAppHeader.toVisible()

    }

    override fun observeViewModel() {

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClick(v: View?) {

    }


}