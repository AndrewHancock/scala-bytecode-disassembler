package bytecode.parser

import bytecode.model.Attribute
import bytecode.model.CpInfo

class AttributeParser(constantPool : Seq[CpInfo], reader: UnsignedBinaryReader) {
  def parseAttributes: Seq[Attribute] = { 
    
    for(i <- 0 until reader.short)       
      yield parseAttribute  
  }
  
  def parseAttribute: Attribute = {
    val attributeNameIndex = reader.short()
    val attributeLength = reader.int().intValue()
    val attributeInfo = reader.bytes(attributeLength)
    
    new Attribute(attributeNameIndex, attributeLength)
  }
}