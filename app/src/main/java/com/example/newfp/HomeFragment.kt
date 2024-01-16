package com.example.newfp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {

    private lateinit var adapter: MyAdapter
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<News>

    private lateinit var imageId: Array<Int>
    private lateinit var heading: Array<String>
    private lateinit var biasa : Array<String>
    private lateinit var rego : Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val btnac : ImageView= view.findViewById(R.id.account)
        btnac.setOnClickListener {
            val fragment = SettingFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainer,fragment)?.commit()
        }
        return view

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        datainitialize()
        val layoutManager = LinearLayoutManager(context)
        newRecyclerView = view.findViewById(R.id.recycler_view)
        newRecyclerView.layoutManager = layoutManager
        newRecyclerView.setHasFixedSize(true)
        adapter = MyAdapter(newArrayList)
        newRecyclerView.adapter =adapter

    }
    private fun datainitialize() {
        newArrayList = arrayListOf<News>()
        imageId = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,


            )
        heading = arrayOf(
            "Penjualan Tuyul Kelas premium",
            "Penjualan Pulau",
            "Penjualan Manusia",
            "Penjualan Amikom",
            "Penjualan Ayam",
            "Penjualan Sapi",


            )
        biasa = arrayOf(
            "2 september 2022",
            "4 september 2022",
            "6 september 2022",
            "9 september 2022",
            "10 september 2022",
        )
        rego = arrayOf(
            "+Rp. 200.000.000",
            "+Rp. 1.200.000.000",
            "+Rp. 700.000",
            "+Rp. 900.000",
            "+Rp. 800.000"
        )

        for (i in imageId.indices) {
            val news = News(imageId[i], heading[i],biasa[i],rego[i])
            newArrayList.add(news)

        }
    }
    }
