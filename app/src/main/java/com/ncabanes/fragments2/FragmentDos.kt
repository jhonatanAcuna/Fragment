package com.ncabanes.fragments2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import java.lang.RuntimeException

class FragmentDos : Fragment() {

    interface ComunicadorFragments {
        fun devolverDato(dato: String)
    }
    private var activityContenedora : ComunicadorFragments? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is ComunicadorFragments)
            activityContenedora = context
        else throw RuntimeException(
            context.toString() +
                    " debe implementar ComunicadorFragments"
        )
    }

    override fun onDetach() {
        super.onDetach()
        activityContenedora = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dos, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val boton : Button = view!!.findViewById(R.id.button5)
        boton.setOnClickListener {
            val et : EditText = view!!.findViewById(R.id.editTextTextPersonName3)
            activityContenedora?.devolverDato(et.text.toString())
        }
    }
}