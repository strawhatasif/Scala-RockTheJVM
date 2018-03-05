package com.fun.scala.commands

import com.fun.scala.filesystem.State

trait Command {
  def apply(state: State) : State
}

object Command {
  def from(name: String) : Command =
    new UnknownCommand

}

