package com.estudos.githubshowprojects.data.network.api

import com.estudos.githubshowprojects.data.network.api.model.GithubProjectDataResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubShowProjectsNetworkApi {

    @GET("search/repositories?q=language:kotlin&sort=starts")
    suspend fun getGithubProjectList(@Query("page") page: Int): GithubProjectDataResponse

}