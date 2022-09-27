package com.iservport.quiz

import com.iservport.quiz.SampleModel.StreetAddress
import zhttp.http.Response
import zio.json.{DecoderOps, DeriveJsonDecoder, JsonDecoder}

import scala.concurrent.Future

class SampleConnector {

  val prefix = "http://cdn.apicep.com/file/apicep/"

  import scala.concurrent.ExecutionContext.Implicits.global

  case class StreetAddressResponse(status: String, code: String, state: String, city: String, district: String, address: String)
  object StreetAddressResponse {
    implicit val decoder: JsonDecoder[StreetAddressResponse] = DeriveJsonDecoder.gen[StreetAddressResponse]
  }

  def getAddressFromPostalCode(postalCode: String): Future[Either[String, StreetAddress]] =
    for {
      response <- AddressServiceZioHttp.get(s"$prefix$postalCode.json")
    } yield {
      val bodyAsString = response.body.toString
      bodyAsString.fromJson[StreetAddressResponse] map { streetAddress =>
        StreetAddress(streetAddress.address, streetAddress.code, streetAddress.district, streetAddress.city, streetAddress.state)
      }
    }
}
