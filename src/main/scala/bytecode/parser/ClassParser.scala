package bytecode.parser

import java.io.InputStream
import java.io.DataInputStream
import bytecode.model._


case class FailResult(reason: String)

class ClassParser(inputStream: InputStream) {
  val reader: UnsignedBinaryReader = new UnsignedBinaryReader(new DataInputStream(inputStream))
  val constantParser = new ConstantParser(reader)
  val attributeParser = new AttributeParser(reader)
 
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
          reader.short,  //minor_version
          reader.short,//  //major_version
          constantParser.parse,
          parseAccessFlags,
          reader.short, //this_class
          reader.short, //super_class,
          for(x <- 0 until reader.short - 1)
            yield reader.short,
          parseFields            
          )
      )
      
  }
  
  def parseAccessFlags(): Set[AccessFlag] = {
    val flags = reader.short;
    val flagSet: Set[Pair[Int, AccessFlag]] = Set(
        Pair(0x0001, AccessFlags.Public),
        Pair(0x0010, AccessFlags.Final),
        Pair(0x0020, AccessFlags.Super),
        Pair(0x0200, AccessFlags.Interface),
        Pair(0x0400, AccessFlags.Abstract),
        Pair(0x1000, AccessFlags.Synthetic),
        Pair(0x2000, AccessFlags.Annotation),
        Pair(0x4000, AccessFlags.Enum))
    
        return for(flag <- flagSet if (flags & flag._1) != 0)          
             yield flag._2            
  }
  
  def parseFields: Seq[Field] = {
    for(i <- 0 until reader.short - 1)
      yield parseField;
  }
  
  def parseField: Field = {
    new Field(parseAccessFlags,
        reader.short,
        reader.short,
        attributeParser.parseAttributes
        )
    
  }
  
}