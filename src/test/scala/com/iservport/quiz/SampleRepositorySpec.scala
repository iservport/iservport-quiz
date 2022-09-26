package com.iservport.quiz

import org.scalatest.BeforeAndAfterEach
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.mockito.MockitoSugar

class SampleRepositorySpec extends AnyWordSpec with Matchers with MockitoSugar with BeforeAndAfterEach {

  "Sample repository" should {

    "Read actual test data" in {

      val repository = new SampleRepository
      val nationalGalleryAddress = repository.selectAddressById(1)
      nationalGalleryAddress.map(_.id) mustBe Some(1)
    }
  }
}
