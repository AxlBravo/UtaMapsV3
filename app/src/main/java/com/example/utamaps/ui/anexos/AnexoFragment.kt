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
            Intent.putExtra("dir", -18.490588860011812)
            Intent.putExtra("dir2", -70.29685099743075)
            startActivity(Intent)
        })

        binding.btnAnexoSalaEstudio.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.48873952807754)
            Intent.putExtra("dir2", -70.29515632424628)
            startActivity(Intent)
        })

        binding.btnAnexoCasino.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.488792947227097)
            Intent.putExtra("dir2", -70.29493370089804)
            startActivity(Intent)
        })

        binding.btnAnexoExplora.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.488449548881064)
            Intent.putExtra("dir2", -70.29457929995948)
            startActivity(Intent)
        })

        binding.btnAnexoFeuch.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.488500413577974)
            Intent.putExtra("dir2", -70.29479422602915)
            startActivity(Intent)
        })

        binding.btnAnexoPreUniversitario.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.488349684672784)
            Intent.putExtra("dir2", -70.29471238608228)
            startActivity(Intent)
        })

        binding.btnAnexoPreUniversitario.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.491762981042996)
            Intent.putExtra("dir2", -70.29631605659635)
            startActivity(Intent)
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}