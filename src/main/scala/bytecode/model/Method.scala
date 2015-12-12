package bytecode.model

case class Method(accessFlags: Set[AccessFlag], nameIndex: Int, descriptorIndex: Int, attributes: Seq[Attribute])