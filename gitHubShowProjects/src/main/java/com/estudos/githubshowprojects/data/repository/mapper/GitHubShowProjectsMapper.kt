package com.estudos.githubshowprojects.data.repository.mapper

import com.estudos.githubshowprojects.data.network.api.model.GithubProjectDataResponse
import com.estudos.githubshowprojects.data.repository.model.ProjectInfo

fun GithubProjectDataResponse?.toProjectInfo(): List<ProjectInfo> =
    this?.items?.map {
        ProjectInfo(
            id = it.id.toString(),
            repositoryName = it.name.orEmpty(),
            starsCount = it.stargazersCount ?: 0,
            forkCount = it.forksCount?: 0,
            photoUser = it.owner?.avatarUrl.orEmpty(),
            authorName = it.owner?.login.orEmpty()
        )
    } ?: listOf()
    
