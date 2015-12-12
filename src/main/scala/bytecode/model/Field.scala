package bytecode.model

case class Field(accessFlags: Set[AccessFlag], nameIndex: Int, descriptorIndex: Int, attributes: Seq[Attribute])