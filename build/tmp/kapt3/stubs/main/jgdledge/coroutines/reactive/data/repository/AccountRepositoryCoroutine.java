package jgdledge.coroutines.reactive.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u00a8\u0006\u0004"}, d2 = {"Ljgdledge/coroutines/reactive/data/repository/AccountRepositoryCoroutine;", "Lio/micronaut/data/repository/kotlin/CoroutineCrudRepository;", "Ljgdledge/coroutines/reactive/data/entity/Account;", "Ljava/util/UUID;", "jgdledge-coroutines-vs-reactive"})
@io.micronaut.data.r2dbc.annotation.R2dbcRepository(value = "account", dialect = io.micronaut.data.model.query.builder.sql.Dialect.MYSQL)
public abstract interface AccountRepositoryCoroutine extends io.micronaut.data.repository.kotlin.CoroutineCrudRepository<jgdledge.coroutines.reactive.data.entity.Account, java.util.UUID> {
}