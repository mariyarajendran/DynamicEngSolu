package com.task.ui.components.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rJ\u001c\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\u0006\u0010\u0011\u001a\u00020\u0012R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\n8\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u00a8\u0006\u0013"}, d2 = {"Lcom/task/ui/components/viewmodel/HomeViewModel;", "Lcom/task/ui/base/BaseViewModel;", "()V", "openHomeList", "Landroidx/lifecycle/LiveData;", "Lcom/task/utils/SingleEvent;", "Lcom/task/data/dto/network/HomeListModel;", "getOpenHomeList", "()Landroidx/lifecycle/LiveData;", "openHomeListPrivate", "Landroidx/lifecycle/MutableLiveData;", "getOpenHomeListPrivate$annotations", "homeData", "", "onHomeSelected", "", "homeListModel", "position", "", "app_debug"})
public final class HomeViewModel extends com.task.ui.base.BaseViewModel {
    private final androidx.lifecycle.MutableLiveData<com.task.utils.SingleEvent<com.task.data.dto.network.HomeListModel>> openHomeListPrivate = null;
    
    public HomeViewModel() {
        super();
    }
    
    @androidx.annotation.VisibleForTesting(otherwise = androidx.annotation.VisibleForTesting.PRIVATE)
    @java.lang.Deprecated()
    private static void getOpenHomeListPrivate$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.task.utils.SingleEvent<com.task.data.dto.network.HomeListModel>> getOpenHomeList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.task.data.dto.network.HomeListModel> homeData() {
        return null;
    }
    
    public final void onHomeSelected(@org.jetbrains.annotations.NotNull()
    java.util.List<com.task.data.dto.network.HomeListModel> homeListModel, int position) {
    }
}