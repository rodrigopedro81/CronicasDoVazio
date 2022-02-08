package com.curso.cronicasdovazio.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.curso.cronicasdovazio.R
import com.curso.cronicasdovazio.databinding.FragmentNotificationsBinding
import com.curso.cronicasdovazio.ui.dashboard.SharedViewModel

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: SharedViewModel
    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProvider(this).get(SharedViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}