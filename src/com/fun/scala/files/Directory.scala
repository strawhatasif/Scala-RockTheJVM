package com.fun.scala.files

import com.fun.scala.filesystem.FileSystemException

import scala.annotation.tailrec

class Directory (override val parentPath: String,
                 override val name: String,
                 val contents: List[DirEntry])
  extends DirEntry(parentPath, name)
{
  def hasEntry(name: String) : Boolean =
    findEntry(name) != null

  def getAllDirectoriesInPath: List[String] =
    // /a/b/c/d => List["a", "b", "c", "d"]
    path.substring(1).split(Directory.SEPARATOR).toList.filter(x => !x.isEmpty)

  def findDescendent(path: List[String]) : Directory =
    if (path.isEmpty) this
    else findEntry(path.head).asDirectory.findDescendent(path.tail)

  def addEntry(newEntry: DirEntry) : Directory =
    new Directory(parentPath, name, contents :+ newEntry)

  def findEntry(entryName: String) : DirEntry = {
    @tailrec
    def findEntryHelper(name: String, contentList: List[DirEntry]): DirEntry =
      if (contentList.isEmpty) null
      else if (contentList.head.name.equals(name)) contentList.head
      else findEntryHelper(name, contentList.tail)

    findEntryHelper(entryName, contents)
  }

  def replaceEntry(entryName: String, newEntry: DirEntry) : Directory =
    new Directory(parentPath, name, contents.filter(e => !e.name.equals(entryName)) :+ newEntry)

  def asDirectory: Directory = this

  def asFile: File = throw new FileSystemException("a Directory CANNOT be converted to a File")

  def getType: String = "Directory"
}

object Directory {
  val SEPARATOR : String = "/"
  val ROOT : String = "/"

  //An empty function that sets up a new root
  def empty(parentPath: String, name: String) =
    new Directory(parentPath, name, List())

  def newRoot : Directory = Directory.empty("", "")
}
