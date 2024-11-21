package com.example.meet7.viewmodel

import androidx.lifecycle.ViewModel
import com.example.meet7.model.Datasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class Siswaviewmodel: ViewModel() {
    private val _statusUI = MutableStateFlow(Datasiswa())
    val statusUI: StateFlow<Datasiswa> = _statusUI.asStateFlow()

    fun saveDataSiswa(ls: MutableList<String>) {
        _statusUI.update { statusSaatIni ->
            statusSaatIni.copy(
                nama = ls[0],
                Nim = ls[1],
                email = ls[2],
                alamat = ls[3],
                gender = ls[4],
                notelepon = ls[5]
            )
        }
    }
}
