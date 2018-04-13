package com.fun.scala.files

import com.fun.scala.filesystem.FileSystemException


class File(override val parentPath: String, override val name: String, contents: String)
  extends DirEntry(parentPath, name) {

  def asDirectory: Directory =
    throw new FileSystemException("A file cannot be converted to a directory")

  def asFile: File = this

  def getType: String = "File"
}

object File {

  def empty(parentPath: String, name: String): File = {
    new File(parentPath, name, "")
  }
}
