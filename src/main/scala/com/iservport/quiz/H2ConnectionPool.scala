package com.iservport.quiz

import io.getquill.{H2JdbcContext, SnakeCase}

object H2ConnectionPool {

  lazy val ctx: H2JdbcContext[SnakeCase.type] = new H2JdbcContext(SnakeCase, "ctx")
}
