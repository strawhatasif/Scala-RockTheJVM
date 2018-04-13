package com.fun.scala.commands
import com.fun.scala.filesystem.State

class Pwd extends Command {
  override def apply(state: State): State =
    state.setMessage(state.workingDirectory.path)
}
