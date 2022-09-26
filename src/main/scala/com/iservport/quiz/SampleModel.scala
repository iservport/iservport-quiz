package com.iservport.quiz

import java.time.Instant

object SampleModel {

  case class StreetAddress(id: Int, description: String, postal_code: String, city: String, State: String, country: String = "BR", submission_date: Instant)

  sealed abstract class Country(val iso2: String, countryName: String)
  case object Brazil extends Country("BR", "Brazil")
  case object UnitedKingdom extends Country("GB", "United Kingdom")
}
