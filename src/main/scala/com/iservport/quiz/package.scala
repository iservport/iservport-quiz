package com.iservport

package object quiz {

  type SampleResult[A] = Either[SampleError, A]

  sealed trait SampleError

  case class DbConnectionError(connection: String) extends SampleError
  case class HttpConnectionError(connection: String) extends SampleError
  case class NotFound(search: String) extends SampleError
}
