package course.level2

object L06Comprehension extends App {
  val x: Unit = for {
    par <- Seq(2, 4, 6)
    impar <- Seq(1, 3, 5)
  } { // internally uses foreach
    print(s"[$impar, $par] ")
  }
  println()
  val y: Seq[String] = for {
    par <- Seq(2, 4, 6)
    impar <- Seq(1, 3, 5)
  } yield {  // internally uses flatMap
    s"[$impar, $par] "
  }
  println(y.mkString)
  val z: Unit = for {
    par <- Seq(2, 4, 6)
    impar <- Seq(1, 3, 5)
    if par+impar < 7
  } { // internally uses foreach
    print(s"[$impar, $par] ")
  }
  println()
  val b: Either[Int, Int] = for {
    r <- Right[Int, Int](10)
    s <- Left[Int, Int](1)
    t <- Right[Int, Int](5)
  } yield {
    r * s * t
  }
println(b)
}
