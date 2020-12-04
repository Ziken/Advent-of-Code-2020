import scala.io.Source

object Day03 extends App {
  def getNumberOfEncounteredTrees(input: List[String], rightStep: Int, downStep: Int): Int = {
    val lineLength = lines.head.length

    input.tail.grouped(downStep).flatMap(_.lift(downStep - 1)).zip(LazyList from 1).foldLeft(0) {
      case (acc, (line, lineIndex)) =>
        if (line.charAt((lineIndex * rightStep) % lineLength) == '#') acc + 1
        else acc
    }
  }

  val fileIn = Source.fromFile("input/day_03.txt")
  val lines = fileIn.getLines().toList

  fileIn.close()

  val answer01 = getNumberOfEncounteredTrees(lines, 3, 1)

  val steps = List(
    List(1, 1),
    List(3, 1),
    List(5, 1),
    List(7, 1),
    List(1, 2),
  )
  val answer02:Long = steps.map {
    case List(rightStep, downStep) => getNumberOfEncounteredTrees(lines, rightStep, downStep).toLong
  }.product

  println(s"Answer 01: $answer01")
  println(s"Answer 02: $answer02")


}