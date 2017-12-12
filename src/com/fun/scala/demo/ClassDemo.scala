package com.fun.scala.demo

object ClassDemo extends App {


  /**
    * OVERALL NOTE: PARAMETERLESS FUNCTIONS DO NOT REQUIRE PARENTHESES AFTER THE NAME OF THE FUNCTION
    * Example: def printHelloWorld - sufficient for a method which does not take any arguments
    */

  def simpleClassExample = {
    class SimpleClass(n: Int, d: String)
    val simpleClass = new SimpleClass(2, "I am not a member of this class")
    //This will return the error "value 'n' is not a member of SimpleClass" if you attempt to print x
    //UNCOMMENT BELOW IF YOU WANT TO SEE AN ERROR!
    //val x = simpleClass.n;
    //println("x " + x)
  }

  def correctClassExample = {
    class PromotingVariablesToMembers(var n: Int, val d: String)

    val promotingVariablesToMembers = new PromotingVariablesToMembers(2, "I am now a member of this class!")
    //Reassignment is legal because we're assigning n as var
    //val however is recommended because you know what the assignment is.
    //var may lead to unwanted behavior and concurrency problems
    var x = promotingVariablesToMembers.n
    x = 4
    println(x)
  }

  simpleClassExample
  correctClassExample
}
