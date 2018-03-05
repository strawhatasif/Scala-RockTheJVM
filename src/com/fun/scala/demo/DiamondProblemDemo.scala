package com.fun.scala.demo

object DiamondProblemDemo extends App {


  /**
    * The below addresses how Scala solves the dreaded multi-inheritance problem known as the "Diamond Problem"
    * In the Diamond Problem you have a class that extends two classes that extend one super class.
    *
    * Example: Both Lion and Tiger extend Animal
    * Now, we try to implement Mutant which extends both Lion and Tiger
    */

  def diamondDemo = {
    trait Animal { def name: String }
    trait Lion extends Animal { override def name = "LION"}
    trait Tiger extends Animal { override def name = "TIGER" }
    // What will be printed below?
    // Scala will rewrite, behind the scenes, the inheritance so that Mutant extends Lion and then implements a Trait
    // Therefore, TIGER will be printed
    class Mutant extends Lion with Tiger
    val mutant = new Mutant

    println(mutant.name)
  }

  diamondDemo
}
