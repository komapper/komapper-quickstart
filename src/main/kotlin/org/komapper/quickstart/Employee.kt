package org.komapper.quickstart

import org.komapper.annotation.KomapperAutoIncrement
import org.komapper.annotation.KomapperCreatedAt
import org.komapper.annotation.KomapperEntity
import org.komapper.annotation.KomapperId
import org.komapper.annotation.KomapperUpdatedAt
import org.komapper.annotation.KomapperVersion
import java.time.LocalDateTime

@KomapperEntity
data class Employee(
    @KomapperId @KomapperAutoIncrement
    val id: Int = 0,
    val name: String,
    @KomapperVersion
    val version: Int = 0,
    @KomapperCreatedAt
    val createdAt: LocalDateTime = LocalDateTime.MIN,
    @KomapperUpdatedAt
    val updatedAt: LocalDateTime = LocalDateTime.MIN,
)
