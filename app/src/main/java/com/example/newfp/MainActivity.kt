package com.example.newfp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton


class MainActivity : AppCompatActivity() {

    private lateinit var onboardingItemAdapter: OnboardingItemAdapter
    private lateinit var indicatorsContainer : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOnboardingItems()
        setupIndicators()
        setCurrentIndicator(0)

        val ProductFragment = ProductFragment()
        val settingFragment = SettingFragment()
    }
    private fun setOnboardingItems(){
        onboardingItemAdapter = OnboardingItemAdapter(
            listOf(
                OnboardingItem(
                    onboardingImage = R.drawable.larry,
                    title = "QUOTES 1",
                    description = "Rasah kakean CANGKEM"

                ),
                OnboardingItem(
                    onboardingImage = R.drawable.larryok,
                    title = "Hidup Seperti Larry",
                    description = "pak Sam D Racing Team"

                ),
                OnboardingItem(
                    onboardingImage = R.drawable.patrick,
                    title = "BENGKEL",
                    description = "Bengkel Motor"

                )
            )
        )
        val onboardingViewPager = findViewById<ViewPager2>(R.id.onboardingViewPager)
        onboardingViewPager.adapter=onboardingItemAdapter
        onboardingViewPager.registerOnPageChangeCallback(object  :ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        (onboardingViewPager.getChildAt(0) as RecyclerView).overScrollMode=RecyclerView.OVER_SCROLL_NEVER
        findViewById<ImageView>(R.id.img_next).setOnClickListener {
            if (onboardingViewPager.currentItem + 1 < onboardingItemAdapter.itemCount){
                onboardingViewPager.currentItem += 1
            }else{
                navigatedToLoginActivity()
            }
        }
        findViewById<TextView>(R.id.textSkip).setOnClickListener {
            navigatedToLoginActivity()
        }
        findViewById<MaterialButton>(R.id.button_started).setOnClickListener{
            navigatedToLoginActivity()
        }
    }
    private fun navigatedToLoginActivity(){
        startActivity(Intent(applicationContext,Login::class.java))
        finish()
    }

    private fun setupIndicators(){
        indicatorsContainer = findViewById(R.id.indicatorContent)
        val indicators = arrayOfNulls<ImageView>(onboardingItemAdapter.itemCount)
        val layoutParams:LinearLayout.LayoutParams = LinearLayout.LayoutParams(WRAP_CONTENT,
            WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)
        for (i in indicators.indices){
            indicators[i] = ImageView(applicationContext)
            indicators[i]?.let {
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inative_bg
                    )
                )
                it.layoutParams =layoutParams
                indicatorsContainer.addView(it)
            }
        }
    }
    private fun setCurrentIndicator(position: Int){
        val chilCount = indicatorsContainer.childCount
        for (i in 0 until chilCount){
            val imageView = indicatorsContainer.getChildAt(i) as ImageView
            if (i   == position){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,R.drawable.indicator_active_bg
                    )
                )
            }else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,R.drawable.indicator_inative_bg
                    )
                )
            }
        }
    }
}