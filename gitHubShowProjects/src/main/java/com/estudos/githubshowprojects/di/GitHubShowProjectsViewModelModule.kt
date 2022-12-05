package com.estudos.githubshowprojects.di

import com.estudos.githubshowprojects.presentation.ShowProjectsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val gitHubShowProjectsViewModelModules = module {
    viewModel {
        ShowProjectsViewModel(projectUserCase = get())
    }
}
