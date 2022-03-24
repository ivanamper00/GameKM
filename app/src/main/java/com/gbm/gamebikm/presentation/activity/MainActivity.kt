package com.gbm.gamebikm.presentation.activity

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.dakuinternational.common.domain.model.DataContent
import com.dakuinternational.common.ui.binding.viewBinding
import com.dakuinternational.common.ui.dialog.AlertUtils
import com.gbm.gamebikm.R
import com.gbm.gamebikm.databinding.ActivityMainBinding
import com.gbm.gamebikm.presentation.adapter.DashboardAdapter
import com.gbm.gamebikm.presentation.fragment.DashboardFragmentDirections
import com.google.gson.Gson

class MainActivity : AppCompatActivity(), DashboardAdapter.OnItemClickListener {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    private val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.navigation_host) as NavHostFragment
    }

    private val navController get() = navHostFragment.navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    companion object{
        fun createIntent(context: Context): Intent = Intent(context, MainActivity::class.java)
    }

    override fun onItemClick(data: DataContent) {
       val direction = DashboardFragmentDirections.actionDashboardFragmentToDetailsFragment(Gson().toJson(data))
        navController.navigate(direction)
    }

    override fun onBackPressed() {
        if(navHostFragment.childFragmentManager.backStackEntryCount == 0) {
            AlertUtils.alertExit(this){ p0, p1 ->
                when(p1){
                    DialogInterface.BUTTON_POSITIVE -> super.onBackPressed()
                    else ->  p0.dismiss()
                }
            }.show()
        }else super.onBackPressed()
    }
}