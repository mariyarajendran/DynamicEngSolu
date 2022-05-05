package com.task.data.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J5\u0010\u0007\u001a\u0004\u0018\u00010\b2 \u0010\t\u001a\u001c\b\u0001\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\b0\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/task/data/remote/RemoteData;", "Lcom/task/data/remote/RemoteDataSource;", "serviceGenerator", "Lcom/task/data/remote/ServiceGenerator;", "networkConnectivity", "Lcom/task/utils/NetworkConnectivity;", "(Lcom/task/data/remote/ServiceGenerator;Lcom/task/utils/NetworkConnectivity;)V", "processCall", "", "responseCall", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lretrofit2/Response;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestLogin", "Lcom/task/data/Resource;", "Lcom/task/data/dto/credential/login/LoginResponse;", "loginRequest", "Lcom/task/data/dto/credential/login/LoginRequest;", "(Lcom/task/data/dto/credential/login/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class RemoteData implements com.task.data.remote.RemoteDataSource {
    private final com.task.data.remote.ServiceGenerator serviceGenerator = null;
    private final com.task.utils.NetworkConnectivity networkConnectivity = null;
    
    @javax.inject.Inject()
    public RemoteData(@org.jetbrains.annotations.NotNull()
    com.task.data.remote.ServiceGenerator serviceGenerator, @org.jetbrains.annotations.NotNull()
    com.task.utils.NetworkConnectivity networkConnectivity) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object requestLogin(@org.jetbrains.annotations.NotNull()
    com.task.data.dto.credential.login.LoginRequest loginRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.task.data.Resource<com.task.data.dto.credential.login.LoginResponse>> continuation) {
        return null;
    }
    
    private final java.lang.Object processCall(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super retrofit2.Response<?>>, ? extends java.lang.Object> responseCall, kotlin.coroutines.Continuation<java.lang.Object> continuation) {
        return null;
    }
}