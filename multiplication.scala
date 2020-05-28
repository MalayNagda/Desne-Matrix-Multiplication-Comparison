package Demo
import scala.collection.mutable.ArrayBuffer

object Demo {
  def main(args: Array[String]): Unit = {

    var iteration= 0
    var total=0.0
    val sum = ArrayBuffer[Long]()
    val N=250
    for (a<-0 until N) {

      iteration+=1
      var x = {
        random2dArray(1000, 1000, 100)
      }
      var y = {
        random2dArray(1000, 1000, 100)
      }
      var result = {
        random2dArray1(1000, 1000, 0)
      }

      var now = System.currentTimeMillis
      for (i <- 0 to 999) {
        for (j <- 0 to 999) {
          result(i)(j) = 0
          for (k <- 0 to 999) {
            result(i)(j) = result(i)(j) + x(i)(k) * y(k)(j)
          }
        }
      }
      var timeElapsed = System.currentTimeMillis - now

      println("time taken in iteration " +iteration + " is " + timeElapsed + " ms")
      sum+= timeElapsed
    }

    sum.toArray
    for ( i <- 0 to (sum.length - 1)) {
      total += sum(i);
    }

    println("Average time for computation of multiplication of 1000x1000 matrices for "+ iteration + " iterations is " + total/sum.length + " ms.")
    }
  def random2dArray(dim1: Int, dim2: Int, maxValue: Int): Array[Array[Int]] = Array.fill(dim1, dim2) { scala.util.Random.nextInt(maxValue) }
  def random2dArray1(dim1: Int, dim2: Int, maxValue: Int): Array[Array[Int]] = Array.fill(dim1, dim2) {1}
}
