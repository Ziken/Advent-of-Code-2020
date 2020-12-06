val seats = List(
  "BFFFBBFRRR", "FFFBBBFRRR", "BBFFBBFRLL"
)
seats.map((seat) => {
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
}).max

//val seat = "FBFBBFFRLR"
//
//val rowStr = seat(0)
//val colStr = seat(1)
//
//val rowId = rowStr.foldLeft(Tuple2(0 ,127)) {
//  case (Tuple2(from, to), direction) =>
//    if (direction == 'F')
//        Tuple2(from, (from+to)/2)
//    else Tuple2((from+to)/2+1, to)
//}._1
//
//val colId = colStr.foldLeft(Tuple2(0 ,7)) {
//  case (Tuple2(from, to), direction) =>
//    if (direction == 'L')
//      Tuple2(from, (from+to)/2)
//    else Tuple2((from+to)/2+1, to)
//}._1
//
//rowId*8+colId