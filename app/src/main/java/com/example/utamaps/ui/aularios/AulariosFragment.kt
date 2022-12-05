package com.example.utamaps.ui.aularios

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.utamaps.MapaGeneral
import com.example.utamaps.databinding.FragmentAulariosBinding
import com.example.utamaps.ui.home.HomeViewModel


class AulariosFragment : Fragment() {

    private var _binding: FragmentAulariosBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAulariosBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnAularioA.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.491013664402754)
            Intent.putExtra("dir2", -70.2967316391296)
            startActivity(Intent)
        })

        binding.btnAularioC.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.491234969267477)
            Intent.putExtra("dir2", -70.29738475702477)
            startActivity(Intent)
        })

        binding.btnAularioD.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.488576144251677)
            Intent.putExtra("dir2", -70.29672760595885)
            startActivity(Intent)
        })

        binding.btnAularioSigloXXI.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.49013720310249)
            Intent.putExtra("dir2", -70.29635147914402)
            startActivity(Intent)
        })

        binding.btnAularioOvidio.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.491176463409428)
            Intent.putExtra("dir2", -70.29624750040242)
            startActivity(Intent)
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}