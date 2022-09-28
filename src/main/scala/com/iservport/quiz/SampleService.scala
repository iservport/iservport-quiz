package com.iservport.quiz

import com.iservport.quiz.SampleModel.StreetAddress

class SampleService(repository: SampleRepository, connector: PostalCodeConnector) {

  def validateAddress(): SampleResult[StreetAddress] =
    for {
      x <- repository.selectAddressById(1).toRight(NotFound(""))
    } yield x
}
