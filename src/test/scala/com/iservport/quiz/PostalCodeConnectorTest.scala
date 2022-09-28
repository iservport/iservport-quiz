package com.iservport.quiz

import com.iservport.quiz.SampleModel.StreetAddress
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

class PostalCodeConnectorTest extends AsyncWordSpec with Matchers with EitherValues with Futures {

  "SampleConnector" should {

    "GET" in {

      val connector = new PostalCodeConnector
      val address: Either[String, StreetAddress] = connector.getAddressFromPostalCode("80620-010").futureValue(Timeout(Span(5, Seconds)))
      address.value.description mustBe "Avenida República Argentina - de 826/827 a 2079/2080"
    }
  }

}