package com.estudos.githubshowprojects.domain.usercase

import com.estudos.githubshowprojects.data.repository.GitHubShowRepository
import com.estudos.githubshowprojects.data.repository.model.ProjectInfo
import com.estudos.githubshowprojects.domain.model.ProjectInfoPage

class GetProjectUseCase(
    private val gitHubShowRepository: GitHubShowRepository
) : UseCase<ProjectInfoPage, Int>() {

    private val projectInfoPage = ProjectInfoPage()

    override suspend fun run(pageCount: Int): ProjectInfoPage {

        if (projectInfoPage.isPagesEmpty()) {
            projectInfoPage.addPage()
            val listServer = gitHubShowRepository.getProjects(projectInfoPage.pageCount)
            projectInfoPage.listProjectInfo.addAll(listServer)
        }

        if (projectInfoPage.pageCount < pageCount) {
            val listServer = gitHubShowRepository.getProjects(pageCount)

            projectInfoPage.listProjectInfo.addAll(listServer)
            projectInfoPage.pageCount = pageCount
        }

        return projectInfoPage
    }
}