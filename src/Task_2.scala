/*Write function - generator of infinite sequence numbers - powers of two
* Write same function using unfold function
* def	unfold[T,	S](z:	S)(f:	S	=>	Option[(T,	S)]):	Stream[T]
* */

object Task_2 {
    def main(args: Array[String]): Unit = {
      
      //Following function generates infinite stream where a is first value and second value is previous * b
      def power(a: Long, b: Long): Stream[Long] = a #:: power(a*b,b)
      
      //Following function generate infinity stream of powers of two where first value 2^0
      def powerOfTwo = power(1,2)
      
      //unfold which takes an initial state, and a function for building both the next state and the next value in the stream to be generated
      def unfold[T, S](z: S)(f: S => Option[(T, S)]): Stream[T] = f(z) match {
        case Some((t, s)) => Stream.cons(t, unfold(s)(f))
        case None => Stream.empty[T]
      }
      
      //Generates infinite stream using unfold
      def powerUnfold (a: Long, b: Long) = unfold(a)(a => Some(a, a*b))
      
      //Following function generate infinity stream of powers of two where first value 2^0
      def powerOfTwoUnfold = powerUnfold(1,2)
      
      //tests examples
      powerOfTwo.take(20).print()
      println()
      powerOfTwoUnfold.take(20).print()
      println()
      println(powerOfTwo(10))
      println(powerOfTwoUnfold(10))      
    }
}