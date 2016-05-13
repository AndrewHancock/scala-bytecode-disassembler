package bytecode.output

import bytecode.model._

object ClassFilePrinter {
  def printClassFile(classFile: ClassFile) = {
    println("Version: " + classFile.majorVersion + "." + classFile.minorVersion)

    println("Constant Pool:")
    var i = 1;
    for (constant <- classFile.constantPool) {
      print(i + " ")
      i = i + 1
      println(constantStr(constant))

    }
    println("Access Flags:")
    for (flag <- accessFlagsStr(classFile.accessFlags))
      println("\t" + flag)

    println("this_class: " + classFile.thisClass)
    println("super_class: " + classFile.superClass)
    printInterfaces(classFile);
    println("Fields: " + classFile.fields)
    println("Methods:")
    printMethods(classFile)
  }

  def constantStr(constant: CpInfo): String = constant match {
    case ClassInfo(nameIndex)                        => "ClassInfo -> name_index: " + nameIndex
    case MethodRefInfo(classIndex, nameAndTypeIndex) => "MethodRefInfo -> class_index: " + classIndex + " name_and_type_index: " + nameAndTypeIndex
    case FieldRefInfo(classIndex, nameAndTypeIndex)  => "FieldRefInfo -> class_index: " + classIndex + " name_and_type_index: " + nameAndTypeIndex
    case NameAndTypeInfo(nameIndex, descriptorIndex) => "NameAndTypeInfo -> name_index: " + nameIndex + " descriptor_index: " + descriptorIndex
    case StringInfo(stringIndex)                     => "StringInfo -> string_index: " + stringIndex
    case utf: Utf8Info                               => utf.toString()
  }

  def accessFlagsStr(flags: Set[AccessFlag]): Set[String] = {
    for (flag <- flags)
      yield flag match {
      case AccessFlags.Public     => "Public"
      case AccessFlags.Final      => "Final"
      case AccessFlags.Super      => "Super"
      case AccessFlags.Interface  => "Interface"
      case AccessFlags.Abstract   => "Abstract"
      case AccessFlags.Synthetic  => "Synthetic"
      case AccessFlags.Annotation => "Annotation"
      case AccessFlags.Enum       => "Enum"
    }
  }

  def printInterfaces(classFile: ClassFile) = {
    println("Interaces:")
    for (i <- classFile.interfaces) {
      print("\t");
      println(constantStr(classFile.constantPool(i - 1)))
    }
  }

  def printMethods(classFile: ClassFile) = {
    for (method <- classFile.methods) {
      for (accessFlag <- accessFlagsStr(method.accessFlags)) {
        print(accessFlag + " ")
      }
      print(constantStr(classFile.constantPool(method.nameIndex - 1)) + " ")
      println(constantStr(classFile.constantPool(method.descriptorIndex - 1)))
      println("Attributes:")
      printAttributes(classFile.constantPool, method.attributes)
    }
  }

  def printAttributes(constants: Seq[CpInfo], attributes: Seq[Attribute]) = {
    for (attribute <- attributes) {
      println("Attribute Type: " + constantStr(constants(attribute.attributeNameIndex - 1)))
      attribute match {
        case code: Code => printCode(code.code)
      }
    }
  }

  def printCode(code: Seq[Op]) = {

    for (op <- code) {
      op match {
        case ALoad0            => println("aload_0")
        case op: InvokeSpecial => println("invokespecial " + op.methodIndex)
        case AConstNull        => println("aconst_null")
        case Return            => println("return")
      }
    }
  }
}