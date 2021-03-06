package com.gbm.gamebikm.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.dakuinternational.common.domain.model.DataContent
import com.dakuinternational.common.ui.base.BaseFragment
import com.dakuinternational.common.ui.binding.viewBinding
import com.gbm.gamebikm.R
import com.gbm.gamebikm.databinding.FragmentDetailsBinding
import com.google.gson.Gson


class DetailsFragment : BaseFragment(R.layout.fragment_details) {

    private val binding by viewBinding(FragmentDetailsBinding::bind)
    private val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.item = Gson().fromJson(args.dataContent, DataContent::class.java)

        binding.backButton.setOnClickListener {
            onBackPressed()
        }
    }
}