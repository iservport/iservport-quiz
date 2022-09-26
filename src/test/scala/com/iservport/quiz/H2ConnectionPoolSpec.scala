package com.iservport.quiz

import com.zaxxer.hikari.HikariDataSource
import io.getquill.SnakeCase
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.language.postfixOps

class H2ConnectionPoolSpec extends AnyWordSpec with Matchers {

  "H2Bd" should {

    val ctx = H2ConnectionPool.ctx

    "Create a Quill H2 context from properties" in {

      ctx.dataSource.isInstanceOf[HikariDataSource] mustBe true
      ctx.naming.isInstanceOf[SnakeCase] mustBe true
      ctx.dataSource.getConnection.getMetaData.getURL mustBe "jdbc:h2:mem:test"
      ctx.dataSource.getConnection.getMetaData.getUserName mustBe "SA"
    }

    "Run DDL" in {

      val conn = ctx.dataSource.getConnection // use plain jdbc to test
      val preparedStatement = conn.prepareStatement("select * from street_address where id = 1;")
      val resultSet = preparedStatement.executeQuery()
      resultSet.next() mustBe true
      resultSet.getInt("id") mustBe 1
      resultSet.getString("description") mustBe "Trafalgar Square"
    }
  }
}
