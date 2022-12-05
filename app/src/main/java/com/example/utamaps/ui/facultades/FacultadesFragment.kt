package com.example.utamaps.ui.facultades

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.utamaps.MapaGeneral
import com.example.utamaps.databinding.FragmentFacultadesBinding


class FacultadesFragment: Fragment() {

    private var _binding: FragmentFacultadesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFacultadesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnFacFacsojour.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.488576144251677)
            Intent.putExtra("dir2", -70.29672760595885)
            startActivity(Intent)
        })

        binding.btnFacFacsal1.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.49219295324348)
            Intent.putExtra("dir2", -70.29683539314279)
            startActivity(Intent)
        })

        binding.btnFacFacsal2.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.49250074286322)
            Intent.putExtra("dir2", -70.29687026186)
            startActivity(Intent)
        })

        binding.btnFacFacsal3.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.492556704552847)
            Intent.putExtra("dir2", -70.29717871589669)
            startActivity(Intent)
        })

        binding.btnFacEdHumanidades.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.48815134307969)
            Intent.putExtra("dir2", -70.2944081892302)
            startActivity(Intent)
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}