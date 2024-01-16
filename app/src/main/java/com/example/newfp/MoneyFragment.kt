package com.example.newfp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.*


class MoneyFragment : Fragment() {

    private lateinit var adapter: MyAdapter
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<News>

    private lateinit var imageId: Array<Int>
    private lateinit var heading: Array<String>
    private lateinit var news: Array<String>
    private lateinit var biasa : Array<String>
    private lateinit var rego : Array<String>


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_money, container, false)
        val btntambah : ImageView = view.findViewById(R.id.tambah)
        btntambah.setOnClickListener {
            val fragment = FragmentTambahTransaksi()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainer,fragment)?.commit()
        }
        val btnaci : ImageView= view.findViewById(R.id.account)
        btnaci.setOnClickListener {
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
            R.drawable.duitmasuk,
            R.drawable.duitkeluar,
            R.drawable.duitmasuk,
            R.drawable.duitkeluar,
            R.drawable.duitmasuk,
            R.drawable.duitkeluar,
            R.drawable.duitmasuk,
            R.drawable.duitkeluar

            )
        heading = arrayOf(
            "Penjualan Messi",
            "Pembelian Amikom",
            "Penjualan Kucing",
            "Pembelian Manusia",
            "Penjualan Saham",
            "Pembelian Rumah",
            "Penjualan Hotel",
            "Pembelian Pulau",


            )
        news = arrayOf(
            "p1",
            "p1",
            "p1",
            "p1",
            "p1",
            "p1",
            "p1",
        )
        biasa = arrayOf(
            "2 June 2022",
            "12 June 2022",
            "13 June 2022",
            "23 June 2022",
            "27 June 2022",
            "29 June 2022",
            "30 June 2022",
            "2 September 2022"

        )
        rego = arrayOf(
            "+Rp. 200.000.000",
            "-Rp. 1.200.000.000",
            "+Rp. 200.000",
            "+Rp. 400.000",
            "+Rp. 500.000",
            "+Rp. 600.000",
            "+Rp. 700.000",
            "+Rp. 800.000"
        )

        for (i in imageId.indices) {
            val news = News(imageId[i], heading[i],biasa[i],rego[i])
            newArrayList.add(news)

        }
    }
}