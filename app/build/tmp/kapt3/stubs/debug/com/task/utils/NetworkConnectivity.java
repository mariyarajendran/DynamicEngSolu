package com.task.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/task/utils/NetworkConnectivity;", "", "getNetworkInfo", "Landroid/net/NetworkInfo;", "isConnected", "", "app_debug"})
public abstract interface NetworkConnectivity {
    
    @org.jetbrains.annotations.Nullable()
    public abstract android.net.NetworkInfo getNetworkInfo();
    
    public abstract boolean isConnected();
}