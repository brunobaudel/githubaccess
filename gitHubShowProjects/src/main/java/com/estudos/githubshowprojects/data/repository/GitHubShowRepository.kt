package com.estudos.githubshowprojects.data.repository

import com.estudos.githubshowprojects.data.repository.model.ProjectInfo

interface GitHubShowRepository {
    suspend fun getProjects(page: Int): List<ProjectInfo>
}