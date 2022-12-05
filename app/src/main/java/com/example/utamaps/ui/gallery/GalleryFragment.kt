package com.example.utamaps.ui.gallery

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.utamaps.MapaGeneral
import com.example.utamaps.databinding.FragmentDeptosBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentDeptosBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentDeptosBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnDeptoFisica.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.49148679859103)
            Intent.putExtra("dir2", -70.29703741095733)
            startActivity(Intent)
        })

        binding.btnDeptoMate.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.491786958312865)
            Intent.putExtra("dir2", -70.29679601214598)
            startActivity(Intent)
        })

        binding.btnDeptoIcci.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.489173929600813)
            Intent.putExtra("dir2", -70.29522556891044)
            startActivity(Intent)
        })

        binding.btnDeptoMecanica.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.488392336243813)
            Intent.putExtra("dir2", -70.2951583984441)
            startActivity(Intent)
        })

        binding.btnDeptoIngIndustrial.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.489353952888514)
            Intent.putExtra("dir2", -70.29532046967594)
            startActivity(Intent)
        })

        binding.btnDeptoEdFisica.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.491176463409428)
            Intent.putExtra("dir2", -70.29624750040242)
            startActivity(Intent)
        })

        binding.btnDeptoIngElectronicaElectricidad.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.48954023108477)
            Intent.putExtra("dir2", -70.29501367439829)
            startActivity(Intent)
        })

        binding.btnDeptoMedicina.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.49201998031831)
            Intent.putExtra("dir2", -70.29768833560952)
            startActivity(Intent)
        })

        binding.btnDeptoTrabajoSocial.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.48898455652978)
            Intent.putExtra("dir2", -70.29506239539923)
            startActivity(Intent)
        })

        binding.btnDeptoPsicologia.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.48859198938051)
            Intent.putExtra("dir2", -70.29443481002114)
            startActivity(Intent)
        })

        binding.btnDeptoLabMecanica.setOnClickListener(View.OnClickListener(){
            val Intent = Intent(activity, MapaGeneral::class.java)
            Intent.putExtra("dir", -18.488745296430412)
            Intent.putExtra("dir2", -70.29567738632329)
            startActivity(Intent)
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}