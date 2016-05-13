package bytecode.model

abstract class Op
case object ALoad0 extends Op
case class InvokeSpecial(methodIndex: Int) extends Op
case object AConstNull extends Op
case object Return extends Op
