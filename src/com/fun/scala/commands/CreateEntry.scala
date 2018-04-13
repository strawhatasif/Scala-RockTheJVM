package com.fun.scala.commands

import com.fun.scala.files.{DirEntry, Directory}
import com.fun.scala.filesystem.State

abstract class CreateEntry(name: String) extends Command {

  override def apply(state: State): State = {
    val workingDirectory = state.workingDirectory
    if (workingDirectory.hasEntry(name)) {
      state.setMessage("Entry " + name + " already exists!")
    }
    else if (name.contains(Directory.SEPARATOR)) {
      state.setMessage(name + " must not contain separators (/)")
    }
    else if (validateName(name)) {
      state.setMessage(name + ": is not valid!")
    }
    else {
      executeMkDir(state, name)
    }
  }

  def validateName(name: String): Boolean = {
    name.contains(".")
  }

  def executeMkDir(state: State, name: String) : State = {
    def updateStructure(currentDirectory: Directory, paths: List[String], newDirectoryEntry: DirEntry) : Directory = {
      if (paths.isEmpty) currentDirectory.addEntry(newDirectoryEntry)
      else {
        println(paths)
        println(currentDirectory.findEntry(paths.head).asDirectory)
        val oldEntry = currentDirectory.findEntry(paths.head).asDirectory
        currentDirectory.replaceEntry(oldEntry.name, updateStructure(oldEntry, paths.tail, newDirectoryEntry))
      }
    }

    val workingDirectory = state.workingDirectory

    // 1. get all the directories in the full path
    val allDirectoriesInPath = workingDirectory.getAllDirectoriesInPath

    val newEntry:DirEntry = performCreateEntry(state)
    // 3. update the whole directory structure starting from the root (dir structure is immutable)
    val newRoot = updateStructure(state.root, allDirectoriesInPath, newEntry)
    // 4. find new working directory instance given workingDirectories full path
    val newWorkingDirectory = newRoot.findDescendent(allDirectoriesInPath)

    State(newRoot, newWorkingDirectory)
  }

  def performCreateEntry(state: State): DirEntry
}
