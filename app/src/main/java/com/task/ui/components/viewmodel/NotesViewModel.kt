package com.task.ui.components.viewmodel

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.task.data.DataRepository
import com.task.data.DataRepositorySource
import com.task.data.Resource
import com.task.data.dto.chapter.ChapterData
import com.task.data.dto.chapter.ChapterResponse
import com.task.data.dto.login.LoginResponse
import com.task.data.dto.network.HomeListModel
import com.task.data.dto.pdfnotes.PdfNotesData
import com.task.data.dto.pdfnotes.PdfNotesResponse
import com.task.data.dto.project.ProjectData
import com.task.data.dto.project.ProjectResponse
import com.task.data.dto.subject.SubjectData
import com.task.data.dto.subject.SubjectResponse
import com.task.ui.base.BaseViewModel
import com.task.utils.NetworkConnectivity
import com.task.utils.SingleEvent
import com.task.utils.wrapEspressoIdlingResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val mDataRepository: DataRepository,
    private val mDataRepositoryRepository: DataRepositorySource,
    private val mNetworkConnectivity: NetworkConnectivity,
) : BaseViewModel() {
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val openHomeListPrivate = MutableLiveData<SingleEvent<HomeListModel>>()
    val openHomeList: LiveData<SingleEvent<HomeListModel>> get() = openHomeListPrivate

    ///project
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val openProjectListPrivate = MutableLiveData<SingleEvent<ProjectData>>()
    val openProjectList: LiveData<SingleEvent<ProjectData>> get() = openProjectListPrivate


    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val projectLiveDataPrivate = MutableLiveData<Resource<ProjectResponse>>()
    val projectLiveData: LiveData<Resource<ProjectResponse>> get() = projectLiveDataPrivate

    ///subject
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val openSubjectListPrivate = MutableLiveData<SingleEvent<SubjectData>>()
    val openSubjectList: LiveData<SingleEvent<SubjectData>> get() = openSubjectListPrivate


    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val subjectLiveDataPrivate = MutableLiveData<Resource<SubjectResponse>>()
    val subjectLiveData: LiveData<Resource<SubjectResponse>> get() = subjectLiveDataPrivate

    ///chapter
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val openChapterListPrivate = MutableLiveData<SingleEvent<ChapterData>>()
    val openChapterList: LiveData<SingleEvent<ChapterData>> get() = openChapterListPrivate


    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val chapterLiveDataPrivate = MutableLiveData<Resource<ChapterResponse>>()
    val chapterLiveData: LiveData<Resource<ChapterResponse>> get() = chapterLiveDataPrivate

    ///notes pdf
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val openPdfNotesPrivate = MutableLiveData<SingleEvent<PdfNotesData>>()
    val openPdfNotes: LiveData<SingleEvent<PdfNotesData>> get() = openPdfNotesPrivate


    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val pdfNotesLiveDataPrivate = MutableLiveData<Resource<PdfNotesResponse>>()
    val pdfNotesLiveData: LiveData<Resource<PdfNotesResponse>> get() = pdfNotesLiveDataPrivate


    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val showToastPrivate = MutableLiveData<SingleEvent<Any>>()
    val showToast: LiveData<SingleEvent<Any>> get() = showToastPrivate

    fun showToastMessage(errorCode: Int) {
        val error = errorManager.getError(errorCode)
        showToastPrivate.value = SingleEvent(error.description)
    }

    fun showFailureToastMessage(error: String) {
        showToastPrivate.value = SingleEvent(error)
    }

    fun userBasedProject(
        action: String,
        userId: String,
        orgId: String
    ) {
        viewModelScope.launch {
            projectLiveDataPrivate.value = Resource.Loading()
            wrapEspressoIdlingResource {
                mDataRepositoryRepository.userBasedProject(
                    action, userId, orgId
                ).collect {
                    projectLiveDataPrivate.value = it
                }
            }
        }
    }


    fun userBasedSubject(
        action: String,
        projectId: String,
        orgId: String
    ) {
        viewModelScope.launch {
            subjectLiveDataPrivate.value = Resource.Loading()
            wrapEspressoIdlingResource {
                mDataRepositoryRepository.userBasedSubject(
                    action, projectId, orgId
                ).collect {
                    subjectLiveDataPrivate.value = it
                }
            }
        }
    }

    fun userBasedChapter(
        action: String,
        subjectId: String,
        orgId: String
    ) {
        viewModelScope.launch {
            chapterLiveDataPrivate.value = Resource.Loading()
            wrapEspressoIdlingResource {
                mDataRepositoryRepository.userBasedChapter(
                    action, subjectId, orgId
                ).collect {
                    chapterLiveDataPrivate.value = it
                }
            }
        }
    }

    fun userBasedPdfNotes(
        action: String,
        subjectId: String,
        orgId: String,
        chapterId: String
    ) {
        viewModelScope.launch {
            pdfNotesLiveDataPrivate.value = Resource.Loading()
            wrapEspressoIdlingResource {
                mDataRepositoryRepository.userBasedPdfNotes(
                    action, subjectId, orgId, chapterId
                ).collect {
                    pdfNotesLiveDataPrivate.value = it
                }
            }
        }
    }

    fun onProjectSelected(
        projectData: MutableList<ProjectData>,
        position: Int
    ) {
        openProjectListPrivate.value = SingleEvent(projectData[position])
    }

    fun onSubjectSelected(
        subjectData: MutableList<SubjectData>,
        position: Int
    ) {
        openSubjectListPrivate.value = SingleEvent(subjectData[position])
    }

    fun onChapterSelected(
        chapterData: MutableList<ChapterData>,
        position: Int
    ) {
        openChapterListPrivate.value = SingleEvent(chapterData[position])
    }


    fun onNotesPdfSelected(
        pdfNotesData: MutableList<PdfNotesData>,
        position: Int
    ) {
        openPdfNotesPrivate.value = SingleEvent(pdfNotesData[position])
    }

    fun getLoginResponseDataSession(): LoginResponse {
        return localRepository.getLoginResponseData()
    }

}