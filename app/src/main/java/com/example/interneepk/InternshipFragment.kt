package com.example.interneepk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.interneepk.databinding.FragmentInternshipBinding

class InternshipFragment : Fragment() {

    private var _binding: FragmentInternshipBinding? = null
    private lateinit var rvAdapter: RvAdapter
    lateinit var recyclerView: RecyclerView

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentInternshipBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvAdapter = RvAdapter(DataSource.getData())
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = rvAdapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}