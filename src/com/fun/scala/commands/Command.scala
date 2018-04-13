package com.fun.scala.commands

import com.fun.scala.filesystem.State

trait Command {
  def apply(state: State) : State
}

object Command {
  val MKDIR = "mkdir"
  val LS    = "ls"
  val PWD   = "pwd"
  val TOUCH = "touch"

  def emptyCommand : Command = new Command {
    override def apply(state: State): State = state
  }

  def incompleteCommand(name: String): Command = new Command {
    override def apply(state: State): State =
      state.setMessage(name + ": incomplete command!!!")
  }

  def from(name: String) : Command = {
      val tokens: Array[String] = name.split(" ")

      if (name.isEmpty || tokens.isEmpty) emptyCommand
      else if (MKDIR.equals(tokens(0))) {
        if (tokens.length < 2) incompleteCommand(MKDIR)
        else new MkDir(tokens(1))
      }
      else if (LS.equals(tokens(0))) {
        new Ls
      }
      else if (PWD.equals(tokens(0))) {
        new Pwd
      }
      else if (TOUCH.equals(tokens(0))) {
        if (tokens.length < 2) incompleteCommand(TOUCH)
        new Touch(tokens(1))
      }
      else {
        new UnknownCommand
      }
  }


}

