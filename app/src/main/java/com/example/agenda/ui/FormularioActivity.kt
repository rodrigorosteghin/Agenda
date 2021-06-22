package com.example.agenda.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.agenda.viewmodel.FormularioViewModel
import com.example.agenda.databinding.ActivityFormularioBinding

class FormularioActivity : AppCompatActivity() {

    lateinit var binding: ActivityFormularioBinding
    lateinit var viewModel: FormularioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get()
        binding.formularioViewModel = viewModel

    }
}