package com.iservport.quiz

import zhttp.http.Response
import zhttp.service.{ChannelFactory, Client, EventLoopGroup}
import zio._

import scala.concurrent.Future

object AddressServiceZioHttp {

  val env: ULayer[ChannelFactory with EventLoopGroup] =
    ChannelFactory.auto ++ EventLoopGroup.auto()

  import zio._

  private def request(url: String): ZIO[ChannelFactory with EventLoopGroup, Throwable, Response] =
    for {
      res  <- Client.request(url)
    } yield res

  def get(url: String): Future[Response] =
    Unsafe.unsafe { implicit unsafe =>
      val runtime: Runtime.Scoped[ChannelFactory with EventLoopGroup] = Runtime.unsafe.fromLayer(env)
      runtime.unsafe.runToFuture(request(url))
    }
}