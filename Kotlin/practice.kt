// Variables- Immutable and Mutable
// Arguments- Named and Default
// Classes (Also Generic)
// Inheritance
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

// Mutable Stack, Generic Classes(Templates)
class MutableStack<E>(vararg items: E) {              // 1
  private val elements = items.toMutableList()
  fun push(element: E) = elements.add(element)        // 2
  fun peek(): E = elements.last()                     // 3
  fun pop(): E = elements.removeAt(elements.size - 1)
  fun isEmpty() = elements.isEmpty()
  fun size() = elements.size
  override fun toString() = "MutableStack(${elements.joinToString()})"
}
// Generic functions
// You can also generify functions if their logic is independent of a specific type. 
// For instance, you can write a utility function to create mutable stacks:
fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)

// Inherited class
open class Lion(val name: String, val origin: String) {
    fun sayHello() {
        println("$name, the lion from $origin says: graoh!")}}
class Asiatic(name: String) : Lion(name = name, origin = "India") // 1

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
    
//  Generic function/class use..
    val stack = mutableStackOf(0.62, 3.14, 2.7)
    println(stack)
    println(stack.pop())
    stack.push(2.87)
    println(stack.size())
    
//  Example for inheritance
    val lion: Lion = Asiatic("Rufo")                             
    lion.sayHello()

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
    
//     Null safety...
    var neverNull: String = "This can't be null"            // 1
//     neverNull = null   (since it is non-nullable string)  // 2

    var nullable: String? = "You can keep a null here"      // 3
    nullable = null                                         // 4

    var inferredNonNull = "The compiler assumes non-null"   // 5
//     inferredNonNull = null  //(since it is non-nullable string) // 6

    fun strLength(notNull: String): Int {                   // 7
        return notNull.length
    }
    println(strLength(neverNull))                             // 8
//     strLength(nullable) (notPossible because function doesn't exist for nullable string)

    fun describeString(maybeString: String?): String {              // 1
        if (maybeString != null && maybeString.length > 0) {        // 2
            return "String of length ${maybeString.length}"
        } else {
            return "Empty or null string"                           // 3
        }
    }
    println(describeString(nullable))
}

// Class check
class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) { likedPeople.add(other) }  // 6
}