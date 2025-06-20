# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

### Build and Run
```bash
# Run the application
./gradlew run

# Build the project (compile and test)
./gradlew build

# Run tests
./gradlew test

# Run a single test class
./gradlew test --tests ApplicationTest

# Clean build artifacts
./gradlew clean

# Compile without running tests
./gradlew assemble
```

### Development Commands
```bash
# Check code (runs all verification tasks)
./gradlew check

# Generate KSP code (happens automatically during build)
./gradlew kspKotlin
```

## Code Architecture

### Overview
This is a Komapper quickstart project demonstrating the Komapper ORM framework for Kotlin. Komapper provides type-safe database access with compile-time code generation via KSP (Kotlin Symbol Processing).

### Key Architectural Patterns

1. **Entity Definition with Annotations**
   - Entities are defined as immutable data classes with Komapper annotations
   - `@KomapperEntity` marks a class as a database entity
   - `@KomapperId` with `@KomapperAutoIncrement` for primary keys
   - `@KomapperVersion` for optimistic locking
   - `@KomapperCreatedAt`/`@KomapperUpdatedAt` for automatic timestamps

2. **Code Generation via KSP**
   - KSP generates metamodel classes (e.g., `_Employee`) at compile time
   - Metamodels provide type-safe property references accessed via `Meta.employee`
   - No runtime reflection, improving performance

3. **Type-Safe Query DSL**
   - All database operations use Komapper's type-safe DSL
   - Queries are built using `QueryDsl` with compile-time verification
   - Example: `QueryDsl.from(e).where { e.name eq "John" }`

4. **Transaction Management**
   - Explicit transactions using `database.withTransaction { ... }`
   - All operations within the block are atomic

### Project Structure

- `src/main/kotlin/org/komapper/quickstart/`
  - `Application.kt` - Main entry point demonstrating Komapper usage
  - `Employee.kt` - Entity definition with Komapper annotations
- `build/generated/ksp/` - Generated metamodel classes (created during build)
- Database: Uses H2 in-memory database for the example

### Important Technical Details

- **Kotlin Version**: 2.1.21
- **Komapper Version**: 5.3.0
- **Target JVM**: Java 11
- **KSP**: Version 2.1.21-2.0.2 with KSP2 enabled
- **Testing**: JUnit 5 (Jupiter)

### External Documentation
For detailed Komapper documentation, refer to: https://www.komapper.org/docs/quickstart/