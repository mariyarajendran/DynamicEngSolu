package com.task.ui.components.viewmodel

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.task.R
import com.task.data.dto.network.HomeListModel
import com.task.ui.base.BaseViewModel
import com.task.utils.SingleEvent

class HomeViewModel : BaseViewModel() {
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val openHomeListPrivate = MutableLiveData<SingleEvent<HomeListModel>>()
    val openHomeList: LiveData<SingleEvent<HomeListModel>> get() = openHomeListPrivate

    fun homeData(): MutableList<HomeListModel> {
        val homeListModel1 = HomeListModel(
            "ABOUT CANCER",
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit",
            R.drawable.cancer2
        )
        val homeListModel2 = HomeListModel(
            "CANCER PREVENTION",
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit",
            R.drawable.cancer1
        )
        val homeListModel3 = HomeListModel(
            "ABOUT CANCER",
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit",
            R.drawable.cancer2
        )
        val homeListModel4 = HomeListModel(
            "CANCER PREVENTION",
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit",
            R.drawable.cancer1
        )
        val homeListModel5 = HomeListModel(
            "ABOUT CANCER",
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit",
            R.drawable.cancer2
        )
        val homeListModel6 = HomeListModel(
            "CANCER PREVENTION",
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit",
            R.drawable.cancer1
        )

        val homeListModel7 = HomeListModel(
            "ABOUT CANCER",
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

}