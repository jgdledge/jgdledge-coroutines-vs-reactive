package jgdledge.coroutines.reactive.test.framework.db;

import java.lang.System;

/**
 * Factory to define Beans for:
 *
 * * TestContainer using MySQL image
 * * JDBC DataSource connected to the above container
 * * R2DBC ConnectionFactoryOptions for the above container
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J \u0010\r\u001a\u00020\f2\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0014\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0014\u0010\u000f\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0004\u00a8\u0006\u0012"}, d2 = {"Ljgdledge/coroutines/reactive/test/framework/db/MySqlContainerFactory;", "", "()V", "createJdbcDataSource", "Ljavax/sql/DataSource;", "container", "Lorg/testcontainers/containers/MySQLContainer;", "configuration", "Ljgdledge/coroutines/reactive/test/framework/db/MysqlContainerConfiguration;", "createR2dbcConnectionFactory", "Lio/r2dbc/spi/ConnectionFactory;", "options", "Lio/r2dbc/spi/ConnectionFactoryOptions;", "createR2dbcOptions", "createTestContainer", "getDataSource", "Lorg/testcontainers/containers/JdbcDatabaseContainer;", "SpecifiedMySQLContainer", "jgdledge-coroutines-vs-reactive"})
@io.micronaut.context.annotation.Requires(env = {"tc"})
@io.micronaut.context.annotation.Factory
public final class MySqlContainerFactory {
    
    public MySqlContainerFactory() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @io.micronaut.context.annotation.EachBean(value = jgdledge.coroutines.reactive.test.framework.db.MysqlContainerConfiguration.class)
    public final org.testcontainers.containers.MySQLContainer<?> createTestContainer(@org.jetbrains.annotations.NotNull
    jgdledge.coroutines.reactive.test.framework.db.MysqlContainerConfiguration configuration) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @io.micronaut.context.annotation.EachBean(value = jgdledge.coroutines.reactive.test.framework.db.MysqlContainerConfiguration.class)
    public final javax.sql.DataSource createJdbcDataSource(@org.jetbrains.annotations.NotNull
    org.testcontainers.containers.MySQLContainer<?> container, @org.jetbrains.annotations.Nullable
    jgdledge.coroutines.reactive.test.framework.db.MysqlContainerConfiguration configuration) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @io.micronaut.context.annotation.Replaces(bean = io.r2dbc.spi.ConnectionFactoryOptions.class)
    @io.micronaut.context.annotation.EachBean(value = jgdledge.coroutines.reactive.test.framework.db.MysqlContainerConfiguration.class)
    public final io.r2dbc.spi.ConnectionFactoryOptions createR2dbcOptions(@org.jetbrains.annotations.Nullable
    org.testcontainers.containers.MySQLContainer<?> container, @org.jetbrains.annotations.Nullable
    jgdledge.coroutines.reactive.test.framework.db.MysqlContainerConfiguration configuration) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @io.micronaut.context.annotation.Replaces(bean = io.r2dbc.spi.ConnectionFactory.class)
    @io.micronaut.context.annotation.EachBean(value = io.r2dbc.spi.ConnectionFactoryOptions.class)
    public final io.r2dbc.spi.ConnectionFactory createR2dbcConnectionFactory(@org.jetbrains.annotations.NotNull
    io.r2dbc.spi.ConnectionFactoryOptions options) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    protected final javax.sql.DataSource getDataSource(@org.jetbrains.annotations.NotNull
    org.testcontainers.containers.JdbcDatabaseContainer<?> container) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Ljgdledge/coroutines/reactive/test/framework/db/MySqlContainerFactory$SpecifiedMySQLContainer;", "Lorg/testcontainers/containers/MySQLContainer;", "image", "", "(Ljava/lang/String;)V", "jgdledge-coroutines-vs-reactive"})
    public static final class SpecifiedMySQLContainer extends org.testcontainers.containers.MySQLContainer<jgdledge.coroutines.reactive.test.framework.db.MySqlContainerFactory.SpecifiedMySQLContainer> {
        
        public SpecifiedMySQLContainer(@org.jetbrains.annotations.NotNull
        java.lang.String image) {
            super();
        }
    }
}