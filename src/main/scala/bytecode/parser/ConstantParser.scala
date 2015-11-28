package bytecode.parser

import bytecode.model._
import java.io.DataInputStream



class ConstantParser(reader: UnsignedBinaryReader) {
  
  def parse(): Seq[CpInfo] = {
    for(x <- 0 until reader.short() - 1)
      yield parseConstant(reader.byte())  
  }
  
  def parseConstant(constantType: Int): CpInfo = constantType match  {
    case 1 => parseUtf8Info()
    case 7 => parseClassInfo()
    case 8 => parseStringInfo()
    case 9 => parseFieldRefInfo()
    case 10 => parseMethodRefInfo()
    case 12 => parseNameAndType()
    
        
  }

  def parseUtf8Info(): Utf8Info = {
    val length = reader.short()
    
    new Utf8Info(length, reader.bytes(length))  
  }
  
  def parseClassInfo(): ClassInfo = {    
    new ClassInfo(reader.short)    
  }
  
  def parseStringInfo(): StringInfo = {
    new StringInfo(reader.short())
  }
  
  def parseFieldRefInfo(): FieldRefInfo = {
    new FieldRefInfo(reader.short(), reader.short())
  }  
  
  def parseMethodRefInfo(): MethodRefInfo = {    
    new MethodRefInfo(reader.short(), reader.short())
  }
  
  def parseNameAndType(): NameAndTypeInfo = {
    new NameAndTypeInfo(reader.short(), reader.short())
  }
  
}