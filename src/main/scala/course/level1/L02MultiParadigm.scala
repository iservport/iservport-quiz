package course.level1

object L02MultiParadigm extends App {

  val x1 = "Hey"
  val x2 = s"$x1 Dude, it is ${Math.random()}"
  def x3 = s"Value is eager ${Math.random()}"

  println(x1)
  println(x2)
  println(x2)
  println(x3)
  println(x3)
}
