package com.fun.scala.demo

object StringDemo extends App {

  def stringFun(x: String) = {
    val a = x.charAt(2)
    println(a)

    val b = x.length
    println(b)

    val c = x.nonEmpty
    println(c)
  }

  stringFun("Hello again! How's it going?")
}
