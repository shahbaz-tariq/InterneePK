package com.example.interneepk

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.interneepk.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val name = requireActivity().intent.getStringExtra("name")
        val emailId = requireActivity().intent.getStringExtra("email_id")
        val internship = requireActivity().intent.getStringExtra("internship")
        val city = requireActivity().intent.getStringExtra("city")

        binding.tvName.text = "Name : $name"
        binding.tvEmail.text = "Email : $emailId"
        binding.tvInternship.text = "Internship : $internship"
        binding.tvCity.text = "City : $city"

        binding.btnLogOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}