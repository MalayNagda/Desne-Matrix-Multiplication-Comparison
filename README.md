# Desne Matrix Multiplication Comparison
 A comparison of average comutation time for dense matrix multiplication in Scala without Breeze, Scala with Breeze and Apache Spark.
 
## Code Overview

The objective was to generate two 1000x1000 sized random matrices and perform the multiplication between the two in order to compare the computation time between different programming environments 
that are used for large scale applications. This was repeated 250 times for each environment and the average computation time for each is listed in the table below.

| Programming environment  | Average computation time (ms) |
| ------------- | ------------- |
| Scala (without Breeze)  | 1774.48  |
| Scala (with Breeze)  | 413.82  |
| Apache Spark  | 642.56  |

## Code execution details

All the three codes were implemented as Maven projects in IntelliJ IDEA.