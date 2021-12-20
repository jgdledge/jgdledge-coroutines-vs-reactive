package jgdledge.coroutines.reactive.data.repository

import jgdledge.coroutines.reactive.data.entity.Account
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.r2dbc.annotation.R2dbcRepository
import io.micronaut.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

@R2dbcRepository(value = "account", dialect = Dialect.MYSQL)
interface AccountRepositoryCoroutine : CoroutineCrudRepository<Account, UUID> {
}