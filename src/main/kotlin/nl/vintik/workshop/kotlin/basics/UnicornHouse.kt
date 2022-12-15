package nl.vintik.workshop.kotlin.basics

import java.util.UUID

class UnicornHouse {
    /**
     * Collections such as list or map by default are immutable, you need to explicitly specify one as mutable
     * For more see https://kotlinlang.org/docs/list-operations.html
     */
    private val unicorns = mutableListOf<Unicorn>()

    /**
     * When expression example, for more see https://kotlinlang.org/docs/control-flow.html#when-expression
     * @param unicorn is defined as not null
     */
    fun enter(unicorn: Unicorn): String {
        unicorns.add(unicorn)
        unicorn.description?.let {
            println("Unicorn description: $it")
        }
        return when (unicorn.type) {
            UnicornType.UNICORN -> "Welcome European Unicorn ${unicorn.name}"
            UnicornType.DEMICORN -> "Welcome Mild Magic Unicorn ${unicorn.name}"
            UnicornType.MALICORN -> "Welcome Malicious Unicorn ${unicorn.name}"
        }
    }

    fun countUnicorns() = unicorns.size

    fun countUnicornsByType(unicornType: UnicornType) = unicorns.count { it.type == unicornType }

    fun exit(unicornId: UUID) = unicorns.removeIf { it.id == unicornId }

    fun mapByType() = unicorns.associateBy { it.type }

    fun orderBySize() = unicorns.sortedByDescending { it.size }

    fun totalMagicInDaHouse() = unicorns.sumOf { it.magic ?: 0 }

}