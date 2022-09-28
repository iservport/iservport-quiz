package com.iservport.quiz

import com.iservport.quiz.PostalCodeConnector.StreetAddressResponse
import com.iservport.quiz.SampleModel.StreetAddress
import zio.json.{DecoderOps, DeriveJsonDecoder, JsonDecoder}

import scala.concurrent.Future

class PostalCodeConnector {

  val prefix = "http://cdn.apicep.com/file/apicep"

  import scala.concurrent.ExecutionContext.Implicits.global

  def getAddressFromPostalCode(postalCode: String): Future[Either[String, StreetAddress]] = // TODO introduce ErrorModel
    for {
      json <- AddressServiceZioHttp.get(s"$prefix/$postalCode.json")
    } yield json.fromJson[StreetAddressResponse] map { _.asStreetAddress }
}
object PostalCodeConnector {

  case class StreetAddressResponse(status: Int, code: String, state: String, city: String, district: String, address: String) {
    def asStreetAddress: StreetAddress = StreetAddress(address, code, district, city, state)
  }
  object StreetAddressResponse {
    implicit val decoder: JsonDecoder[StreetAddressResponse] = DeriveJsonDecoder.gen[StreetAddressResponse]
  }
}
