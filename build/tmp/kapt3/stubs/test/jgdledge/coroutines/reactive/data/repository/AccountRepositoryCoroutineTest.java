package jgdledge.coroutines.reactive.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u0010\u001a\u00020\bH\u0007J\b\u0010\u0011\u001a\u00020\bH\u0007J\b\u0010\u0012\u001a\u00020\bH\u0007J\b\u0010\u0013\u001a\u00020\bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Ljgdledge/coroutines/reactive/data/repository/AccountRepositoryCoroutineTest;", "", "accountRepository", "Ljgdledge/coroutines/reactive/data/repository/AccountRepositoryCoroutine;", "accountCounter", "Ljgdledge/coroutines/reactive/test/AccountCounter;", "(Ljgdledge/coroutines/reactive/data/repository/AccountRepositoryCoroutine;Ljgdledge/coroutines/reactive/test/AccountCounter;)V", "createAccountsDynamic", "", "numAccounts", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAccountsPooled", "dynamicBatchedCreateAccountTest", "staticBatchedCreateAccountTest", "synchronouslyCreateAccountTest", "test create 5000 accounts dynamic batched", "test create 5000 accounts static batched", "test create 5000 accounts synchronously", "testItWorks", "Companion", "jgdledge-coroutines-vs-reactive"})
@io.micronaut.test.extensions.junit5.annotation.MicronautTest(environments = {"tc"})
public final class AccountRepositoryCoroutineTest {
    private final jgdledge.coroutines.reactive.data.repository.AccountRepositoryCoroutine accountRepository = null;
    private final jgdledge.coroutines.reactive.test.AccountCounter accountCounter = null;
    @org.jetbrains.annotations.NotNull
    public static final jgdledge.coroutines.reactive.data.repository.AccountRepositoryCoroutineTest.Companion Companion = null;
    private static final int BATCH_SIZE = 100;
    
    public AccountRepositoryCoroutineTest(@org.jetbrains.annotations.NotNull
    jgdledge.coroutines.reactive.data.repository.AccountRepositoryCoroutine accountRepository, @org.jetbrains.annotations.NotNull
    jgdledge.coroutines.reactive.test.AccountCounter accountCounter) {
        super();
    }
    
    @org.junit.jupiter.api.Test
    public final void testItWorks() {
    }
    
    private final java.lang.Object synchronouslyCreateAccountTest(int numAccounts, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object staticBatchedCreateAccountTest(int numAccounts, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object createAccountsPooled(int numAccounts, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object dynamicBatchedCreateAccountTest(int numAccounts, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object createAccountsDynamic(int numAccounts, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Ljgdledge/coroutines/reactive/data/repository/AccountRepositoryCoroutineTest$Companion;", "", "()V", "BATCH_SIZE", "", "jgdledge-coroutines-vs-reactive"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}