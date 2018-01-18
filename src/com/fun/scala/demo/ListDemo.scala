package com.fun.scala.demo

import scala.annotation.tailrec

object ListDemo extends App {
  val listA = Nil
  val listB = new Cons(2, new Cons(4, Nil))

  //Scala is smart enough to append .toString to whatever you pass in println
  //so the below would actually be println(listA.toString)
  println(listA)
  println(listB)

  println(listB.reverse)

  val listC = listB ++ new Cons(5, new Cons(1, new Cons(9, Nil)))
  val deepList = new Cons(listB, new Cons(listA, new Cons(listC, Nil)))

  val listD = List.flatten(deepList)
  //Scala creates an anonymous inner class of Predicate and overrides the method(s)
  //you need to implement the return here
  val predicate: Predicate[Int] = new Predicate[Int] {
    override def apply(elem: Int): Boolean = elem % 2 == 0
  }

  println(listD filter predicate)
}

// Covariant list
trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  def add[S >: T](elem: S): List[S]
  def ++[S >: T](other: List[S]): List[S]
  def reverse: List[T]
  def filter[S >: T] (predicate: Predicate[S]) : List[S]
}

//Nothing is offered by Scala as a placeholder to be replaced by any other type. Nothing is the absence of any other value.
//S >: Nothing denotes S is the supertype of Nothing
object Nil extends List[Nothing] {
  override def isEmpty: Boolean = true
  override def head: Nothing = throw new NoSuchElementException
  override def tail: List[Nothing] = throw new UnsupportedOperationException
  override def add[S](elem: S): List[S] = new Cons(elem, Nil)
  override def ++[S](other: List[S]) : List[S] = other
  override def reverse: List[Nothing] = Nil
  override def toString: String = "[]"
  override def filter[S](predicate: Predicate[S]): List[Nothing] = Nil
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  override def isEmpty: Boolean = false
  override def add[S >: T](elem: S): List[S] = new Cons(elem, this)
  override def ++[S >: T](other: List[S]) : List[S] = new Cons(head, tail ++ other)

  override def reverse: List[T] = {
    @tailrec
    def reverseUtil(input: List[T], output: List[T]) : List[T] = {
      if(input.isEmpty) output
      else reverseUtil(input.tail, new Cons(input.head, output))
    }

    reverseUtil(this, Nil)
  }

  override def toString: String = {
    def enumerateAll(list: List[T]) : String =
      if(list.isEmpty) ""
      else if(list.tail.isEmpty) "" + list.head
      else list.head + " " + enumerateAll(list.tail)

    "[" + enumerateAll(this) + "]"
  }

  override def filter[S>: T](predicate: Predicate[S]): List[S] = {
    if (predicate.apply(head)) new Cons(head, tail filter predicate)
    else tail filter predicate
  }
}

object List {
  def flatten[T](deepList: List[List[T]]): List[T] = {
    //if(deepList.isEmpty) Nil
    //else deepList.head ++ flatten(deepList.tail)

    def flattenUtil(remaining: List[List[T]], currentListExpanding: List[T], acc: List[T]) : List[T] = {
      if(currentListExpanding.isEmpty) {
        if (remaining.isEmpty) acc
        else flattenUtil(remaining.tail, remaining.head, acc)
      } else flattenUtil(remaining, currentListExpanding.tail, new Cons(currentListExpanding.head, acc))
    }
    flattenUtil(deepList, Nil, Nil).reverse
  }
}

trait Predicate[T] {
  def apply(elem: T): Boolean
}