package com.estudos.githubshowprojects.di

import com.estudos.githubshowprojects.data.network.GitHubShowProjectsNetwork
import com.estudos.githubshowprojects.data.network.GitHubShowProjectsNetworkImpl
import com.estudos.githubshowprojects.data.repository.GitHubShowRepository
import com.estudos.githubshowprojects.data.repository.GitHubShowRepositoryImpl
import org.koin.dsl.module

private val gitHubShowProjectsNetworkingModules = module {
    single<GitHubShowProjectsNetwork> { GitHubShowProjectsNetworkImpl(get()) }
}

private val gitHubShowProjectsRepositoryModule = module {
    single<GitHubShowRepository> { GitHubShowRepositoryImpl(get()) }
}

val gitHubShowProjectsModules = listOf(
    gitHubShowProjectsNetworkingModules,
    gitHubShowProjectsRepositoryModule,
    gitHubShowProjectsUseCasesModules,
    gitHubShowProjectsViewModelModules
)