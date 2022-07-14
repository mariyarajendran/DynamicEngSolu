package com.task.ui.components.viewmodel

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.task.R
import com.task.data.DataRepository
import com.task.data.DataRepositorySource
import com.task.data.Resource
import com.task.data.dto.login.LoginResponse
import com.task.data.dto.network.HomeListModel
import com.task.data.dto.project.ProjectResponse
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

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val projectLiveDataPrivate = MutableLiveData<Resource<ProjectResponse>>()
    val projectLiveData: LiveData<Resource<ProjectResponse>> get() = projectLiveDataPrivate


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

    fun homeData(): MutableList<HomeListModel> {
        val homeListModel1 = HomeListModel(
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit",
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit",
            R.drawable.cancer2
        )
        val homeListModel2 = HomeListModel(
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit",
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit",
            R.drawable.cancer1
        )
        val homeListModel3 = HomeListModel(
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit",
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit",
            R.drawable.cancer2
        )
        val homeListModel4 = HomeListModel(
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit",
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit",
            R.drawable.cancer1
        )
        val homeListModel5 = HomeListModel(
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit",
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit",
            R.drawable.cancer2
        )
        val homeListModel6 = HomeListModel(
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit",
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit",
            R.drawable.cancer1
        )

        val homeListModel7 = HomeListModel(
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit",
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit",
            R.drawable.cancer2
        )
        val homeDatList = mutableListOf<HomeListModel>()
        homeDatList.add(homeListModel1)
        homeDatList.add(homeListModel2)
        homeDatList.add(homeListModel3)
        homeDatList.add(homeListModel4)
        homeDatList.add(homeListModel5)
        homeDatList.add(homeListModel6)
        homeDatList.add(homeListModel7)
        return homeDatList
    }

    fun onHomeSelected(
        homeListModel: MutableList<HomeListModel>,
        position: Int
    ) {
        openHomeListPrivate.value = SingleEvent(homeListModel[position])
    }

    fun getLoginResponseDataSession(): LoginResponse {
        return localRepository.getLoginResponseData()
    }

}