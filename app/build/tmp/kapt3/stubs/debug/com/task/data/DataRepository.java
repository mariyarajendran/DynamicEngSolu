package com.task.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/task/data/DataRepository;", "Lcom/task/data/DataRepositorySource;", "remoteRepository", "Lcom/task/data/remote/RemoteData;", "ioDispatcher", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/task/data/remote/RemoteData;Lkotlin/coroutines/CoroutineContext;)V", "doLogin", "Lkotlinx/coroutines/flow/Flow;", "Lcom/task/data/Resource;", "Lcom/task/data/dto/credential/login/LoginResponse;", "loginRequest", "Lcom/task/data/dto/credential/login/LoginRequest;", "(Lcom/task/data/dto/credential/login/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class DataRepository implements com.task.data.DataRepositorySource {
    private final com.task.data.remote.RemoteData remoteRepository = null;
    private final kotlin.coroutines.CoroutineContext ioDispatcher = null;
    
    @javax.inject.Inject()
    public DataRepository(@org.jetbrains.annotations.NotNull()
    com.task.data.remote.RemoteData remoteRepository, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.CoroutineContext ioDispatcher) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object doLogin(@org.jetbrains.annotations.NotNull()
    com.task.data.dto.credential.login.LoginRequest loginRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.task.data.Resource<com.task.data.dto.credential.login.LoginResponse>>> continuation) {
        return null;
    }
}