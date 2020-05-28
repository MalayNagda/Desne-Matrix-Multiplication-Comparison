package breeze_multip
import scala.collection.mutable.ArrayBuffer

import breeze.linalg.DenseMatrix
import breeze.linalg._
import breeze.numerics._
import breeze.numerics._

object breeze_multip {
  def main(args: Array[String]): Unit = {
    var iteration= 0
    var total=0.0
    val sum = ArrayBuffer[Long]()
    val N= 250
    for (a<-0 until N) {
      iteration+=1
      var lhs = DenseMatrix.rand[Double](1000, 1000)
      var rhs = DenseMatrix.rand[Double](1000, 1000)
      var now = System.currentTimeMillis
      var product = lhs * rhs
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
}
