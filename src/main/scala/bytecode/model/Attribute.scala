package bytecode.model

abstract class Attribute() {
  def attributeNameIndex: Integer
  def attributeLength: Long
}
case class Code(attributeNameIndex: Integer, attributeLength: Long, maxStack: Integer, maxLocals: Integer, code: Array[Byte], exceptionTable: Array[CodeException], attributeInfo: Array[Attribute]) extends Attribute
case class CodeException(attributeNameIndex: Integer, attributeLength: Long, startPc: Integer, endPc: Integer, handlerPc: Integer, catchType: Integer) extends Attribute
/*case class ConstantValue(attributeNameIndex: Integer, attributeLength: Long, constantValueIndex: Integer) extends Attribute
case class StackMapTable(attributeNameIndex: Integer, attributeLength: Long, numberOfEntries: Integer, entries: Array[StackMapFrame]) extends Attribute
case class Exception(attributeNameIndex: Integer, attributeLength: Long, exceptionIndexTable: Array[Integer]) extends Attribute
case class InnerClass(innerClassInfoIndex: Integer, outerClassInfoIndex: Integer, innerNameIndex: Integer, innerclassAccessFlags: Integer)
case class InnerClasses(attributeNameIndex: Integer, attributeLength: Long, numberOfClasses: Integer, classes: Array[InnerClasses]) extends Attribute
case class EnclosingMethod(attributeNameIndex: Integer, attributeLength: Long, classIndex: Integer, methodIndex: Integer) extends Attribute
case class Synthetic(attributeNameIndex: Integer, attributeLength: Long) extends Attribute
case class Signature(attributeNameIndex: Integer, attributeLength: Long, signatureIndex: Integer) extends Attribute
case class SourceFile(attributeNameIndex: Integer, attributeLength: Long, sourceFileIndex: Integer) extends Attribute
case class SourceDebugExtension(attributeNameIndex: Integer, attributeLength: Long, debugExtension: Array[Short]) extends Attribute
case class LineNumber(startPc: Integer, lineNumber: Integer)
case class LineNumberTable(attributeNameIndex: Integer, attributeLength: Long, lineNumberTable: Array[LineNumber]) extends Attribute
case class LocalVariable(startPc: Integer, length: Integer, nameIndex: Integer, descriptorIndex: Integer, index: Integer) 
case class LocalVariableTable(attributeNameIndex: Integer, attributeLength: Long, localVariableTable: Array[LocalVariable])  extends Attribute
case class Deprecated(attributeNameIndex: Integer, attributeLength: Long) extends Attribute
case class RuntimeVisibileAnnotations(attributeNameIndex: Integer, attributeLength: Long, annotations: Array[Annotation]) extends Attribute
case class RuntimeInisibileAnnotations(attributeNameIndex: Integer, attributeLength: Long, annotations: Array[Annotation]) extends Attribute
case class RuntimeVisibleParameterAnnotations(attributeNameIndex: Integer, attributeLength: Long, parameterAnnotations: Array[Pair[Integer, Array[Annotation]]]) extends Attribute
case class RuntimeInvisibleParameterAnnotations(attributeNameIndex: Integer, attributeLength: Long, parameterAnnotiations: Array[Pair[Integer, Array[Annotation]]]) extends Attribute
case class BootstrapMethods(attributeNameIndex: Integer, attributeLength: Long, bootstrapArguments: Array[BootstrapMethod])
*/