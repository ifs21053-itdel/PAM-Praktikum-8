package com.ifs21053.pampraktikum8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21053.pampraktikum8.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        // Tambahkan OnClickListener pada fabAdd
        binding.fabAdd.setOnClickListener {
            showToast("Button Menambahkan Email Baru")
        }
    }

    private fun setupRecyclerView() {
        val sender = resources.getStringArray(R.array.kontak_nama)
        val icon = resources.getStringArray(R.array.kontak_icon)
        val description = resources.getStringArray(R.array.kontak_deskripsi)

        val kontaklist = mutableListOf<Kontak>()

        for (i in sender.indices) {
            kontaklist.add(
                Kontak(
                    resources.getIdentifier(icon[i], "drawable", requireContext().packageName),
                    sender[i],
                    description[i]
                )
            )
        }

        val adapter = ListKontakAdapter(requireContext(), kontaklist) { kontak ->
            val message = "You've got an email from: ${kontak.name}"
            showToast(message)
        }

        binding.rvKontak.layoutManager = LinearLayoutManager(requireContext())
        binding.rvKontak.adapter = adapter
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val EXTRA_MESSAGE = "extra_message"
    }
}
