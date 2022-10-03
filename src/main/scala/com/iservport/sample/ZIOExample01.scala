package com.iservport.sample

import zio._
import zio.stream._

object ZIOExample01 extends ZIOAppDefault {

    val stream: ZStream[Any, Nothing, Int] =
      ZStream.fromIterable(1 to 100)

    val run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] =
      stream.foreach(i => Console.printLine(i))
  }