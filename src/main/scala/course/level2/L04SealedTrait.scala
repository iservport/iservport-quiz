package course.level2

object L04SealedTrait {

    sealed trait ErrorModel

    case class NotFound(idx: Int) extends ErrorModel
    case class Invalid(value: String) extends ErrorModel
    // other errors
  }