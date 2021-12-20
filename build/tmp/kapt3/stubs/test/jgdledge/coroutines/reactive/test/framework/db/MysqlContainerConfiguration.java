package jgdledge.coroutines.reactive.test.framework.db;

import java.lang.System;

/**
 * Custom Bean Configuration used to configure MySQL on TestContainers in such a way that both
 * JDBC and R2DBC drivers are making use of the same Docker Container.
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0003X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\t"}, d2 = {"Ljgdledge/coroutines/reactive/test/framework/db/MysqlContainerConfiguration;", "", "name", "", "(Ljava/lang/String;)V", "dockerImageName", "getDockerImageName", "()Ljava/lang/String;", "getName", "jgdledge-coroutines-vs-reactive"})
@io.micronaut.context.annotation.EachProperty(value = "test.tc-mysql")
@io.micronaut.context.annotation.Requires(env = {"tc"})
public final class MysqlContainerConfiguration {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String dockerImageName = "mysql:8";
    
    public MysqlContainerConfiguration(@org.jetbrains.annotations.NotNull
    @io.micronaut.context.annotation.Parameter
    java.lang.String name) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDockerImageName() {
        return null;
    }
}