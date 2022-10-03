package course.level1

object L04CaseClass extends App {
    case class Rectangle(l1: Double, l2: Double)
    val result = Rectangle(2, 3) match {
      case Rectangle(_, b) if b < 5 => "Altura insuficiente"
      case Rectangle(a, b)          => s"Área ${a * b}"
      case _                        => "Inválido"
    }
    println(result)
  }