The `removeIf` function is not designed to work directly with maps in the way that it does with lists, because it expects a predicate that takes a single element (in the case of a map, a key-value pair) to evaluate rather than the value alone.  To remove entries based on the value in a map, iterate through the keys and remove elements directly:

fun main() {
    val list = mutableListOf(1, 2, 3, 4, 5)
    list.removeIf { it > 2 }
    println(list) // Output: [1, 2]

    val map = mutableMapOf("a" to 1, "b" to 2, "c" to 3)
    val keysToRemove = mutableListOf<String>()
    for ((key, value) in map) {
        if (value > 2) {
            keysToRemove.add(key)
        }
    }
    keysToRemove.forEach { map.remove(it) }
    println(map) // Output: {a=1, b=2}

    //Alternative using filterNot
    val map2 = mutableMapOf("a" to 1, "b" to 2, "c" to 3)
    map2.entries.removeIf { it.value > 2 }
    println(map2) //Output: {a=1, b=2}
} 