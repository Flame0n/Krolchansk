package com.example.krolchansk.ui.assortment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.krolchansk.R
import kotlinx.android.synthetic.main.fragment_assortment.*

class AssortmentFragment : Fragment() {

    lateinit var assortmentViewModel: AssortmentViewModel
    lateinit var recyclerAdapter: AssortmentRecyclerAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        assortmentViewModel =
                ViewModelProviders.of(this).get(AssortmentViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_assortment, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerAdapter = AssortmentRecyclerAdapter(this)
        recycler_view_assortment.adapter = recyclerAdapter
    }
}