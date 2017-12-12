package com.fun.scala.main

import com.fun.scala.files.Directory

class State(val root: Directory, val workingDirectory: Directory, val output: String )
{
  def showShell: Unit =
    print(State.SHELL_TOKEN)

  //REMEMBER! Unit is analogous to "void" in Java! It returns nothing!
  def show: Unit = {
    println(output)
    showShell
  }

  //let's BUILD A NEW STATE! woo!
  def withMessage(message: String) : State =
    new State(root, workingDirectory, message)
}

object State {
  val SHELL_TOKEN = "$ "
  def apply (root: Directory, workingDirectory: Directory, output: String = "") =
    new State(root, workingDirectory, output)
}
