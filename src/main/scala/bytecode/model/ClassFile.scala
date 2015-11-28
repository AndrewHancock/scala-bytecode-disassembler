package bytecode.model

case class ClassFile(
    minorVersion: Int,
    majorVersion: Int,
    constantPool: Seq[CpInfo]
    ){
    
}