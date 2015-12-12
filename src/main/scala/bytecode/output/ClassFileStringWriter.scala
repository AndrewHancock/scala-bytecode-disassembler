package bytecode.output

import bytecode.model._



object ClassFilePrinter {
  def printClassFile(classFile: ClassFile) = {
    println("Version: " + classFile.majorVersion + "." + classFile.minorVersion)
    
    var i = 1;
    for(constant <- classFile.constantPool) {
      print(i + " ")
      i = i + 1
      printConstant(constant)   
      
    }
    printAccessFlags(classFile.accessFlags)
    println("this_class: " + classFile.thisClass)
    println("super_class: " + classFile.superClass)
    println("Interfaces: " + classFile.interfaces)
    println("Fields: " + classFile.fields)
    println("Methods: " + classFile.methods)
    println("Attributes: " + classFile.attributes)
  }
  
  def printConstant(constant: CpInfo) = constant match{
    case ClassInfo(nameIndex) => println("ClassInfo -> name_index: " + nameIndex)
    case MethodRefInfo(classIndex, nameAndTypeIndex) => println("MethodRefInfo -> class_index: " + classIndex + " name_and_type_index: " + nameAndTypeIndex)
    case FieldRefInfo(classIndex, nameAndTypeIndex) => println("FieldRefInfo -> class_index: " + classIndex + " name_and_type_index: " + nameAndTypeIndex)
    case NameAndTypeInfo(nameIndex, descriptorIndex) => println("NameAndTypeInfo -> name_index: " + nameIndex + " descriptor_index: " + descriptorIndex)
    case StringInfo(stringIndex) => println("StringInfo -> string_index: " + stringIndex)
    case Utf8Info(length, bytes) => println("Utf8Info -> length: " + length + " bytes: " + utf8BytesToString(bytes))    
  }
  
  private def utf8BytesToString(bytes: Seq[Byte]): String = new String(bytes.toArray, "UTF-8")
  
  def printAccessFlags(flags: Set[AccessFlag]) = {
    println("Access flags:")
    for(flag <- flags)
      println("\t" + flag.toString())
      
  }
  
  def printMethods(methods: Seq[Method]) = {
    println("")
  }
  
  def printAttributes(attributes: Seq[Attribute]) = {
    println(attributes)
  }
  
  
  
  
}