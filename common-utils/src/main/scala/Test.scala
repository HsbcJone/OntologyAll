import java.io.{BufferedReader, ByteArrayOutputStream, InputStream, InputStreamReader}

import scala.collection.mutable.ListBuffer

/**
 *
 * 命令行或者界面 mvn clean package -P  dev
 * config into jars
 * @Auther Jone
 * @Date 2019-10-28
 * @Package
 */
object Test {

  def main(args: Array[String]): Unit = {
    val var1=this.getClass.getResourceAsStream("config.properties")
    val  str=inputStreamToString(var1)
    println(str)
  }


  def inputStreamToString(is: InputStream) = {
    val rd: BufferedReader = new BufferedReader(new InputStreamReader(is, "UTF-8"))
    val builder = new StringBuilder()
    try {
      var line = rd.readLine
      while (line != null) {
        builder.append(line + "\n")
        line = rd.readLine
      }
    } finally {
      rd.close
    }
    builder.toString
  }
}
