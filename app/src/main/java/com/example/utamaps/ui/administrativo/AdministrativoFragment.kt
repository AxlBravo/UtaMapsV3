package com.example.utamaps.ui.administrativo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.utamaps.MapaGeneral
import com.example.utamaps.databinding.FragmentAdministrativoBinding


class AdministrativoFragment : Fragment() {

    private var _binding: FragmentAdministrativoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAdministrativoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnAdminCobranzas.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.490361194950673)
            Intent.putExtra("dir2", -70.29695828579129)
            startActivity(Intent)
        })

        binding.btnAdminDocencia.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.490691881535135)
            Intent.putExtra("dir2", -70.29650767467683)
            startActivity(Intent)
        })

        binding.btnAdminExtension.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.48791958956166)
            Intent.putExtra("dir2", -70.29491975102871)
            startActivity(Intent)
        })

        binding.btnAdminDmz.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.49023019201519)
            Intent.putExtra("dir2", -70.297025341201666)
            startActivity(Intent)
        })

        binding.btnAdminDae.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.49029251381253)
            Intent.putExtra("dir2", -70.29667531274023)
            startActivity(Intent)
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}