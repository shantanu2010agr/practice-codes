// Variables- Immutable and Mutable
// Arguments- Named and Default
// Classes
// 

// // Unit means void function
fun printMessage(message: String): Unit {                               // 1
    println(message)}
fun printMMessage(message: String){                               // 1
    println(message)}
fun printMessageWithPrefix(message: String, prefix: String = "Info") {  // 2
    println("[$prefix] $message")}
// Int refers the output type
fun sum(x: Int, y: Int): Int {                                          // 3
    return x + y}
fun multiply(x: Int, y: Int) = x * y // 4
fun concate(x: String, y: String) = x+y 
fun divident(x: Int, y: Int) : Pair<Int, Int> { 
    return Pair(x+y, x%y)}
// This won't work.. Not sure why
// fun dividents(x: Int, y: Int) -> (Int, Int) { 
//     return x+y, x%y
// }

fun main() {
    printMessage("Hello")                                               // 5                    
	printMMessage("Hemlo")                                               // 5                    
    printMessageWithPrefix("Hello", "Log")                              // 6
    printMessageWithPrefix("Hello")                                     // 7
    printMessageWithPrefix(prefix = "Log", message = "Hello")           // 8
    println(sum(1, 2))                                                  // 9
    println(multiply(2, 4))                                             // 10
	println(concate(y="Worry...",x="No! "))
    var x=divident(5,3)
    println(x)
    
//     Inflix refers to functions with only one argument.
//     infix fun Int.times(str: String) = str.repeat(this)       
//     println(2 times "Bye ")                                    // 2

    val pair = "Ferrari" to "Katrina"                          // 3
    println(pair)

    infix fun String.onto(other: String) = Pair(this, other)   // 4
    val myPair = "McLaren" onto "Lucasa"
    println(myPair)

    val sophia = Person("Sophia")
    val claudia = Person("Claudia")
    sophia likes claudia  
    
//     Mutable or immutable variables..
    val R=20
    // R=15 (Not possible) or constant (immutable) constant
    println(R)
    var B=10
//     println(B)
    B*=2
//     println(R to B)
    println("$R $B")
    
//  Operator function (a upgrade) can be used to replace function names with the keywords
//  (corresponding to it).....
    operator fun Int.times(str: String) = str.repeat(this)       // 1
    println(4 * ("Bye "))                                          // 2
// 	get() can take [] and integer range
    operator fun String.get(range: IntRange) = substring(range)  // 3
    val str = "Always forgive your enemies; nothing annoys them so much."
    println(str[0..14])
    
    fun printAll(vararg messages: String) {                            // 1
    	for (m in messages) println(m)
    }
    printAll("Hello", "Hallo", "Salut", "Hola", "你好")                 // 2

    fun printAllWithPrefix(vararg messages: String, prefix: String) {  // 3
        for (m in messages) println(prefix + m)
    }
    printAllWithPrefix(
        "Hello", "Hallo", "Salut", "Hola", "你好",
        prefix = "Greeting: "                                          // 4
    )
}

// Class check
class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) { likedPeople.add(other) }  // 6
}
