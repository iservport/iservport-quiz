package course.level2

import scala.util.Try

object L03Either extends App {

    val invert: Int => Try[Double] = value => Try (1 / value)
    val success = invert(1)
    val failure = invert(0)
    val right = success.toEither
    val left = failure.toEither
    def invert2(value: Int): Either[String, Double] = invert(value).toOption.toRight(s"Erro ao inverter $value.")
    println(s"Inversão de 1 = ${invert2(1)}")
    println(s"Inversão de 0 = ${invert2(0)}")
  }