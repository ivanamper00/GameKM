package com.gbm.gamebikm.presentation.fragment

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.dakuinternational.common.ui.base.BaseFragment
import com.dakuinternational.common.ui.binding.viewBinding
import com.gbm.gamebikm.R
import com.gbm.gamebikm.databinding.FragmentDashboardBinding
import com.gbm.gamebikm.presentation.adapter.DashboardAdapter

class DashboardFragment: BaseFragment(R.layout.fragment_dashboard) {

    private val binding by viewBinding(FragmentDashboardBinding::bind)

    private val dashboardAdapter by lazy {
        DashboardAdapter(requireActivity() as DashboardAdapter.OnItemClickListener)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews()

    }

    private fun setupViews() {
        with(binding.recyclerView){
            adapter = dashboardAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}