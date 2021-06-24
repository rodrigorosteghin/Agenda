package com.example.agenda.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agenda.config.PersonalApp.Companion.db
import com.example.agenda.tablas.Personal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel:ViewModel() {
    val personalList = MutableLiveData<List<Personal>>()
    val parametroBusqueda = MutableLiveData<String>()

    fun iniciar(){
        viewModelScope.launch {
            personalList.value = withContext(Dispatchers.IO){


                db.personalDao().getAll()
            }

        }
    }

    fun buscarPersonal(buscarPersonal:String) {
        viewModelScope.launch {
            personalList.value = withContext(Dispatchers.IO){

                db.personalDao().getByName(buscarPersonal)
            }

        }
    }
    fun buscarPersonal2() {
        viewModelScope.launch {
            personalList.value = withContext(Dispatchers.IO){

                db.personalDao().getAll().filter { it.nombre.contains(parametroBusqueda.value!!) || it.apellido.contains(parametroBusqueda.value!!) }
            }

        }
    }
}