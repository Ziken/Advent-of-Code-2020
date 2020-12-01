import scala.io.Source

object Day01 extends App {
  val fileIn = Source.fromFile("input/day_01.txt")
  val numbers = fileIn.getLines().toList.map(_.toInt)
  fileIn.close()

  val answer01 = numbers.combinations(2).filter {
    case List(a, b) => a+b == 2020
  }.map {
    case List(a,b) => a * b
  }.toList.head


  val answer02 = numbers.combinations(3).filter {
    case List(a, b, c) => a+b+c == 2020
  }.map {
    case List(a, b, c) => a * b * c
  }.toList.head

  println(s"Answer 01 ${answer01}")
  println(s"Answer 02 ${answer02}")

}