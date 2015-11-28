package bytecode

import bytecode.parser.ClassParser
import java.io.FileInputStream
object Disassembler {
  def main(args: Array[String]) = {
    val parser = new ClassParser(new FileInputStream(args(0)))
    println(parser.parseClass.right.toOption.get.toString)
  
  }
}