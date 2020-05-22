package com.example.recyclerviewudelp.Fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.recyclerviewudelp.R


class HomeFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("UDELP FRAGMENT", "onAttach - fragmento ha sido adjuntado a la Actividad")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("UDELP FRAGMENT", "onCreate - El sistema lo llama cuando crea el fragmento")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("UDELP FRAGMENT", "onCreateView - El sistema lo llama cuando el fragmento debe diseñar su interfaz de usuario por primera vez")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("UDELP FRAGMENT", "onViewCreated  - ***** PROGRAMA")
    }

    override fun onPause() {
        super.onPause()
        Log.d("UDELP FRAGMENT", "onPause  -El sistema llama a este método como el primer indicador de que el usuario está abandonando el fragmento (aunque no siempre significa que el fragmento se esté destruyendo)")
    }

    override fun onResume() {
        super.onResume()
        Log.d("UDELP FRAGMENT", "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("UDELP FRAGMENT", "onStop - El fragment ya no es visible por el usuario")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("UDELP FRAGMENT", "onDestroyView  -Lipieza de las vistas asociadas al fragment")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("UDELP FRAGMENT", "onDestroy -Limpieza del estado del fragment")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("UDELP FRAGMENT", "onDetach - fragmento es removido o quitado de la actividad y ya no esta disponible")
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

}
