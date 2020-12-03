import scala.io.Source

object Day02 extends App {
  val fileIn = Source.fromFile("input/day_02.txt")
  val passwords = fileIn.getLines().toList

  fileIn.close()

  val answer01 = passwords.map("[-: ]".r.split(_)).map {
    case Array(from, to, chr, _, password) => List(from.toInt, to.toInt, chr.r.findAllMatchIn(password).length);
  }.count {
    case List(from, to, occurrences) => from <= occurrences && occurrences <= to
  }
  println(s"Answer 01: $answer01")


  val answer02 = passwords.map("[-: ]".r.split(_)).count {
    case Array(pos1, pos2, chr, _, password) =>
      val p1 = pos1.toInt - 1
      val p2 = pos2.toInt - 1
      val char = chr.toCharArray.head
      password.charAt(p1) == char && password.charAt(p2) != char || password.charAt(p1) != char && password.charAt(p2) == char;
  }
  println(s"Answer 02: $answer02")


}