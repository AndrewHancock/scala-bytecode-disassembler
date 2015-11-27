package bytecode.model

//StackMapFrame
abstract class StackMapFrame {
  def offsetDelta: Integer
}

case class SameFrame(offsetDelta: Integer) extends StackMapFrame
case class SameLocals1StackItemFrame(offsetDelta: Integer, stack: VerificationTypeInfo) extends StackMapFrame
case class SameLocals1StackItemFrameExtended(offsetDelta: Integer, stack: VerificationTypeInfo) extends StackMapFrame
case class ChopFrame(offsetDelta: Integer, absentLastLocals: Byte) extends StackMapFrame
case class SameFrameExtended(offsetDelta: Integer) extends StackMapFrame
case class AppendFrame(offsetDelta: Integer, locals: Array[VerificationTypeInfo]) extends StackMapFrame
case class FullFrame(offsetDelta: Integer, locals: Array[VerificationTypeInfo], stack: Array[VerificationTypeInfo]) extends StackMapFrame