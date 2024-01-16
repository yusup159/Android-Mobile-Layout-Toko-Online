package com.example.newfp

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newfp.databinding.FragmentSettingBinding


class SettingFragment() : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val bin = FragmentSettingBinding.inflate(layoutInflater)
        bin.logout.setOnClickListener {
            val intent = Intent(this@SettingFragment.requireContext(),Login::class.java)
            startActivity(intent)
        }

        // Inflate the layout for this fragment
        return bin.root
    }


}