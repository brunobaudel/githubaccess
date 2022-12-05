package com.estudos.githubshowprojects.data.network

import com.estudos.githubshowprojects.data.network.api.GitHubShowProjectsNetworkApi
import com.estudos.githubshowprojects.data.network.api.model.GitHubErrorModel
import com.estudos.githubshowprojects.data.network.api.model.GithubProjectDataResponse
import com.estudos.network.util.ResultWrapper
import com.estudos.network.util.safeApiCall
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class GitHubShowProjectsNetworkImpl(
    private val gitHubShowProjectsNetworkApi: GitHubShowProjectsNetworkApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : GitHubShowProjectsNetwork {

    override suspend fun getProjects(page: Int): ResultWrapper<GithubProjectDataResponse> =
        safeApiCall(
            dispatcher = dispatcher,
            apiCall = {
                gitHubShowProjectsNetworkApi.getGithubProjectList(page)
            },
            transformError = {
                Gson().fromJson(it, GitHubErrorModel::class.java).message
            }
        )
}
