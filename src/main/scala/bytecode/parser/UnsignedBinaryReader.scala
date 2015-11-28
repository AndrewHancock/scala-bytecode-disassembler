package bytecode.parser

import java.io.DataInputStream

class UnsignedBinaryReader(dis: DataInputStream) {  
  def byte(): Short = (dis.readByte & 0x00FF).toShort
  def short() : Int = dis.readShort & 0x00FF
  def int() : Long = dis.readInt.toLong << 32 >>> 32
}