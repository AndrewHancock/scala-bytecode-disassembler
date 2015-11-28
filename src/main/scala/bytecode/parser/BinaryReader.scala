package bytecode.parser

import java.io.DataInputStream

object BinaryReader {
  def readUnsignedByte(dis: DataInputStream) : Short = (dis.readByte & 0x00FF).toShort
  def readUnsignedShort(dis: DataInputStream) : Int = dis.readShort & 0x00FF
  def readUnsignedInt(dis: DataInputStream) : Long = dis.readInt.toLong << 32 >>> 32
}