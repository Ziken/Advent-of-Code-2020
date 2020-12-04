val input = "..##.......\n#...#...#..\n.#....#..#.\n..#.#...#.#\n.#...##..#.\n..#.##.....\n.#.#.#....#\n.#........#\n#.##...#...\n#...##....#\n.#..#...#.#".split('\n')
/*
..##.......
#...#...#..
.#....#..#.
..#.#...#.#
.#...##..#.
*/


// Down = 11
// Right = 3
val lineLength = 11
val step = 11 + 3
val rightStep = 3
val downStep = 1
// Next pos 14 - 1
// Next pos 28 - 1
val highlightPos = List(
  step, // left 3
  2 * step, // left 6
  3 * step, // left 9
  4 * step // 12
)

//input.tail.zipWithIndex.foldLeft(0)((acc, b) => {
//  println(acc, b)
//  acc + 1
//})
//input.tail.zipWithIndex
//input.tail.zip(LazyList from 1).foldLeft(0) {
//  case (acc, (line, pos)) => {
//    if (line.charAt(((pos)*rightStep) % lineLength) == '#') acc + 1
//    else acc
//  }
//}

val downStep = 1
input.tail.grouped(downStep).map((x) => {
  println(x.lift(0))
  x.take(0)
}).toList
//  .flatMap(_.take(downStep-1))
//  .zip(LazyList from 1).foldLeft(0) {
//  case (acc, (line, pos)) => {
//    if (line.charAt(((pos)*rightStep) % lineLength) == '#') acc + 1
//    else acc
//  }
//}

//input.toList.zipWithIndex.map{
//  case Tuple2(l, i) =>
//                if (highlightPos.contains(i)) s"($l)"
//                else if (i!= 0 && i % lineLength == 0) s"\n$l"
//                else l
//}.mkString("")

input.tail.zip(LazyList from 1)