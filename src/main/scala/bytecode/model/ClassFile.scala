package bytecode.model


case class ClassFile(
    minorVersion: Int,
    majorVersion: Int,
    constantPool: Seq[CpInfo],
    accessFlags: Set[AccessFlag]    ,
    thisClass: Int,
    superClass: Int,
    interfaces: Seq[Int]
    ){
    
}