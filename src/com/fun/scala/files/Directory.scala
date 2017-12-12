package com.fun.scala.files

class Directory (override val parentPath: String,
                 override val name: String,
                 val contents: List[DirEntry])
  extends DirEntry(parentPath, name)
{

}

object Directory {
  val SEPARATOR : String = "/"
  val ROOT : String = "/"

  //An empty function that sets up a new root
  def empty(parentPath: String, name: String) =
    new Directory(parentPath, name, List())

  def newRoot : Directory = Directory.empty("", "")
}
