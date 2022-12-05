package com.estudos.githubshowprojects.data.repository

import com.estudos.githubshowprojects.data.network.GitHubShowProjectsNetwork
import com.estudos.githubshowprojects.data.repository.mapper.toProjectInfo
import com.estudos.githubshowprojects.data.repository.model.ProjectInfo
import com.estudos.network.util.getSuccessResultWrapper
import com.estudos.network.util.result


class GitHubShowRepositoryImpl(
    private val gitHubShowProjectsNetwork: GitHubShowProjectsNetwork
) : GitHubShowRepository {

    override suspend fun getProjects(page: Int): List<ProjectInfo> {
        return result {
            gitHubShowProjectsNetwork
                .getProjects(page)
                .getSuccessResultWrapper()
                .toProjectInfo()
        }
    }

}