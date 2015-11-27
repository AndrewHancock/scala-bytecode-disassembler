package bytecode.model

case class ClassInfo(nameIndex: Integer)
case class DoubleInfo(highBytes: Integer, lowBytes: Integer)
case class FieldRefInfo(classIndex: Integer, nameAndTypeIndex: Integer)
case class FloatInfo(bytes: Integer)
case class IntegerInfo(bytes: Integer)
case class InvokeDynamic(biitstrapMethodAttrIndex: Integer, nameAndTypeIndex: Integer)
case class LongInfo(highBytes: Integer, LowBytes:Integer)
case class MethodHandleInfo(referenceKind: Byte, referenceIndex: Integer)
case class MethodRefInfo(classIndex: Integer, nameAndTypeIndex: Integer)
case class NameAndTypeInfe(nameIndex: Integer, descriptorIndex: Integer)
case class StringInfo(stringIndex: Integer)
case class Utf8Info(length: Integer, bytes: Array[Byte])

