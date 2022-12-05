package com.estudos.githubshowprojects.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.estudos.githubshowprojects.data.repository.model.ProjectInfo
import com.estudos.githubshowprojects.domain.model.ProjectInfoPage
import com.estudos.githubshowprojects.domain.usercase.GetProjectUseCase
import com.estudos.githubshowprojects.presentation.util.ViewerUiState
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ShowProjectsViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val dispatcher = TestCoroutineDispatcher()

    private val getProjectUseCase = mockk<GetProjectUseCase>(relaxed = true)
    private val listProjectInfoObserver: Observer<VRListProjectInfo> = mockk(relaxed = true)

    @Before
    fun setUp(){
        Dispatchers.setMain(dispatcher)
    }

    @Test
    fun `when vm success data then should call the user case`() {

        val viewModel = instantiateViewModel()

        coEvery { getProjectUseCase.invoke(1) } returns getMockedProjectInfoPage()

        viewModel.getProjects()

        coVerify {
            listProjectInfoObserver.onChanged(ViewerUiState.Loading(true))
            getProjectUseCase.invoke(1)
            listProjectInfoObserver.onChanged(ViewerUiState.Loading(false))
        }
    }

    @After
    fun cleanUp(){
        Dispatchers.resetMain()
        dispatcher.cleanupTestCoroutines()
    }

    private fun instantiateViewModel(): ShowProjectsViewModel {
        val viewModel = ShowProjectsViewModel(getProjectUseCase)
        viewModel.vrListProjectInfo.observeForever(listProjectInfoObserver)
        return viewModel
    }

    private fun getMockedProjectInfoPage(): ProjectInfoPage = ProjectInfoPage(
        pageCount = 1, listProjectInfo = mutableListOf(
            ProjectInfo(), ProjectInfo()
        )
    )
}