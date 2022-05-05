package com.task.ui.components.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/task/ui/components/adapter/HomeDetailAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/task/ui/components/adapter/viewholder/HomeDetailViewHolder;", "context", "Landroid/content/Context;", "homeDetailListData", "", "Lcom/task/data/dto/network/HomeListDetailModel;", "homeDetailViewModel", "Lcom/task/ui/components/viewmodel/DetailListViewModel;", "(Landroid/content/Context;Ljava/util/List;Lcom/task/ui/components/viewmodel/DetailListViewModel;)V", "onItemTapCallback", "Lcom/task/ui/components/callback/OnItemTapCallback;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_debug"})
public final class HomeDetailAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.task.ui.components.adapter.viewholder.HomeDetailViewHolder> {
    private final android.content.Context context = null;
    private final java.util.List<com.task.data.dto.network.HomeListDetailModel> homeDetailListData = null;
    private final com.task.ui.components.viewmodel.DetailListViewModel homeDetailViewModel = null;
    private final com.task.ui.components.callback.OnItemTapCallback onItemTapCallback = null;
    
    public HomeDetailAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.List<com.task.data.dto.network.HomeListDetailModel> homeDetailListData, @org.jetbrains.annotations.NotNull()
    com.task.ui.components.viewmodel.DetailListViewModel homeDetailViewModel) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.task.ui.components.adapter.viewholder.HomeDetailViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.task.ui.components.adapter.viewholder.HomeDetailViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
}