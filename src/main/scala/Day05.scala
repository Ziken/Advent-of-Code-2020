import scala.io.Source

object Day05 extends App {
  def getFreeSeat(seatIds: List[Int]):Int = {
    seatIds.sorted.foldLeft(seatIds(0))((prevSeat, currentSeat) => {
      if (currentSeat - prevSeat > 1)
        return currentSeat - 1
      currentSeat
    })
  }

  val fileIn = Source.fromFile("input/day_05.txt")
  val seats = fileIn.getLines().toList
  fileIn.close()

  val seatIds = seats.map(seat => {
    val groupedSeat = seat.grouped(7).toList
    val rowStr = groupedSeat(0)
    val colStr = groupedSeat(1)

    val rowId = rowStr.foldLeft(Tuple2(0 ,127)) {
      case (Tuple2(from, to), direction) =>
        if (direction == 'F')
          Tuple2(from, (from+to)/2)
        else Tuple2((from+to)/2+1, to)
    }._1

    val colId = colStr.foldLeft(Tuple2(0 ,7)) {
      case (Tuple2(from, to), direction) =>
        if (direction == 'L')
          Tuple2(from, (from+to)/2)
        else Tuple2((from+to)/2+1, to)
    }._1

    rowId*8+colId
  })

  val answer01 = seatIds.max
  val answer02 = getFreeSeat(seatIds)
  println(s"Answer 01: $answer01")
  println(s"Answer 02: $answer02")
}