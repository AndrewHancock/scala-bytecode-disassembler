package bytecode.model

abstract class CpInfo
case class ClassInfo(nameIndex: Integer) extends CpInfo 
case class DoubleInfo(highBytes: Integer, lowBytes: Integer) extends CpInfo
case class FieldRefInfo(classIndex: Integer, nameAndTypeIndex: Integer) extends CpInfo
case class FloatInfo(bytes: Integer) extends CpInfo
case class IntegerInfo(bytes: Integer) extends CpInfo
case class InvokeDynamic(biitstrapMethodAttrIndex: Integer, nameAndTypeIndex: Integer) extends CpInfo
case class LongInfo(highBytes: Integer, LowBytes:Integer) extends CpInfo
case class MethodHandleInfo(referenceKind: Byte, referenceIndex: Integer) extends CpInfo
case class MethodRefInfo(classIndex: Integer, nameAndTypeIndex: Integer) extends CpInfo
case class NameAndTypeInfe(nameIndex: Integer, descriptorIndex: Integer) extends CpInfo
case class StringInfo(stringIndex: Integer) extends CpInfo
case class Utf8Info(length: Integer, bytes: Array[Byte]) extends CpInfo

