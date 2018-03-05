package com.fun.scala.commands

import com.fun.scala.filesystem.State

class UnknownCommand extends Command {

  override def apply(state: State): State =
    state.setMessage("command not found!")
}
