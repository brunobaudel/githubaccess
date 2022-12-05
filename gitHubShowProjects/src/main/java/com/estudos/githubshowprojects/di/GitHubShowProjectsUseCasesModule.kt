package com.estudos.githubshowprojects.di

import com.estudos.githubshowprojects.domain.usercase.GetProjectUseCase
import org.koin.dsl.module

internal val gitHubShowProjectsUseCasesModules = module {

    single {
        GetProjectUseCase(gitHubShowRepository = get())
    }

}
