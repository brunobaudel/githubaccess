package com.estudos.githubshowprojects.data.network

import com.estudos.githubshowprojects.data.network.api.model.GithubProjectDataResponse
import com.estudos.network.util.ResultWrapper

interface GitHubShowProjectsNetwork {

    suspend fun getProjects(page: Int): ResultWrapper<GithubProjectDataResponse>

}