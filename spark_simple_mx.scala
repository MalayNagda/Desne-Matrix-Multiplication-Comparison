package mx_multip
/* SimpleApp.scala */

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.ml.linalg.DenseMatrix
import org.apache.spark.mllib.linalg._
import scala.collection.mutable.ArrayBuffer

object simple_mx {
  def main(args: Array[String]): Unit = {
    
    val conf = new SparkConf().setAppName("ClusterScore").setMaster("local[*]")
    val sc = new SparkContext(conf)
    var iteration= 0
    var total=0.0
    val sum = ArrayBuffer[Long]()
    val N=250
    
    for (a<-0 until N) {
      val rnd= new scala.util.Random()
      iteration+=1
      println("Iteration"+iteration)
      var m=1000
      var n=1000
      
      var A = new DenseMatrix(m,n,Array.fill(m*n)(rnd.nextInt(100)))
      var B = new DenseMatrix(m,n,Array.fill(m*n)(rnd.nextInt(100)))
      
      var now = System.currentTimeMillis
      val C= A.multiply(B)
      var timeElapsed = System.currentTimeMillis - now
      
      println("time taken in iteration " +iteration + " is " + timeElapsed + " ms")
      sum+= timeElapsed
    }
    
    sum.toArray
    for ( i <- 0 to (sum.length - 1)) {
      total += sum(i);
    }
    
    println("Average time for computation of multiplication of 1000x1000 matrices for "+ N + " iterations is " + total/sum.length + " ms.")
  }
}