import java.lang.IllegalArgumentException
class KotlinIntro {
    //Hello, world!
    fun start(): String {
        return "OK"
    }
    // Named Arguments
    fun joinOptions(options: Collection<String>) =
        options.joinToString(prefix ="[", postfix = "]")

    //Default Arguments
    fun foo(name: String, number: Int = 42, toUpperCase: Boolean = false) =
        (if (toUpperCase) name.uppercase() else name) + number

    // Triple-quoted strings
    val question = "life, the universe, and everything"
    val answer = 42

    val tripleQuotedString = """
    #question = "$question"
    #answer = $answer""".trimMargin("#")

    // String tampletes
    val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"

    // Function to throw an exception for wrong age
    fun failWithWrongAge(age: Int?): Nothing {
        throw IllegalArgumentException("Wrong age: $age")
    }

    // Function to check age and print next year's age
    fun checkAge(age: Int?) {
        if (age == null || age !in 0..150) failWithWrongAge(age)
        println("Congrats! Next year you'll be ${age + 1}.")
    }

    // Function to check if a collection contains an even number
    fun containsEven(collection: Collection<Int>): Boolean =
        collection.any { it % 2 == 0 }
}
fun main() {
    // Create an instance of KotlinIntro
    val intro = KotlinIntro()

    // Call the start function
    println(intro.start())  // This will print "OK"

    // Named Arguments
    val options = listOf("a", "b", "c")
    println(intro.joinOptions(options))  // Output: [a, b, c]

    //Default Arguments
    fun useFoo() = listOf(
        intro.foo("a"),
        intro.foo("b", number = 1),
        intro.foo("c", toUpperCase = true),
        intro.foo(name = "d", number = 2, toUpperCase = true)
    )
    // Triple-quoted strings
    println(intro.tripleQuotedString)

    // Regex pattern using interpolation
    fun getPattern(): String = """\d{2} (${intro.month}) \d{4}"""
    println(getPattern())  // Output: \d{2} (JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC) \d{4}

    // Checking age
    intro.checkAge(10)

}