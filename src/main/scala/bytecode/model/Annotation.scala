package bytecode.model

abstract class ElementValue

case class ConstValueIndex(constValueIndex: Integer) extends ElementValue
case class EnumConstValue(typeNameIndex: Integer, constNameIndex: Integer)
case class ClassInfoIndex(classInfoIndex: Integer) extends ElementValue
case class AnnotationValue(annotationValue: Annotation) extends ElementValue
case class ArrayValue(values: Array[ElementValue]) extends ElementValue

case class Annotation(typeIndex: Integer, elementValuePairs: Array[Pair[Integer, ElementValue]])