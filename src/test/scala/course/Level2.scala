package course

import scala.util.Try

object Level2 {

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

  object L03Either {

    val invert: Int => Try[Double] = value => Try (1 / value)
    val success = invert(1)
    val failure = invert(0)
    val right = success.toEither
    val left = failure.toEither
    def invert2(value: Int): Either[String, Double] = invert(value).toOption.toRight(s"Erro ao inverter $value.")
    println(s"Inversão de 1 = ${invert2(1)}")
    println(s"Inversão de 0 = ${invert2(0)}")
  }

  object L04SealedTrait {

    sealed trait ErrorModel

    case class NotFound(idx: Int) extends ErrorModel
    case class Invalid(value: String) extends ErrorModel
    // other errors
  }
}
