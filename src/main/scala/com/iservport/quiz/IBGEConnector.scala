package com.iservport.quiz

import com.iservport.quiz.IBGEConnector.DistrictResponse
import com.iservport.quiz.SampleModel.StreetAddress
import zio.json.{DecoderOps, DeriveJsonDecoder, JsonDecoder}

import scala.concurrent.Future

class IBGEConnector {

  val prefix = "https://servicodados.ibge.gov.br/api"

  import scala.concurrent.ExecutionContext.Implicits.global

  def getAddressFromPostalCode(postalCode: String): Future[Either[String, List[DistrictResponse]]] = // TODO introduce ErrorModel
    for {
      json <- AddressServiceZioHttp.get(s"$prefix/v1/localidades/distritos")
    } yield json.fromJson[List[DistrictResponse]]
}
object IBGEConnector {

  case class RegionResponse(id: Int, nome: String, microregiao: Option[RegionResponse])
  object RegionResponse {
    implicit val decoder: JsonDecoder[RegionResponse] = DeriveJsonDecoder.gen[RegionResponse]
  }

  case class CityResponse(id: Int, nome: String, microregiao: String, regiaoImediata: String)
  object CityResponse {
    implicit val decoder: JsonDecoder[CityResponse] = DeriveJsonDecoder.gen[CityResponse]
  }

  case class DistrictResponse(id: Int, nome: String, municipio: CityResponse)
  object DistrictResponse {
    implicit val decoder: JsonDecoder[DistrictResponse] = DeriveJsonDecoder.gen[DistrictResponse]
  }
}
