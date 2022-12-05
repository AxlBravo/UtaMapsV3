//Actualizacion de ubicacion Version FinalV2

package com.example.utamaps

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.utamaps.databinding.ActivityMapaGeneralBinding
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class MapaGeneral : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener{

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapaGeneralBinding
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationCallback: LocationCallback
    private lateinit var btnCalculate:Button

    private var start:String = ""
    private var end:String = ""
    var poly:Polyline? = null


    private val LOG_TAG = "EnviarUbicacion"

    companion object{
        const val REQUEST_CODE_LOCATION = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapaGeneralBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE)
        enableLocation()
        createMarker()
        //createPolyLines()
        mMap.setOnMyLocationButtonClickListener(this)
        mMap.setOnMyLocationClickListener(this)


        val bundle = intent.extras
        val variable = bundle?.getDouble("dir")
        val variable2 = bundle?.getDouble("dir2")

        end = "${variable2}, ${variable}"
        btnCalculate = findViewById(R.id.btnCalculateRoute)
        btnCalculate.setOnClickListener{
            //start = ""
            //end = ""
            poly?.remove()
            poly = null
            Toast.makeText(this, "Selecciona un punto de origen y de llegada", Toast.LENGTH_SHORT).show()
            if (::mMap.isInitialized){
                mMap.setOnMapClickListener {
                    if (start.isEmpty()){
                        //start = "${it.longitude}, ${it.latitude}"
                    }else if(end.isEmpty()){
                        //end = "${it.longitude}, ${it.latitude}"
                        //createRoute()
                    }
                }
                createRoute()
            }
        }


        //Marcador Universidad de Tarapaca
        val universidad = LatLng(-18.490145119500152, -70.29633263195471)
        mMap.addMarker(MarkerOptions().position(universidad).visible(false))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(universidad))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(universidad, 18F), 3000, null)


    }

    private fun createRoute(){
         CoroutineScope(Dispatchers.IO).launch {
             val call = getRetrofit().create(ApiService::class.java).getRoute("5b3ce3597851110001cf6248d522e41edcd94e51852cd0fddfe1970a", start, end)
             if (call.isSuccessful){
                drawRoute(call.body())
             }else{
                 Log.i("aris", "OK")
             }
         }
    }

    private fun drawRoute(routeResponse: RouteResponse?) {
        val polylineOptions = PolylineOptions().width(25f).color(ContextCompat.getColor(this, R.color.Poly))
        routeResponse?.features?.first()?.geometry?.coordinates?.forEach{
            polylineOptions.add(LatLng(it[1], it[0]))
        }
        runOnUiThread{
            poly = mMap.addPolyline(polylineOptions)
        }
    }

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.openrouteservice.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

     fun createMarker(){

        var escuelaMedicina = LatLng(-18.49201998031831, -70.29768833560952)
        var marker01 = mMap.addMarker(MarkerOptions().position(escuelaMedicina).icon(BitmapDescriptorFactory.fromResource(R.drawable.deptos)).title("Escuela de medicina"))

        var edificioFacsal3 = LatLng(-18.492556704552847, -70.29717871589669)
        var marker02 = mMap.addMarker(MarkerOptions().position(edificioFacsal3).icon(BitmapDescriptorFactory.fromResource(R.drawable.facultad)).title("Edificio Facsal 3"))

        var edificioFacsal2 = LatLng(-18.49250074286322, -70.29687026186)
        var marker03 = mMap.addMarker(MarkerOptions().position(edificioFacsal2).icon(BitmapDescriptorFactory.fromResource(R.drawable.facultad)).title("Edificio Facsal 2"))

        var edificioFacsal1CentroSimulacionClinica = LatLng(-18.49219295324348, -70.29683539314279)
        var marker04 = mMap.addMarker(MarkerOptions().position(edificioFacsal1CentroSimulacionClinica).icon(BitmapDescriptorFactory.fromResource(R.drawable.facultad)).title("Edificio Facsal 1 y Centro de simulación clinica"))

        var ratatario = LatLng(-18.4921446225918, -70.29659935874948)
        var marker05 = mMap.addMarker(MarkerOptions().position(ratatario).icon(BitmapDescriptorFactory.fromResource(R.drawable.anexo)).title("Ratatario"))

        var ceinpsi = LatLng(-18.491762981042996, -70.29631605659635)
        var marker06 = mMap.addMarker(MarkerOptions().position(ceinpsi).icon(BitmapDescriptorFactory.fromResource(R.drawable.anexo)).title("CEINPSI"))

        var deptoMatematica = LatLng(-18.491786958312865, -70.29679601214598)
        var marker07 = mMap.addMarker(MarkerOptions().position(deptoMatematica).icon(BitmapDescriptorFactory.fromResource(R.drawable.deptos)).title("Departamento de matemáticas"))

        var deptoFisica = LatLng(-18.49148679859103, -70.29703741095733)
        var marker08 = mMap.addMarker(MarkerOptions().position(deptoFisica).icon(BitmapDescriptorFactory.fromResource(R.drawable.deptos)).title("Departamento de Física"))

        var aularioC = LatLng(-18.491234969267477, -70.29738475702477)
        var marker09 = mMap.addMarker(MarkerOptions().position(aularioC).icon(BitmapDescriptorFactory.fromResource(R.drawable.aulario)).title("Aulario C"))

        var aularioA = LatLng(-18.491013664402754, -70.2967316391296)
        var marker10 = mMap.addMarker(MarkerOptions().position(aularioA).icon(BitmapDescriptorFactory.fromResource(R.drawable.aulario)).title("Aulario A"))

        var edFisicaAularioOvidioSotoMayor = LatLng(-18.491176463409428, -70.29624750040242)
        var marker11 = mMap.addMarker(MarkerOptions().position(edFisicaAularioOvidioSotoMayor).icon(BitmapDescriptorFactory.fromResource(R.drawable.aulario)).title("Educación Física y Aulario Ovidio Sotomayor"))

        var docencia = LatLng(-18.490691881535135, -70.29650767467683)
        var marker12 = mMap.addMarker(MarkerOptions().position(docencia).icon(BitmapDescriptorFactory.fromResource(R.drawable.administrativo)).title("Docencia"))

        var fotocopiadoraSalasClases = LatLng(-18.490588860011812, -70.29685099743075)
        var marker13 = mMap.addMarker(MarkerOptions().position(fotocopiadoraSalasClases).icon(BitmapDescriptorFactory.fromResource(R.drawable.anexo)).title("Fotocopiadoras y Salas de clases"))

        var baniosServicioLogistica = LatLng(-18.490665172252104, -70.29712994716826)
        var marker14 = mMap.addMarker(MarkerOptions().position(baniosServicioLogistica).icon(BitmapDescriptorFactory.fromResource(R.drawable.anexo)).title("Baños, Servicios y Logística"))

        var dmz = LatLng(-18.49023019201519, -70.297025341201666)
        var marker15 = mMap.addMarker(MarkerOptions().position(dmz).icon(BitmapDescriptorFactory.fromResource(R.drawable.administrativo)).title("Direccion de Servicios y Logistica, Direccion de Infraestructura y Equipamiento, Finanzas , Recursos Humanos"))

        var cobranzas = LatLng(-18.490361194950673, -70.29695828579129)
        var marker16 = mMap.addMarker(MarkerOptions().position(cobranzas).icon(BitmapDescriptorFactory.fromResource(R.drawable.administrativo)).title("Cobranzas"))

        var bodegaDespachoInventario = LatLng(-18.490156423327846, -70.29691000602902)
        var marker17 = mMap.addMarker(MarkerOptions().position(bodegaDespachoInventario).icon(BitmapDescriptorFactory.fromResource(R.drawable.anexo)).title("Bodega, Despacho e Inventario"))

        var dirAsuntosEstudiantilesRegistraduriaAdquisiciones = LatLng(-18.49029251381253, -70.29667531274023)
        var marker18 = mMap.addMarker(MarkerOptions().position(dirAsuntosEstudiantilesRegistraduriaAdquisiciones).icon(BitmapDescriptorFactory.fromResource(R.drawable.administrativo)).title("Direccion de Asuntos Estudiantiles , Registraduria y Adquisiciones"))

        var aularioSigloXXI = LatLng(-18.49013720310249, -70.29635147914402)
        var marker19 = mMap.addMarker(MarkerOptions().position(aularioSigloXXI).icon(BitmapDescriptorFactory.fromResource(R.drawable.aulario)).title("AularioSigloXXI/Colina"))

        var veronicaRey = LatLng(-18.490682220513435, -70.29591946107949)
        var marker20 = mMap.addMarker(MarkerOptions().position(veronicaRey).icon(BitmapDescriptorFactory.fromResource(R.drawable.anexo)).title("Dirección de equidad de genero"))

        var biblioteca = LatLng(-18.4904001837511, -70.29579889789869)
        var marker21 = mMap.addMarker(MarkerOptions().position(biblioteca).icon(BitmapDescriptorFactory.fromResource(R.drawable.anexo)).title("Bliblioteca central"))

        var aularioDAntropologia = LatLng(-18.488576144251677, -70.29672760595885)
        var marker22 = mMap.addMarker(MarkerOptions().position(aularioDAntropologia).icon(BitmapDescriptorFactory.fromResource(R.drawable.aulario)).title("Aulario D y Antropologia"))

        var facsojurEsun = LatLng(-18.488441324290694, -70.29703337778656)
        var marker23A = mMap.addMarker(MarkerOptions().position(facsojurEsun).icon(BitmapDescriptorFactory.fromResource(R.drawable.facultad)).title("Facultad de ciencias sociales y juridicas"))

        var facsojurEsunB = LatLng(-18.48960128125427, -70.29534895052515)
        var marker23B = mMap.addMarker(MarkerOptions().position(facsojurEsun).icon(BitmapDescriptorFactory.fromResource(R.drawable.facultad)).title("Esun"))

        var facsojurEsunC = LatLng(-18.489708118999395, -70.2951772891482)
        var marker23C = mMap.addMarker(MarkerOptions().position(facsojurEsun).icon(BitmapDescriptorFactory.fromResource(R.drawable.facultad)).title("Esun"))

        var ingElectricaElectronica = LatLng(-18.48954023108477, -70.29501367439829)
        var marker24 = mMap.addMarker(MarkerOptions().position(ingElectricaElectronica).icon(BitmapDescriptorFactory.fromResource(R.drawable.deptos)).title("Ingenieria Electrica/Electrónica"))

        var ingIndustrial = LatLng(-18.489353952888514, -70.29532046967594)
        var marker25 = mMap.addMarker(MarkerOptions().position(ingIndustrial).icon(BitmapDescriptorFactory.fromResource(R.drawable.deptos)).title("Ingenieria Civil Industrial"))

        var deptoComputacionInformatica = LatLng(-18.489173929600813, -70.29522556891044)
        var marker26 = mMap.addMarker(MarkerOptions().position(deptoComputacionInformatica).icon(BitmapDescriptorFactory.fromResource(R.drawable.deptos)).title("Departamento de Ingeniería Civil en Computación e Informatica"))

        var electronicaAntiguo = LatLng(-18.48922931003019, -70.29496203318041)
        var marker27 = mMap.addMarker(MarkerOptions().position(electronicaAntiguo).icon(BitmapDescriptorFactory.fromResource(R.drawable.aulario)).title("Electronica antiguo"))

        var electronicaAntiguoB = LatLng(-18.48932675808676, -70.29497278627528)
        var marker27B = mMap.addMarker(MarkerOptions().position(electronicaAntiguoB).icon(BitmapDescriptorFactory.fromResource(R.drawable.aulario)).title("Electronica antiguo"))

        var electronicaAntiguoC = LatLng(-18.489140926862465, -70.29508509637732)
        var marker27C = mMap.addMarker(MarkerOptions().position(electronicaAntiguoC).icon(BitmapDescriptorFactory.fromResource(R.drawable.aulario)).title("Electronica antiguo"))

        var electronicaAntiguoD = LatLng(-18.489035546871335, -70.29495366966218)
        var marker27D = mMap.addMarker(MarkerOptions().position(electronicaAntiguoD).icon(BitmapDescriptorFactory.fromResource(R.drawable.aulario)).title("Electronica antiguo"))

        var electronicaAntiguoE = LatLng(-18.489084270961314, -70.29480193154559)
        var marker27E = mMap.addMarker(MarkerOptions().position(electronicaAntiguoE).icon(BitmapDescriptorFactory.fromResource(R.drawable.aulario)).title("Electronica antiguo"))

        var trabajoSocial = LatLng(-18.48898455652978, -70.29506239539923)
        var marker28 = mMap.addMarker(MarkerOptions().position(trabajoSocial).icon(BitmapDescriptorFactory.fromResource(R.drawable.deptos)).title("Trabajo Social"))

        var labIntegradoMecanica = LatLng(-18.488745296430412, -70.29567738632329)
        var marker29 = mMap.addMarker(MarkerOptions().position(labIntegradoMecanica).icon(BitmapDescriptorFactory.fromResource(R.drawable.deptos)).title("Laboratorio Integrado de Mecánica"))

        var escuelaIngMecanica = LatLng(-18.48827372792267, -70.29531745777247)
        var marker30 = mMap.addMarker(MarkerOptions().position(escuelaIngMecanica).icon(BitmapDescriptorFactory.fromResource(R.drawable.deptos)).title("Departamento de Ingenieria Mecánica"))

        var salaEstudio = LatLng(-18.48873952807754, -70.29515632424628)
        var marker31 = mMap.addMarker(MarkerOptions().position(salaEstudio).icon(BitmapDescriptorFactory.fromResource(R.drawable.anexo)).title("Sala de estudios"))

        var casino = LatLng(-18.488792947227097, -70.29493370089804)
        var marker32 = mMap.addMarker(MarkerOptions().position(casino).icon(BitmapDescriptorFactory.fromResource(R.drawable.anexo)).title("Casino"))

        var ingIndustrial2 = LatLng(-18.488932854444624, -70.29463329348837)
        var marker33 = mMap.addMarker(MarkerOptions().position(ingIndustrial2).icon(BitmapDescriptorFactory.fromResource(R.drawable.deptos)).title("Ingenieria industrial"))

        var psicologia = LatLng(-18.48859198938051, -70.29443481002114)
        var marker34 = mMap.addMarker(MarkerOptions().position(psicologia).icon(BitmapDescriptorFactory.fromResource(R.drawable.deptos)).title("Psicología"))

        var feuch = LatLng(-18.488500413577974, -70.29479422602915)
        var marker35 = mMap.addMarker(MarkerOptions().position(feuch).icon(BitmapDescriptorFactory.fromResource(R.drawable.anexo)).title("FEUCH"))

        var explora = LatLng(-18.488449548881064, -70.29457929995948)
        var marker36 = mMap.addMarker(MarkerOptions().position(explora).icon(BitmapDescriptorFactory.fromResource(R.drawable.anexo)).title("Explora"))

        var preUniversitario = LatLng(-18.488349684672784, -70.29471238608228)
        var marker37 = mMap.addMarker(MarkerOptions().position(preUniversitario).icon(BitmapDescriptorFactory.fromResource(R.drawable.anexo)).title("Pre-Universitario"))

        var educacionHumanidades = LatLng(-18.48815134307969, -70.2944081892302)
        var marker38 = mMap.addMarker(MarkerOptions().position(educacionHumanidades).icon(BitmapDescriptorFactory.fromResource(R.drawable.facultad)).title("Educación y Humanidades"))

        var admisionExtencion = LatLng(-18.48791958956166, -70.29491975102871)
        var marker39 = mMap.addMarker(MarkerOptions().position(admisionExtencion).icon(BitmapDescriptorFactory.fromResource(R.drawable.administrativo)).title("Admision y Extension"))
    }

    //Funcion para saber si el permiso esta aceptado
    private fun isLocationPermissionGranted() = ContextCompat.checkSelfPermission(
        this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED

    //Pedir los permisos de Ubicacion
    private fun requestLocationPermission(){
        //Si el usuario rechaza los permisos
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION)){
            Toast.makeText(this, "Ve a ajustes y acepta los permisos", Toast.LENGTH_SHORT).show()
        }
        else{
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_CODE_LOCATION)
        }
    }

    //Funcion para entregar la ubicacion
    private fun enableLocation(){
        if (!::mMap.isInitialized) return
        if (isLocationPermissionGranted()){
            mMap.isMyLocationEnabled = true

        }
        else{
            requestLocationPermission()
        }
    }

    //Comprueba si el permiso fue aceptado
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            REQUEST_CODE_LOCATION -> if(grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                mMap.isMyLocationEnabled = true
            }
            else{
                Toast.makeText(this, "Para activar la localizacion ve a ajuste y acepta los permisos", Toast.LENGTH_SHORT).show()
            }
            else -> {}
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        if (!::mMap.isInitialized) return
        if (!isLocationPermissionGranted()){
            mMap.isMyLocationEnabled = false
            Toast.makeText(this, "Para activar la localizacion ve a ajuste y acepta los permisos", Toast.LENGTH_SHORT).show()
        }
    }

    //-----------------------------------------------------
    fun imprimirUbicacion(ubicacion: Location) {

        Log.d(LOG_TAG, "Latitud es ${ubicacion.latitude} y la longitud es ${ubicacion.longitude}")
        //Toast.makeText(this,"Tu ubicacion actual es Latitud es ${ubicacion.latitude} y la longitud es ${ubicacion.longitude}",Toast.LENGTH_SHORT).show()
        start = "${ubicacion.longitude}, ${ubicacion.latitude}"
    }

    override fun onMyLocationButtonClick(): Boolean {
        Toast.makeText(this, "Boton pulsado", Toast.LENGTH_SHORT).show()

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        try {
            fusedLocationClient.lastLocation.addOnSuccessListener {
                if (it != null) {
                    imprimirUbicacion(it)
                } else {
                    Log.d(LOG_TAG, "No se pudo obtener la ubicación")
                }
            }
            //////
            val locationRequest = LocationRequest.create().apply {
                interval = 10000
                fastestInterval = 5000
                priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            }
            locationCallback = object : LocationCallback() {
                override fun onLocationResult(locationResult: LocationResult?) {
                    locationResult ?: return
                    Log.d(LOG_TAG, "Se recibió una actualización")
                    for (location in locationResult.locations) {
                        imprimirUbicacion(location)
                    }
                }
            }
            fusedLocationClient.requestLocationUpdates(
                locationRequest,
                locationCallback,
                Looper.getMainLooper()
            )
        } catch (e: SecurityException) {
            Log.d(LOG_TAG, "Tal vez no solicitaste permiso antes")
        }

        return false
    }

    override fun onMyLocationClick(p0: Location) {
        //Toast.makeText(this, "Estas en ${p0.latitude}, ${p0.longitude}", Toast.LENGTH_LONG).show()
    }

}