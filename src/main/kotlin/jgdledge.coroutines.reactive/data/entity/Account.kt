package jgdledge.coroutines.reactive.data.entity

import io.micronaut.data.annotation.DateCreated
import io.micronaut.data.annotation.DateUpdated
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.MappedProperty
import java.time.Instant
import java.util.UUID

@MappedEntity("account")
data class Account @JvmOverloads constructor(
    @field:Id
    val id: UUID,
    @MappedProperty("first_name")
    val firstName: String,
    @MappedProperty("last_name")
    val lastName: String,
    @MappedProperty("email")
    val email: String,
    @DateCreated
    val createdAt: Instant = Instant.now(),
    @DateUpdated
    val updatedAt: Instant = Instant.now()
) {

    override fun equals(other: Any?): Boolean {
        return other is Account && id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}