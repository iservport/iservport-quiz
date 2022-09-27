package com.iservport.quiz

import org.apache.hc.client5.http.async.methods.{SimpleHttpRequest, SimpleHttpResponse, SimpleRequestBuilder}
import org.apache.hc.client5.http.impl.async.{CloseableHttpAsyncClient, HttpAsyncClients}
import org.slf4j.LoggerFactory

import scala.concurrent.Future.successful
import scala.concurrent.{ExecutionContext, Future}
import scala.language.postfixOps
import scala.util.{Failure, Success, Try}


object AddressServiceApacheHttp {

  import ExecutionContext.Implicits.global

  val logger = LoggerFactory.getLogger(AddressServiceApacheHttp.getClass)

  val addressUrl = "http://httpbin.org/get"

  def get: Future[SampleResult[SimpleHttpResponse]] = {
    httpclient.fold (
      error => successful(Left(error)),
      client => {
        client.start()
        logger.info("Started")
        val request: SimpleHttpRequest = SimpleRequestBuilder.get(addressUrl).build()
        Future { client.execute(request, null).get } transformWith {
          case Success(response) =>
            logger.info("Response "+response)
            successful(Right(response))
          case Failure(e)        =>
            logger.error("Error "+e)
            successful(Left(HttpConnectionError(e.getMessage)))
        } andThen { _ =>
          logger.info("Closing connection...")
          client.close()
          logger.info("Closed.")
        }
      }
    )
  }

  val httpclient: SampleResult[CloseableHttpAsyncClient] = Try {
    HttpAsyncClients.createDefault
  } match {
    case Success(client) =>
      logger.info("Connected to "+client)
      Right(client)
    case Failure(e) =>
      logger.error("Connection error: "+e)
      Left(HttpConnectionError(e.getMessage))
  }

}