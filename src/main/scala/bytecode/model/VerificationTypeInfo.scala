package bytecode.model

abstract class VerificationTypeInfo
case class TopVariableInfo() extends VerificationTypeInfo
case class IntegerVariableInfo() extends VerificationTypeInfo
case class FloatVariableInfo() extends VerificationTypeInfo
case class LongVariableInfo() extends VerificationTypeInfo
case class DoubleVariableInfo() extends VerificationTypeInfo
case class NullVariableInfo() extends VerificationTypeInfo
case class UninitializedThisVariableInfo() extends VerificationTypeInfo
case class ObjectVariableInfo(cpoolIndex: Integer) extends VerificationTypeInfo
case class UninitializedVariableInfo(offset: Integer) extends VerificationTypeInfo