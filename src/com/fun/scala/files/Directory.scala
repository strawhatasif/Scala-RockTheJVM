package com.fun.scala.files

class Directory (override val parentPath: String,
                 override val name: String,
                 val contents: List[DirEntry])
  extends DirEntry(parentPath, name)
{
  def hasEntry(name: String) : Boolean = ???

  def getAllDirectoriesInPath: List[String] =
    // /a/b/c/d => List["a", "b", "c", "d"]
    path.substring(1).split(Directory.SEPARATOR).toList

  def findDescendent(path: List[String]) : Directory = ???

  def addEntry(newEntry: DirEntry) : Directory = ???

  def findEntry(entryName: String) : DirEntry = ???

  def replaceEntry(entryName: String, newEntry: DirEntry) : Directory = ???

  def asDirectory: Directory = this
}

object Directory {
  val SEPARATOR : String = "/"
  val ROOT : String = "/"

  //An empty function that sets up a new root
  def empty(parentPath: String, name: String) =
    new Directory(parentPath, name, List())

  def newRoot : Directory = Directory.empty("", "")
}
