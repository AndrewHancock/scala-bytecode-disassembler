package bytecode.parser

import bytecode.model.CpInfo
import bytecode.model.ClassInfo
import java.io.DataInputStream



class ConstantParser(reader: UnsignedBinaryReader) {
  
  def parse(): Seq[CpInfo] = {
    for(x <- 0 until reader.short())
      yield parseConstant(reader.byte())  
  }
  
  def parseConstant(constantType: Int): CpInfo = constantType match  {
    case 7 => parseClassInfo()
    
        
  }
  
  def parseClassInfo(): ClassInfo = {
    reader.byte();
    new ClassInfo(reader.short)    
  }
  
}