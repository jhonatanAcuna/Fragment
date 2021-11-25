package com.ncabanes.fragments2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ncabanes.fragments2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),
    FragmentDos.ComunicadorFragments {

    lateinit var binding: ActivityMainBinding
    var numFragmento = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val transaccion = supportFragmentManager.beginTransaction()
        val fragmento = FragmentDos()
        transaccion.replace(R.id.contenedor, fragmento)
        transaccion.addToBackStack(null)
        transaccion.commit()



    }

    override fun devolverDato(dato: String) {
        binding.editTextTextPersonName.setText(dato)
    }
}