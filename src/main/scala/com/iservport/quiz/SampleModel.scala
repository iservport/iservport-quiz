package com.iservport.quiz

import java.time.Instant

object SampleModel {

  case class StreetAddress(description: String, postal_code: String, district: String, city: String, state: String, country: String = "BR", id: Int = 0, submission_date: Instant = Instant.now())

  sealed abstract class Country(val iso2: String, countryName: String)
  case object Brazil extends Country("BR", "Brazil")
  case object UnitedKingdom extends Country("GB", "United Kingdom")
}
