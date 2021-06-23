package com.example.agenda.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agenda.config.Constantes
import com.example.agenda.config.PersonalApp.Companion.db
import com.example.agenda.tablas.Personal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
        var mPersonal = Personal(null, nombre.value!!, apellido.value!!, email.value!!, telefono.value!!, edad.value!!)
        when(operacion){
            Constantes.OPERACION_INSERTAR -> {
                viewModelScope.launch {
                    val result = withContext(Dispatchers.IO){
                        db.personalDao().insert(

                                mPersonal

                        )

                    }

                    operacionExitosa.value = (result != 0L)
                }

            }
            Constantes.OPERACION_EDITAR -> {

            }

        }
    }

    fun cargarDatos() {
        viewModelScope.launch {
            var persona = withContext(Dispatchers.IO){
                db.personalDao().getById(id.value!!)
            }

            nombre.value = persona.nombre
            apellido.value = persona.apellido
            telefono.value = persona.telefono
            email.value = persona.email
            edad.value = persona.edad
        }
    }

}