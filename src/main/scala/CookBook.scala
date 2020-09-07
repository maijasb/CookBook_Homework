import java.io.FileWriter

object CookBook extends App {
  //  val srcName = "Text.txt"
  //  val dstName = "13177-8-results.txt"
  val srcName = "c:/Users/Sabule Maija/IdeaProjects/Homework/13177-8.txt"
  val dstName = "C:/Users/Sabule Maija/IdeaProjects/Homework/results"
  def openSource(fName:String) = {
    //actually get a real sequence of strings
    val filePointer = scala.io.Source.fromFile(srcName)
    val myLines = filePointer.getLines.toSeq

    filePointer.close()
    myLines
  }

  def processSeq(mySeq:Seq[String])= {

    var funSeq = mySeq.slice(1064, 2960).filter(t => (t == t.toUpperCase()) || (t(0) == ' ')).filterNot(t => t.contains('*') || t.contains('"')).zipWithIndex

// does not work
//    for {
//      (text, i) <- funSeq
//      if (funSeq(i)._1 == funSeq(i)._1.toUpperCase()) && (funSeq(i + 1)._1 == funSeq(i + 1)._1.toUpperCase())
//      //funSeq(i + 1)._1
//      //else funSeq(i)._1
//      }yield funSeq


   funSeq.map(t => t._1)

  }

  def saveSeq(destName:String, mySeq:Seq[String]) = {
    println(s"Saving my Sequence to file $destName")
    mySeq.foreach(println) //we are good up to here
    val fw = new FileWriter(destName)
    mySeq.map(_ + "\n").foreach(fw.write) // adding new line to each line before writing
    fw.close()
  }

  //the actual program runs here, little tiny pipeline like a factory
  val mySeq = openSource(srcName)
  val filteredSeq = processSeq(mySeq)
  saveSeq(dstName,filteredSeq)
}