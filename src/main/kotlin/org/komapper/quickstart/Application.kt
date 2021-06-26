package org.komapper.quickstart

import org.komapper.core.dsl.EntityDsl
import org.komapper.core.dsl.SchemaDsl
import org.komapper.jdbc.JdbcDatabase
import org.komapper.tx.jdbc.withTransaction

fun main() {
    // (1) create a database instance
    val database = JdbcDatabase.create("jdbc:h2:mem:quickstart;DB_CLOSE_DELAY=-1")

    // (2) start transaction
    database.withTransaction {

        // (3) get an entity metamodel
        val e = EmployeeDef.meta

        // (4) create schema
        database.runQuery {
            SchemaDsl.create(e)
        }

        // (5) insert multiple employees at once
        database.runQuery {
            EntityDsl.insert(e).multiple(Employee(name = "AAA"), Employee(name = "BBB"))
        }

        // (6) select all
        val employees = database.runQuery {
            EntityDsl.from(e).orderBy(e.id)
        }

        // (7) print all results
        for ((i, employee) in employees.withIndex()) {
            println("RESULT $i: $employee")
        }
    }
}
