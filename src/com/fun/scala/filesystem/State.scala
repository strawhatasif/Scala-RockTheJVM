package com.fun.scala.filesystem

import com.fun.scala.files.Directory

class State(val root: Directory, val workingDirectory: Directory, val output: String )
{
  def showShell: Unit =
    print(output)
    print(State.SHELL_TOKEN)

  //REMEMBER! Unit is analogous to "void" in Java! It returns nothing!
  def show: Unit = {
    println(output)
  }

  //let's BUILD A NEW STATE! woo!
  def setMessage(message: String) : State =
    State(root, workingDirectory, message)
}

object State {
  val SHELL_TOKEN = "$ "
  def apply (root: Directory, workingDirectory: Directory, output: String = ""): State =
    new State(root, workingDirectory, output)
}
