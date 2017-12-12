package com.fun.scala.files

class File (override val parentPath: String,
            override val name: String,
            val contents: String)
  extends DirEntry(parentPath, name)
{

}
