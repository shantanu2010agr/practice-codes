// https://play.kotlinlang.org/
// Try copy code and play around the above link.

// Codes are being instructed (in main()..) in the given order as the list of topics.
// Init and constructor keywords in CLasses
// When -> similar to case of c++/python
// Loops - For, Do-While, While, Iterators
// Ranges
// Equality Checks
// Conditional Expression

fun main(){
    val pers =Person("Ajay", 25)
    pers.printfancy()
    
    val pers2 =Person2("Ajay", 25)
    pers2.printfancy()
    
    println(whenAssign("Hello"))
    println(whenAssign(3.4))
    println(whenAssign(1))
    println(whenAssign(MyClass()))
    
    val cakes = listOf("carrot", "cheese", "chocolate")
	for (cake in cakes) {                               // 1
    	println("Yummy, it's a $cake cake!")
	}
    
    fun eatACake() = println("Eat a Cake")
    fun bakeACake() = println("Bake a Cake")

    var cakesEaten = 0
    var cakesBaked = 0
    while (cakesEaten < 2) {                    // 1
        eatACake()
        cakesEaten ++
    }
    do {                                        // 2
        bakeACake()
        cakesBaked++
    } while (cakesBaked < cakesEaten)
    
    val zoo = Zoo(listOf(Animal("zebra"), Animal("lion")))
    for (animal in zoo) {                                   // 3
        println("Watch out, it's a ${animal.name}")
    }
    
    for(i in 0..3) {             // 1
        print(i)}
    print(" ")
    for(i in 0 until 3) {        // 2
        print(i)}
    print(" ")
    for(i in 2..8 step 2) {      // 3
        print(i)}
    print(" ")
    for (i in 3 downTo 0) {      // 4
        print(i)}
    print(" ")
    
//     This is not possible for float/double/long double thing:
//     for (i in 2.8..3.7 step 0.1){
//         println(i)}
	for (i in 28..37){
        print(i/10)}
    println()
    
//     Step can't be negative
//     for(i in 12..8 step -1) {      // 3
//         print(i)}
//     print(" ")
	
    for (c in 'z' downTo 's' step 2) { // 2
        print(c)}
    println()
    val x=2
    if (x !in 6..10) {          // 2
        println("x is not in range from 6 to 10")
    }
    
//     Kotlin uses '==' for structural comparison and '===' for referential comparison.
    val authors = setOf("Shakespeare", "Hemingway", "Twain")
    val writers = setOf("Twain", "Shakespeare", "Hemingway")
    println(authors == writers)   // 1
    println(authors === writers)  // 2
    
    fun max(a: Int, b: Int) = if (a > b) a else b         // 1
    println(max(99, -42))
    fun maxi(a:Int, b: Int): Int{
        if (a>b) return a
        else return b}
    println(maxi(23,-89))
}

class Animal(val name: String)
class Zoo(val animals: List<Animal>) {
    operator fun iterator(): Iterator<Animal> {             // 1
        return animals.iterator()                           // 2
    }
}

fun whenAssign(obj: Any): Any {
    val result = when (obj) {                   // 1
        1 -> "one"                              // 2
        "Hello" -> 1                            // 3
        is Long -> false                        // 4
        else -> 42                              // 5
    }
    return result
}
class MyClass // Written just for checking the else thing.

class Person{
    val firstName: String	
    private var age: Int	
    // traditional way of declaring a constructor
	constructor(fName: String, personAge: Int=30)
    {
        firstName = fName.capitalize()
        age = personAge
		println("From class Person, fn constructor. Class members have been initialized")
    }
    // initializer blocks
    init 
    {
        println("From class Person, fn init block 1.")
    }
    init 
    {
        println("From class Person, fn init block 2.")        
    }
    fun printfancy()
    {
        print("From class Person, fn printFancy, ")
        println("firstName is $firstName, age is $age")}}
class Person2(fName: String, personAge: Int=30){
    val firstName: String	
    private var age: Int	 
	init
    {
        firstName = fName.capitalize()
        age = personAge
		println("From class Person2, fn init block 1. Variables initialized")
    }
    // initializer block
    init 
    {
        println("From class Person2, fn init block 2")
    }
    fun printfancy()
    {
        print("From class Person2, fn printFancy, ")
        println("firstName is $firstName, age is $age")
    }
}