package com.fun.scala.commands
import com.fun.scala.files.DirEntry
import com.fun.scala.filesystem.State

/**
  * Created by rab4154 on 3/20/2018.
  */
class Ls extends Command {

  override def apply(state: State): State = {
    val contents = state.workingDirectory.contents
    val formattedOutput = createFormattedOutputFromContents(contents)
    state.setMessage(formattedOutput)
  }

  def createFormattedOutputFromContents(contents: List[DirEntry]): String = {
    if (contents.isEmpty) ""
    else {
      val entry = contents.head
      entry.name + "[" + entry.getType + "]\n" + createFormattedOutputFromContents(contents.tail)
    }
  }
}
