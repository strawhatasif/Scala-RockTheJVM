package com.fun.scala.demo

object SuperDemo extends App {


  /**
    * Look up Type Linearization to see what the structure of inheritance is.
    *
    * In the below it would be:
    *
    * C = AnyRef with Base2 with Base1 with A with B with C
    */

  def superDemo = {
    println("hello?")
    trait Base1 {
      def print: Unit  = {
        println("Base 1")
      }
    }

    trait A extends Base1 {
      override def print: Unit = {
        println("from A")
        super.print
      }
    }
    trait B extends Base1{
      override def print: Unit = {
        println("from B")
        super.print
      }
    }

    class Base2 {
      def print: Unit = {
        println("Base 2")
      }
    }

    class C extends Base2 with A with B {
      override def print: Unit = {
        println("from C")
        super.print
      }
    }

  }

  superDemo
}
