package com.afronski.http4s.starter

import org.http4s.server._
import org.http4s.server.blaze.BlazeBuilder

object HelloWorldExample extends App {
  BlazeBuilder
    .bindHttp(8080)
    .mountService(HelloWorld.service, "/")
    .run
    .awaitShutdown()
}