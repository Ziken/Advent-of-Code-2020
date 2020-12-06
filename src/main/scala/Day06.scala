import scala.io.Source

object Day06 extends App {
  val fileIn = Source.fromFile("input/day_06.txt")
  val answers = fileIn.mkString
  fileIn.close()


  val answer01 = answers.split("\n\n").map(s => "\\s".r.replaceAllIn(s, "").toSet.toList.length).sum
  val answer02 = answers.split("\n\n").map(s => s.split("\n").map(_.toSet).foldLeft(('a' to 'z').toSet)((acc, v) => {
    acc & v
  }).toList.length).sum

  println(s"Answer 01: $answer01")
  println(s"Answer 01: $answer02")
}