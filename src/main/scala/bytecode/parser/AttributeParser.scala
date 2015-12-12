package bytecode.parser

import bytecode.model.Attribute

class AttributeParser(reader: UnsignedBinaryReader) {
  def parseAttributes: Seq[Attribute] = {
    for(i <- 0 until reader.short - 1)
      yield parseAttribute
  }
  
  def parseAttribute: Attribute = {
    val attributeNameIndex = reader.short()
    val attributeLength = reader.int()
    
    new Attribute(attributeNameIndex, attributeLength)
  }
}