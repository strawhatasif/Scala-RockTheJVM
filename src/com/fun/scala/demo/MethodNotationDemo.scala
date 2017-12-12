package com.fun.scala.demo

object MethodNotationDemo extends App {

  def methodNotationExample = {
    //Familiar procedure to call "contains" method on String class (like we do in Java)
    val str = "I'm learning Scala"
    val condition = str.contains("learning")
    println(condition)

    //Syntactic Sugar! Which means a prettier way of writing the same code
    //Infix notation
    val whoa = str contains "learning"
    println("look ma! no need for periods or parentheses! " + whoa)

    //NOTE: the function with a '+' sign is
    class Simple(val d: Int, val n: Int) {
      def +(other: Simple): Simple = {
        val simple = new Simple(2, 4)
        println(simple)
        return simple
      }
    }
  }

  def postFixNotationExample = {
    class PostFixClass(val i: Int, val x: String) {
      def isHelloWorldString : Boolean = {
        if (x == "hello world") true
        else false
      }
    }
    val postFixClass = new PostFixClass(10, "hello world")
    val isHelloWorld = postFixClass.isHelloWorldString

    println(isHelloWorld)

    //POSTFIX NOTATION - DISCOURAGED BY SCALA AFTER V. 2.1.0
    val postFixExample = new PostFixClass(5, "not hello world")
    val isHelloWorldOrNot = postFixExample isHelloWorldString
    //println(isHelloWorldOrNot)
  }

  def prefixNotationExample = {
    class PrefixClass(val s: Int, val r: Int) {
      def unary_- : PrefixClass = new PrefixClass(-s, r)
    }

    val prefixClass = new PrefixClass(2, 4)
    val num = -prefixClass

    //this will print -2
    println(num.s)
  }

  methodNotationExample
  prefixNotationExample
}
