import scala.io.Source

object Day04 extends App {
  val fileIn = Source.fromFile("input/day_04.txt")
  val passports = fileIn.mkString
  fileIn.close()
  val requiredFields = Array(
    "byr", // (Birth Year)
    "iyr", // (Issue Year)
    "eyr", // (Expiration Year)
    "hgt", // (Height)
    "hcl", // (Hair Color)
    "ecl", // (Eye Color)
    "pid", // (Passport ID)
    //  "cid", // (Country ID)
  )

  val answer01 = passports.split("\n\n").count((passport) => {
    requiredFields.map(_ + ":").count(passport.contains(_)) == requiredFields.length
  })

  val answer02 = passports.split("\n\n").count(_.split(Array('\n', ' ', ':')).grouped(2).count {
    // (Birth Year) - four digits; at least 1920 and at most 2002.
    case Array("byr", value) => value.toInt >= 1920 && value.toInt <= 2002
    // (Issue Year) - four digits; at least 2010 and at most 2020.
    case Array("iyr", value) => value.toInt >= 2010 && value.toInt <= 2020
    // (Expiration Year) - four digits; at least 2020 and at most 2030.
    case Array("eyr", value) => value.toInt >= 2020 && value.toInt <= 2030
    // (Height) - a number followed by either cm or in:
    // - If cm, the number must be at least 150 and at most 193.
    // - If in, the number must be at least 59 and at most 76.
    case Array("hgt", value) =>
      val unit = "[a-z]+".r.findFirstIn(value)
      val actualValue = "[0-9]+".r.findFirstIn(value).get.toInt

      if (unit.isEmpty)
        false
      else if (unit.get == "cm")
        actualValue >= 150 && actualValue <= 193
      else if (unit.get == "in")
        actualValue >= 59 && actualValue <= 76
      else
        false
    // (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
    case Array("hcl", value) => "#[0-9Aa-f]{6}".r.matches(value)
    // (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
    case Array("ecl", value) => Set("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(value)
    // pid (Passport ID) - a nine-digit number, including leading zeroes.
    case Array("pid", value) => "[0-9]{9}".r.matches(value)
    case Array("cid", _) => false
  } == 7)

  println(s"Answer 01: $answer01")
  println(s"Answer 01: $answer02")

}