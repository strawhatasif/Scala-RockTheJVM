package com.fun.scala.demo

object CallDemo extends App {

  def calledByValue(x: Long) = {
    println("by val: " + x)
    println("by val: " + x)
    //so x would be the value from System.nanoTime()
  }

  /**
    * Although this looks deceivingly similar to calledByValue
    * this function actually evaluates the expression
    * instead of substituting the value generated
    * @param x
    */
  def calledByName(x: => Long) = {
    println("by name: " + x)
    println("by name: " + x)
    //so x would call System.nanoTime()
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  // A function that will recursively call itself infinitely...will crash the JVM!
  def infinite : Int = 1 + infinite

  def printFirst(x: Int, y: => Int) = println(x)

  // This results in a StackOverflowError
  // printFirst(infinite, 2)

  // No StackOverflowError as Scala recomputes the arguments to their type (eg. Int)
  // In the below example - infinite is an Int and since the second argument is y: => Int, this is reassigned
  printFirst(2, infinite)
}
