package com.fun.scala.demo

object GenericsDemo extends App {

  def genericsExample = {
    val list: List[String] = List("hello")

    println(list.toString())
  }

  def varianceProblem = {
    class Animal
    class Dog extends Animal

    //The variance problem - should we let B extend A. In our example, can a List of dogs extend a List of animals?

    //OPTION 1: YES! IT'S FINE! covariant Denote this by placing a + operator in front of the class to extend
    //trait List[+Animal]
    class Caretaker[+Animal]
    //The below is OK because we are allowed to extend from Dog
    //but Caretaker[Dog] = new Caretaker[Animal] is not fine as this is stating that we should extend from Dog
    val c: Caretaker[Animal] = new Caretaker[Dog]

    //OPTION 2: NO! invariant (default) - which means any type differences will result in a compiler error
    trait List[Animal]

    //OPTION 3: ABSOLUTELY NOT! contravariant. denote this by placing a - operator in front of the class
    // trait List[-Animal]
    class Trainer[-Animal]

    val a: Trainer[Dog] = new Trainer[Animal]
    //The below is illegal as contravariance prohibits extension from the class that is specified after a - sign
    //val a: Trainer[Animal] = new Trainer[Dog]
    println(a.toString)

  }

  genericsExample
  varianceProblem
}
