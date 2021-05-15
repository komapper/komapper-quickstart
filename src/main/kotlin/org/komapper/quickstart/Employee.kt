package org.komapper.quickstart

import org.komapper.annotation.KmAutoIncrement
import org.komapper.annotation.KmCreatedAt
import org.komapper.annotation.KmEntityDef
import org.komapper.annotation.KmId
import org.komapper.annotation.KmUpdatedAt
import org.komapper.annotation.KmVersion
import java.time.LocalDateTime

data class Employee(
    val id: Int = 0,
    val name: String,
    val version: Int = 0,
    val createdAt: LocalDateTime = LocalDateTime.MIN,
    val updatedAt: LocalDateTime = LocalDateTime.MIN,
)

@KmEntityDef(Employee::class)
data class EmployeeDef(
    @KmId @KmAutoIncrement val id: Nothing,
    @KmVersion val version: Nothing,
    @KmCreatedAt val createdAt: Nothing,
    @KmUpdatedAt val updatedAt: Nothing,
) {
    companion object
}
