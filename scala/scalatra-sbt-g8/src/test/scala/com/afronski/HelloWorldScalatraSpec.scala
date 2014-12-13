package com.afronski

import org.scalatra.test.specs2._

// For more on Specs2, see http://etorreborre.github.com/specs2/guide/org.specs2.guide.QuickStart.html
class HelloWorldScalatraSpec extends ScalatraSpec { def is =
  "GET / on HelloWorldScalatra"                     ^
    "should return status 200"                  ! root200^
                                                end

  addServlet(classOf[HelloWorldScalatra], "/*")

  def root200 = get("/") {
    status must_== 200
  }
}
