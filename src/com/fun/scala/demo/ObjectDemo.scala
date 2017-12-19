package com.fun.scala.demo

object ObjectDemo extends App {


  class Rational(private val n: Int, private val d: Int) {
    def negated: Rational = Rational.multiply(this, Rational.minusOne)
  }
  object Rational {
    private val minusOne = Rational(-1, 1)
    def apply(n: Int, d: Int): Rational = new Rational(n, d)
    def multiply(r1: Rational, r2: Rational) : Rational =
      Rational(r1.n * r2.n, r1.d * r2.d)
    println(minusOne.d)
  }

  //Apply is syntactic sugar that allows the below
  //The compiler understands the below as val rationalClass = Rational.apply(2,3)
  //Also, apply handles instantiating a new object
  val rationalClass = Rational(2,3)
}
