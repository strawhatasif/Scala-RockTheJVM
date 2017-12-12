package com.fun.scala.commands

import com.fun.scala.main.State

trait Command {
  def apply(state: State) : State
}

object Command {
  def unknownCommand(name: String) =
    new Command {
      override def apply(state: State) : State =
        state.withMessage(name + ": command not found")
    }

  def sourceString(input: String): Command = {
    val tokens = input.trim.split(" ")
    unknownCommand(tokens(0))
  }
}

