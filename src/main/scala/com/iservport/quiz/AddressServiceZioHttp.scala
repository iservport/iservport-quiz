package com.iservport.quiz

import zhttp.http.Response
import zhttp.service.{ChannelFactory, Client, EventLoopGroup}
import zio._

import scala.concurrent.Future

object AddressServiceZioHttp {

  val env: ULayer[ChannelFactory with EventLoopGroup] =
    ChannelFactory.auto ++ EventLoopGroup.auto()

  import zio._

  private def request(url: String): ZIO[Any, Throwable, String] =
    (for {
      res  <- Client.request(url)
      json <- res.body.asString
    } yield json).provide(env)

  def get(url: String): Future[String] =
    Unsafe.unsafe { implicit unsafe =>
      val runtime: Runtime.Scoped[Any] = Runtime.unsafe.fromLayer(env)
      runtime.unsafe.runToFuture(request(url))
    }
}