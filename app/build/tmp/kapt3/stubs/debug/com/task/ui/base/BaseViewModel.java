package com.task.ui.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/task/ui/base/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "errorManager", "Ljava/util/logging/ErrorManager;", "getErrorManager", "()Ljava/util/logging/ErrorManager;", "setErrorManager", "(Ljava/util/logging/ErrorManager;)V", "app_debug"})
public abstract class BaseViewModel extends androidx.lifecycle.ViewModel {
    @javax.inject.Inject()
    public java.util.logging.ErrorManager errorManager;
    
    public BaseViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.logging.ErrorManager getErrorManager() {
        return null;
    }
    
    public final void setErrorManager(@org.jetbrains.annotations.NotNull()
    java.util.logging.ErrorManager p0) {
    }
}