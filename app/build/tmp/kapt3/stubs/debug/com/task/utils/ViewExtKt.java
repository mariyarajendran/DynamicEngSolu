package com.task.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0006\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n\u001a\u0012\u0010\u0007\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0004\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\u0006\u001a.\u0010\u0011\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00152\u0006\u0010\u0018\u001a\u00020\n\u001a\n\u0010\u0019\u001a\u00020\u0001*\u00020\u0006\u001a\n\u0010\u001a\u001a\u00020\u0001*\u00020\u0006\u001a\n\u0010\u001b\u001a\u00020\u0001*\u00020\u0006\u00a8\u0006\u001c"}, d2 = {"afterTextChanged", "", "Landroid/widget/EditText;", "Lkotlin/Function1;", "", "hideKeyboard", "Landroid/view/View;", "loadImage", "Landroid/widget/ImageView;", "resId", "", "url", "setTextFutureExt", "Landroidx/appcompat/widget/AppCompatEditText;", "text", "Landroidx/appcompat/widget/AppCompatTextView;", "showKeyboard", "showToast", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "ToastEvent", "Landroidx/lifecycle/LiveData;", "Lcom/task/utils/SingleEvent;", "", "timeLength", "toGone", "toInvisible", "toVisible", "app_debug"})
public final class ViewExtKt {
    
    public static final void showKeyboard(@org.jetbrains.annotations.NotNull()
    android.view.View $this$showKeyboard) {
    }
    
    public static final void hideKeyboard(@org.jetbrains.annotations.NotNull()
    android.view.View $this$hideKeyboard) {
    }
    
    public static final void toVisible(@org.jetbrains.annotations.NotNull()
    android.view.View $this$toVisible) {
    }
    
    public static final void toGone(@org.jetbrains.annotations.NotNull()
    android.view.View $this$toGone) {
    }
    
    public static final void toInvisible(@org.jetbrains.annotations.NotNull()
    android.view.View $this$toInvisible) {
    }
    
    public static final void showToast(@org.jetbrains.annotations.NotNull()
    android.view.View $this$showToast, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner lifecycleOwner, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<com.task.utils.SingleEvent<java.lang.Object>> ToastEvent, int timeLength) {
    }
    
    public static final void afterTextChanged(@org.jetbrains.annotations.NotNull()
    android.widget.EditText $this$afterTextChanged, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> afterTextChanged) {
    }
    
    public static final void loadImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView $this$loadImage, @androidx.annotation.DrawableRes()
    int resId) {
    }
    
    public static final void loadImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView $this$loadImage, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    public static final void setTextFutureExt(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.AppCompatTextView $this$setTextFutureExt, @org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public static final void setTextFutureExt(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.AppCompatEditText $this$setTextFutureExt, @org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
}