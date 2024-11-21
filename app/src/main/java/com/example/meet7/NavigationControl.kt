package com.example.meet7

import com.example.meet7.model.Jeniskelamin
import com.example.meet7.ui.theme.view.FormulirView
import com.example.meet7.ui.theme.view.TampilDataView
import com.example.meet7.viewmodel.Siswaviewmodel
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

enum class Halaman{
    FORMULIR,
    TAMPILDATA
}

@Composable
fun NavigationControl(
    modifier: Modifier = Modifier,
    viewModel: Siswaviewmodel = viewModel(),
    navHost: NavHostController = rememberNavController()
){
    val context = LocalContext.current
    val uiState by viewModel.statusUI.collectAsState()

    NavHost(
        modifier = modifier.padding(16.dp),
        navController = navHost,
        startDestination = Halaman.FORMULIR.name
    ){
        composable(
            route = Halaman.FORMULIR.name
        ){
            FormulirView(
                listJK = Jeniskelamin.Jeniskelamin.map { id ->
                    context.getString(id)
                },
                onSubmitClicked = {
                    viewModel.saveDataSiswa(it)
                    navHost.navigate(Halaman.TAMPILDATA.name)
                }
            )
        }
        composable(route = Halaman.TAMPILDATA.name){
            TampilDataView(uiState = uiState, onBackButton = {
                navHost.popBackStack()
            })
        }
    }
}