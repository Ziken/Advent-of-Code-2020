val input =
  """abc
    |
    |a
    |b
    |c
    |
    |ab
    |ac
    |
    |a
    |a
    |a
    |a
    |
    |b""".stripMargin

input.split("\n\n").map(s => s.split("\n").map(_.toSet).foldLeft(('a' to 'z').toSet)((acc, v) => {
    acc & v
  }).toList.length
).sum

Set('a', 'b', 'c') & Set('a', 'd')