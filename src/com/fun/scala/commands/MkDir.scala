package com.fun.scala.commands
import com.fun.scala.files.{DirEntry, Directory}
import com.fun.scala.filesystem.State

class MkDir(name: String) extends CreateEntry(name) {
  override def performCreateEntry(state: State): DirEntry = {
    Directory.empty(state.workingDirectory.path, name)
  }
}
