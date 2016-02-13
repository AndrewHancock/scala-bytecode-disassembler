package bytecode.parser

import java.io.DataInputStream

class UnsignedBinaryReader(dis: DataInputStream) {
  var pos: Int = 0
  def byte(): Short = { 
    pos = pos +  1 
    (dis.readByte & 0x00FF).toShort
    }
  def short() : Int = {
    pos = pos + 2
    dis.readShort & 0x00FF
  }
    
  def int() : Long = {
    pos = pos + 4
    dis.readInt.toLong << 32 >>> 32;
  }
  def bytes(length: Int): Seq[Byte] = {
    pos = pos + length
    val result = new Array[Byte](length)
    dis.readFully(result)
    result
  }
  
  
}