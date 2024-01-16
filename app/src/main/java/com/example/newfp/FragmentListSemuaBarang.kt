package com.example.newfp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class FragmentListSemuaBarang : Fragment() {

    private lateinit var aDapter: AdapterAllBarang
    private lateinit var newrecyclerView: RecyclerView
    private lateinit var newArraylist: ArrayList<NewsAllBarang>

    private lateinit var imageid: Array<Int>
    private lateinit var headingbarang: Array<String>
    private lateinit var biasabarang : Array<String>
    private lateinit var regobarang : Array<String>
    private lateinit var ulasanbar : Array<String>
    private lateinit var jmlbar : Array<String>
    private lateinit var iconbar : Array<Int>
    private lateinit var ratbar : Array<String>
    private lateinit var newsbarang: Array<String>
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list_semua_barang, container, false)
        val tambahbarang : TextView = view.findViewById(R.id.laris)

        tambahbarang.setOnClickListener {
            val fragment = ProductFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainer,fragment)?.commit()
        }
        return  view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        datainitialize()
        val layoutManager = LinearLayoutManager(context)
        newrecyclerView = view.findViewById(R.id.recyclerview)
        newrecyclerView.layoutManager = layoutManager
        newrecyclerView.setHasFixedSize(true)
        aDapter = AdapterAllBarang(newArraylist)
        newrecyclerView.adapter =aDapter

    }
    private fun datainitialize() {
        newArraylist = arrayListOf<NewsAllBarang>()
        imageid = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,

            )
        headingbarang = arrayOf(
            "Tuyul kelas premium",
            "Tuyul kelas standar",
            "Jam tangan ultramen",
            "Mobil second",
            "Diamond ring",


            )
        newsbarang = arrayOf(
            getString(R.string.news_a),
            getString(R.string.news_b),
            getString(R.string.news_c),
            getString(R.string.news_d),
            getString(R.string.news_e),
            getString(R.string.news_f),
            getString(R.string.news_g),
            getString(R.string.news_h),
            getString(R.string.news_i),
        )

        biasabarang = arrayOf(
            "Kab.Wonosobo",
            "Kab.Jogja",
            "Kab.Solo",
            "Kab.Wonosobo",
            "Kab.Jakarta",
        )
        regobarang = arrayOf(
            "+Rp. 200.000",
            "+Rp. 300.000",
            "+Rp. 400.000",
            "+Rp. 500.000",
            "+Rp. 600.000"
        )
        ulasanbar = arrayOf(
            "Ulasan Pengguna",
            "Ulasan Pengguna",
            "Ulasan Pengguna",
            "Ulasan Pengguna",
            "Ulasan Pengguna"
        )
        jmlbar = arrayOf(
            "9.000 Terjual",
            "3.000 Terjual",
            "5.000 Terjual",
            "3.000 Terjual",
            "2.000 Terjual"
        )
        ratbar = arrayOf(
            "5.0 (4500 Ulasan)",
            "4.5 (3210 Ulasan)",
            "4.3 (3000 Ulasan)",
            "4.2 (3200 Ulasan)",
            "4.1 (3100 Ulasan)",
            "4.0 (1500 Ulasan)"

        )


        for (i in imageid.indices) {
            val newsbara = NewsAllBarang(imageid[i], headingbarang[i],biasabarang[i],regobarang[i],ulasanbar[i],jmlbar[i],ratbar[i])
            newArraylist.add(newsbara)

        }
    }


}