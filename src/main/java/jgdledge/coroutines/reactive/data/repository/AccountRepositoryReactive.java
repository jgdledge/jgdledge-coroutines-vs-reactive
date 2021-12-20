package jgdledge.coroutines.reactive.data.repository;

import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.r2dbc.annotation.R2dbcRepository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import jgdledge.coroutines.reactive.data.entity.Account;

import java.util.UUID;

@R2dbcRepository(value = "account", dialect = Dialect.MYSQL)
public interface AccountRepositoryReactive extends ReactorCrudRepository<Account, UUID> {
}
