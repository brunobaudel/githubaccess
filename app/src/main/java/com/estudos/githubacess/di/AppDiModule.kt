package com.estudos.githubacess.di

import com.estudos.githubacess.BuildConfig
import com.estudos.githubshowprojects.data.network.api.GitHubShowProjectsNetworkApi
import com.estudos.githubshowprojects.di.gitHubShowProjectsModules
import com.estudos.network.StartNetworkParameters
import com.estudos.network.startNetwork
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import retrofit2.Retrofit

val startNetworkParameters = StartNetworkParameters(
    baseUrl = BuildConfig.BASE_URL,
    isDebug = BuildConfig.DEBUG
)

val appDiModule = module {

    single {
        get<Retrofit> {
            parametersOf(startNetworkParameters)
        }.create(GitHubShowProjectsNetworkApi::class.java)
    }

}

fun getAppModules(): List<Module> =
    listOf(
        startNetwork,
        appDiModule
    ).plus(gitHubShowProjectsModules)

