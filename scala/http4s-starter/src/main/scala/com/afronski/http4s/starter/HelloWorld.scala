package com.afronski.http4s.starter

import scala.concurrent.{ ExecutionContext, Future }

import org.http4s.dsl._
import org.http4s.server._

import org.http4s.dsl./

object HelloWorld {
  def service(implicit executionContext: ExecutionContext = ExecutionContext.global) = HttpService {
    case GET -> Root / "hello" =>
      Ok("Hello, World!")
  }
}