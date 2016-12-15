/*
 * def curry[A, B, C](f: (A, B) => C): A => (B => C) 
 * */

object Task_1 {
  def main(args: Array[String]) {
    //Following function divides numbers of double type
    def div(a: Double, b: Double) = a/b
    
    //Following function takes as argument function of following form f(a,b)
    //and as result return function of following form f(a)(b)
    def curry[A, B, C](f: (A, B) => C): A => (B => C) = a => (b => (f(a,b)))
    
    //Currying function div
    def divide_a_by_b = curry(div)
    
    //partially applies a as 2
    def divide_two = divide_a_by_b(2)
    
    //partially applies b as 2
    def divide_by_two = divide_a_by_b(_ : Double)(2)
    
    //tests examples
    println(divide_two(10))          // 2/10 = 0.2
    println(divide_two(0))           // 2/0 = infinity
    println(divide_a_by_b(100)(10))  // 100/10 = 10
    println(divide_a_by_b(10)(-100)) // 10/(-100) = -0.1
    println(divide_by_two(10))       // 10/2 = 5
    println(divide_by_two(0))        // 0/2 = 0
  }
}