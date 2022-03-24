package com.gbm.gamebikm.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dakulangsakalam.customwebview.presentation.ui.jump.JumpActivity
import com.gbm.gamebikm.R
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class SplashActivity : JumpActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splashAction { _, _ ->
            startActivity(MainActivity.createIntent(this))
            finish()
        }
    }
}