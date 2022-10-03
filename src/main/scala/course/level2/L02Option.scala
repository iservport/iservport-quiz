package course.level2

object L02Option extends App {

    val nullValue = null
    val opt1 = Option(nullValue)
    val numberValue = 1
    val opt2 = Option(numberValue)
    val v1 = opt1.getOrElse(0)
    val v2 = opt2.get
    val v3 = opt2.fold(0)(_ + 1) // opt2.fold(0)(_ + 1)
    println(s"opt1 = $opt1")
    println(s"opt2 = $opt2")
    println(s"v1 = $v1")
    println(s"v2 = $v2")
    println(s"v3 = $v3")
  }