package com.fun.scala.demo

import java.io.{FileNotFoundException, FileReader, IOException}

object ExceptionDemo extends App {
  // NOTE: Scala Exceptions are actually Java Exceptions!

  // type Throwable is the equivalent of java.lang.Throwable
  // type Exception is the equivalent of java.lang.Exception
  // type Error is the equivalent of java.lang.Error
  // type RuntimeException is the equivalent of java.lang.RuntimeException
  // type NullPointerException is the equivalent of java.lang.NullPointerException
  def exceptionExample = {
    class InvalidDenominatorException(msg: String) extends Exception(msg)

    // Java has checked and unchecked exceptions
    // Checked exceptions issue compile errors if not handled (in Java)
    // ALL EXCEPTIONS ARE UNHANDLED IN SCALA!!!
      // This is why the below code compiles successfully! Even though InvalidDenominatorException extends Exception
      // which extends java.lang.Exception (a checked exception)

    class Rational(val n: Int, val d: Int) {
      if (d == 0)
        throw new InvalidDenominatorException("The denominator cannot be 0!")
    }

    val y = new Rational(5, 0)
    println(y.d)
  }

  // The below will print "IO EXCEPTION!" since blah.txt does not exist
  // It will also print "all other operations" as finally executes regardless
  def tryCatchExample = {
      try {
         val sampleFile = new FileReader("blah.txt")
      }
      catch {
        case _: IOException => println("IO EXCEPTION! ") // handle Input/Output Exception
        case _: FileNotFoundException => println("FILE NOT FOUND!")// handle a File Not Found exception
        case _: Exception => println("UH OH!")// handle any other exception
      }
      finally {
        println("all other operations")
      }

  }
  exceptionExample
  tryCatchExample
}
