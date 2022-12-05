package com.example.utamaps.ui.anexos

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.utamaps.MapaGeneral
import com.example.utamaps.databinding.FragmentAnexosBinding


class AnexoFragment : Fragment() {

    private var _binding: FragmentAnexosBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAnexosBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnAnexoBiblioteca.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.4904001837511)
            Intent.putExtra("dir2", -70.29579889789869)
            startActivity(Intent)
        })

        binding.btnAnexoDirGenero.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.490682220513435)
            Intent.putExtra("dir2", -70.29591946107949)
            startActivity(Intent)
        })

        binding.btnAnexoBodega.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.490156423327846)
            Intent.putExtra("dir2", -70.29691000602902)
            startActivity(Intent)
        })

        binding.btnAnexoFotocopiadoras.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.490156423327846)
            Intent.putExtra("dir2", -70.29691000602902)
            startActivity(Intent)
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}