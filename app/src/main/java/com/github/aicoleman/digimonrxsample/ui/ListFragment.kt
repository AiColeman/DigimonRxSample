package com.github.aicoleman.digimonrxsample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.github.aicoleman.digimonrxsample.R
import com.github.aicoleman.digimonrxsample.databinding.FragmentListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding
    val viewModel by viewModels<DigimonViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.swipe.setOnRefreshListener {
            viewModel.getDigimonList()
            binding.swipe.isRefreshing = false
        }

        binding.recycler.adapter = DigimonListAdapter(requireContext(), this)

        binding.swipe.isRefreshing = true
        viewModel.getDigimonList()

        viewModel.digimonListLiveData.observe(
            viewLifecycleOwner, Observer {
                (binding.recycler.adapter as DigimonListAdapter).addDigimonList(it)
                binding.swipe.isRefreshing = false
            }
        )
    }
}