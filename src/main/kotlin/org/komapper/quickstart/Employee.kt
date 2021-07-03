package org.komapper.quickstart

import org.komapper.annotation.KomapperAutoIncrement
import org.komapper.annotation.KomapperCreatedAt
import org.komapper.annotation.KomapperEntityDef
import org.komapper.annotation.KomapperId
import org.komapper.annotation.KomapperUpdatedAt
import org.komapper.annotation.KomapperVersion
import java.time.LocalDateTime

data class Employee(
    val id: Int = 0,
    val name: String,
    val version: Int = 0,
    val createdAt: LocalDateTime = LocalDateTime.MIN,
    val updatedAt: LocalDateTime = LocalDateTime.MIN,
)

@KomapperEntityDef(Employee::class)
data class EmployeeDef(
    @KomapperId @KomapperAutoIncrement val id: Nothing,
    @KomapperVersion val version: Nothing,
    @KomapperCreatedAt val createdAt: Nothing,
    @KomapperUpdatedAt val updatedAt: Nothing,
) {
    companion object
}
