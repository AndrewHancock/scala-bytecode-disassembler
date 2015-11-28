package bytecode.parser

import java.io.InputStream;
import java.io.DataInputStream
import bytecode.model.ClassFile

case class FailResult(reason: String)

class ClassParser(inputStream: InputStream) {
  val reader: UnsignedBinaryReader = new UnsignedBinaryReader(new DataInputStream(inputStream))
  val constantParser = new ConstantParser(reader)
 
  def parseMagicNumber(): Boolean = {
    val magicNumber = reader.int()
    magicNumber.toInt == 0xCAFEBABE
  }
  
  def parseVersion(): Int = return reader.short()
  
  def parseClass() : Either[FailResult, ClassFile] = {
    if(!parseMagicNumber)
      Left(FailResult("Magic number did not match."))
    else
      Right(new ClassFile(
          reader.short(),  //minor_version
          reader.short(),//  //major_version
          constantParser.parse()
          ))
      
  }
  
}