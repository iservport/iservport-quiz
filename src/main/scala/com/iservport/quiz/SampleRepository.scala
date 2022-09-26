package com.iservport.quiz

import com.iservport.quiz.SampleModel.StreetAddress
import io.getquill.{EntityQuery, Quoted}

class SampleRepository {

  import H2ConnectionPool.ctx
  import ctx._

  private val streetAddresses: Quoted[EntityQuery[StreetAddress]] = quote {
    querySchema[StreetAddress]("street_address")
  }

  def selectAddressById(id: Int): Option[StreetAddress] =
    ctx.run(streetAddresses.filter(address => address.id == lift(id))).headOption
}
