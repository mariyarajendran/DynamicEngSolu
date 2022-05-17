package com.task.ui.components.viewmodel

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.task.R
import com.task.data.dto.network.HomeListDetailModel
import com.task.ui.base.BaseViewModel
import com.task.utils.SingleEvent

class DetailListViewModel : BaseViewModel() {

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val openHomeDetailListPrivate = MutableLiveData<SingleEvent<HomeListDetailModel>>()
    val openHomeDetailList: LiveData<SingleEvent<HomeListDetailModel>> get() = openHomeDetailListPrivate

    fun homeDetailData(): MutableList<HomeListDetailModel> {
        val homeDetailListModel1 = HomeListDetailModel(
            "Lorem ipsum",
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit.",
            R.drawable.cancer_detail
        )
        val homeDetailListModel2 = HomeListDetailModel(
            "Lorem ipsum",
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit.",
            R.drawable.cancer_detail
        )
        val homeDetailListModel3 = HomeListDetailModel(
            "Lorem ipsum",
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit.",
            R.drawable.cancer_detail
        )
        val homeDetailListModel4 = HomeListDetailModel(
            "Lorem ipsum",
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit.",
            R.drawable.cancer_detail
        )
        val homeDetailListModel5 = HomeListDetailModel(
            "Lorem ipsum",
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit.",
            R.drawable.cancer_detail
        )
        val homeDetailListModel6 = HomeListDetailModel(
            "Lorem ipsum",
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit.",
            R.drawable.cancer_detail
        )
        val homeDetailListModel7 = HomeListDetailModel(
            "Lorem ipsum",
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit.",
            R.drawable.cancer_detail
        )
        val homeDetailListModel8 = HomeListDetailModel(
            "Lorem ipsum",
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit.",
            R.drawable.cancer_detail
        )
        val homeDetailListModel9 = HomeListDetailModel(
            "Lorem ipsum",
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit.",
            R.drawable.cancer_detail
        )
        val homeDetailListModel10 = HomeListDetailModel(
            "Lorem ipsum",
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit.",
            R.drawable.cancer_detail
        )
        val homeDetailListModel11 = HomeListDetailModel(
            "Lorem ipsum",
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit.",
            R.drawable.cancer_detail
        )
        val homeDetailListModel12 = HomeListDetailModel(
            "Lorem ipsum",
            "Lorem ipsum dolor sit elit amet, consectetur adipiscing elit.",
            R.drawable.cancer_detail
        )
        val homeDetailDataList = mutableListOf<HomeListDetailModel>()
        homeDetailDataList.add(homeDetailListModel1)
        homeDetailDataList.add(homeDetailListModel2)
        homeDetailDataList.add(homeDetailListModel3)
        homeDetailDataList.add(homeDetailListModel4)
        homeDetailDataList.add(homeDetailListModel5)
        homeDetailDataList.add(homeDetailListModel6)
        homeDetailDataList.add(homeDetailListModel7)
        homeDetailDataList.add(homeDetailListModel8)
        homeDetailDataList.add(homeDetailListModel9)
        homeDetailDataList.add(homeDetailListModel10)
        homeDetailDataList.add(homeDetailListModel11)
        homeDetailDataList.add(homeDetailListModel12)
        return homeDetailDataList
    }

    fun onHomeDetailSelected(
        homeListModel: MutableList<HomeListDetailModel>,
        position: Int
    ) {
        openHomeDetailListPrivate.value = SingleEvent(homeListModel[position])
    }

}