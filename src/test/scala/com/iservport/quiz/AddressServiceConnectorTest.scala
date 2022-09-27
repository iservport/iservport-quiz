package com.iservport.quiz

import org.apache.hc.client5.http.async.methods.SimpleHttpResponse
import org.scalatest.EitherValues
import org.scalatest.concurrent.Futures
import org.scalatest.concurrent.PatienceConfiguration.Timeout
import org.scalatest.concurrent.ScalaFutures.convertScalaFuture
import org.scalatest.matchers.must.Matchers
import org.scalatest.time.{Seconds, Span}
import org.scalatest.wordspec.AsyncWordSpec

import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}

class AddressServiceConnectorTest extends AsyncWordSpec with Matchers with EitherValues with Futures {

  "AddressServiceConnector" should {

    "GET" in {

      val future = AddressServiceZioHttp.get("80620-010").futureValue(Timeout(Span(5, Seconds)))
      println(future)
      succeed
    }
  }

}
