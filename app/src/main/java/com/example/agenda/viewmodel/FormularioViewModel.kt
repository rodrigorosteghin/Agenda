package com.example.agenda.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.agenda.config.Constantes

class FormularioViewModel:ViewModel() {
    var id = MutableLiveData<Long>()
    var nombre = MutableLiveData<String>()
    var apellido = MutableLiveData<String>()
    var telefono = MutableLiveData<String>()
    var email = MutableLiveData<String>()
    var edad = MutableLiveData<Int>()
    var operacion = Constantes.OPERACION_INSERTAR
    var operacionExitosa = MutableLiveData<Boolean>()

    init {
        edad.value = 18
    }

    fun guardarUsuario() {

        when(operacion){
            Constantes.OPERACION_INSERTAR ->
                //todo logica para insertar en al bd
                Log.d("mensaje", "nombre ${nombre.value}")

        }
    }

}