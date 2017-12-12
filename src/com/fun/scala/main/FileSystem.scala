package com.fun.scala.main

import java.util.Scanner

import com.fun.scala.commands.Command
import com.fun.scala.files.Directory

object FileSystem extends App {
  //prep the variables
  val initialRoot = Directory.newRoot
  var state = State(initialRoot, initialRoot);
  val scanner = new Scanner(System.in)

  //show the command line, fetch command, and then
  //change state to reflect new command

  while(true)
    state.show
    state = Command.sourceString(scanner.nextLine()).apply(state)
}
