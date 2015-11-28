package bytecode

import bytecode.parser.ClassParser
import java.io.FileInputStream
import bytecode.output.ClassFilePrinter
object Disassembler {
  def main(args: Array[String]) = {
    val parser = new ClassParser(new FileInputStream(args(0)))
    ClassFilePrinter.printClassFile(parser.parseClass.right.toOption.get)
  
  }
}