package bytecode.parser

import bytecode.model.Attribute
import bytecode.model.Code
import bytecode.model.CpInfo
import bytecode.model.Utf8Info
import bytecode.model.Op
import bytecode.model.ALoad0
import bytecode.model.InvokeSpecial
import bytecode.model.AConstNull
import bytecode.model.Return

class AttributeParser(reader: UnsignedBinaryReader) {
  def parseAttributes(constantPool : Seq[CpInfo]): Seq[Attribute] = { 
    
    for(i <- 0 until reader.short)       
      yield parseAttribute (constantPool)
  }
  
  def parseAttribute(constantPool : Seq[CpInfo]): Attribute = {
    val attributeNameIndex = reader.short()
    
    val utfStr = constantPool(attributeNameIndex - 1) match  {
      case utf: Utf8Info => utf.toString()
    }
    
    utfStr match {
      case "Code" => parseCode
    }
  }
  
  private def parseCode: Code = {
    val attributeLength = reader.int
    val maxStack = reader.short
    val maxLocals = reader.short
    val codeLength = reader.int    
    val bytes = reader.bytes(codeLength)
    val ops = parseOp(bytes)
    
    new Code(9, attributeLength, maxStack, maxLocals, ops, null, null)
  }
  
  def parseOp(bytes: Seq[Int]) : Seq[Op]= {
    bytes match {
    case head +: tail => head match {
        
          case 42 => Seq[Op](ALoad0) ++ parseOp(bytes.tail)
          case 183 => Seq[Op](InvokeSpecial(tail.head)) ++ parseOp(tail.tail)
          case 1 => Seq[Op](AConstNull) ++ parseOp(tail)
          case 177 => Seq[Op](Return) ++ parseOp(tail)
          case _ => Seq[Op]()
      }
    case Nil => Seq()
    }
  }
}