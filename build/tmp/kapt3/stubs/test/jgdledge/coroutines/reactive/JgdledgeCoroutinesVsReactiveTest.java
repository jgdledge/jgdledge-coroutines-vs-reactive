package jgdledge.coroutines.reactive;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0007J\b\u0010\f\u001a\u00020\nH\u0007J\b\u0010\r\u001a\u00020\nH\u0007J\b\u0010\u000e\u001a\u00020\nH\u0007R\"\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0010"}, d2 = {"Ljgdledge/coroutines/reactive/JgdledgeCoroutinesVsReactiveTest;", "", "()V", "application", "Lio/micronaut/runtime/EmbeddedApplication;", "getApplication", "()Lio/micronaut/runtime/EmbeddedApplication;", "setApplication", "(Lio/micronaut/runtime/EmbeddedApplication;)V", "exception in async coroutineScope", "", "exception in async coroutineScope handled in async", "exception in async coroutineScope handled outside", "exception in async supervisorScope", "testItWorks", "SampleException", "jgdledge-coroutines-vs-reactive"})
@io.micronaut.test.extensions.junit5.annotation.MicronautTest
public final class JgdledgeCoroutinesVsReactiveTest {
    @jakarta.inject.Inject
    public io.micronaut.runtime.EmbeddedApplication<?> application;
    
    public JgdledgeCoroutinesVsReactiveTest() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final io.micronaut.runtime.EmbeddedApplication<?> getApplication() {
        return null;
    }
    
    public final void setApplication(@org.jetbrains.annotations.NotNull
    io.micronaut.runtime.EmbeddedApplication<?> p0) {
    }
    
    @org.junit.jupiter.api.Test
    public final void testItWorks() {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Ljgdledge/coroutines/reactive/JgdledgeCoroutinesVsReactiveTest$SampleException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "()V", "jgdledge-coroutines-vs-reactive"})
    public static final class SampleException extends java.lang.RuntimeException {
        
        public SampleException() {
            super();
        }
    }
}