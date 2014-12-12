package com.afronski.scalatra.starter

import org.scalatra._

class HelloWorldExample extends ScalatraServlet {
  get("/hello") {
    "Hello, World!"
  }
}