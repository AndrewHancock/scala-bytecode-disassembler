package bytecode.model

abstract class AccessFlag
object AccessFlags {
  object Public extends AccessFlag
  object Final extends AccessFlag
  object Super extends AccessFlag
  object Interface extends AccessFlag
  object Abstract extends AccessFlag
  object Synthetic extends AccessFlag
  object Annotation extends AccessFlag
  object Enum extends AccessFlag
}