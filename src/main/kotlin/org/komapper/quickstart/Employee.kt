package org.komapper.quickstart

import org.komapper.annotation.KmAutoIncrement
import org.komapper.annotation.KmCreatedAt
import org.komapper.annotation.KmEntity
import org.komapper.annotation.KmId
import org.komapper.annotation.KmUpdatedAt
import org.komapper.annotation.KmVersion
import java.time.LocalDateTime

@KmEntity
data class Employee(
    @KmId @KmAutoIncrement val id: Int = 0,
    val name: String,
    @KmVersion val version: Int = 0,
    @KmCreatedAt val createdAt: LocalDateTime = LocalDateTime.MIN,
    @KmUpdatedAt val updatedAt: LocalDateTime = LocalDateTime.MIN,
) {
    companion object
}
