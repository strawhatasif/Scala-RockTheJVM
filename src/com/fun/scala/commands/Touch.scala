package com.fun.scala.commands
import com.fun.scala.files.{DirEntry, File}
import com.fun.scala.filesystem.State

class Touch(name: String) extends CreateEntry(name) {

  override def performCreateEntry(state: State): DirEntry = {
    File.empty(state.workingDirectory.path, name)
  }

}
