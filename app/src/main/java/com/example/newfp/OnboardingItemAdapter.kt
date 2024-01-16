package com.example.newfp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OnboardingItemAdapter(private val onboardingItem : List<OnboardingItem>) :
    RecyclerView.Adapter<OnboardingItemAdapter.OnboardingItemViewHolder>() {

    inner class OnboardingItemViewHolder(view : View) :RecyclerView.ViewHolder(view){
        private val imageOnboarding = view.findViewById<ImageView>(R.id.imageOnboarding)
        private val textTittle = view.findViewById<TextView>(R.id.textTittle)
        private val textDescription = view.findViewById<TextView>(R.id.textDescrition)

        fun bin(onboardingItem :OnboardingItem){
            imageOnboarding.setImageResource(onboardingItem.onboardingImage)
            textTittle.text =onboardingItem.title
            textDescription.text =onboardingItem.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingItemViewHolder {
        return OnboardingItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.on_boarding_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnboardingItemViewHolder, position: Int) {
     holder.bin(onboardingItem[position])
    }

    override fun getItemCount(): Int {
        return onboardingItem.size
    }
}