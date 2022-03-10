package org.komapper.quickstart

import org.komapper.core.dsl.Meta
import org.komapper.core.dsl.QueryDsl
import org.komapper.jdbc.JdbcDatabase

fun main() {
    // (1) create a database instance
    val database = JdbcDatabase("jdbc:h2:mem:quickstart;DB_CLOSE_DELAY=-1")

    // (2) start transaction
    database.withTransaction {

        // (3) get an entity metamodel
        val e = Meta.employee

        // (4) create schema
        database.runQuery {
            QueryDsl.create(e)
        }

        // (5) insert multiple employees at once
        database.runQuery {
            QueryDsl.insert(e).multiple(Employee(name = "AAA"), Employee(name = "BBB"))
        }

        // (6) select all
        val employees = database.runQuery {
            QueryDsl.from(e).orderBy(e.id)
        }

        // (7) print all results
        for ((i, employee) in employees.withIndex()) {
            println("RESULT $i: $employee")
        }
    }
}
